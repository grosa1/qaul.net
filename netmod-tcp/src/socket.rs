use crate::{Mode, Packet, PeerList, PeerState, Result};
use async_std::{
    io::{
        self,
        prelude::{ReadExt, WriteExt},
    },
    net::{TcpListener, TcpStream},
    stream::StreamExt,
    sync::{channel, Arc, Receiver, RwLock, Sender},
    task,
};
use bincode::{deserialize, serialize};
use byteorder::{BigEndian, ByteOrder};
use netmod::Frame;
use std::{collections::BTreeMap, net::SocketAddr, time::Duration};

/// A wrapper around tcp socket logic
pub(crate) struct Socket {
    inner: TcpListener,
    streams: RwLock<BTreeMap<usize, TcpStream>>,
    port: u16,
    pub id: String,
}

impl Socket {
    pub(crate) async fn new(addr: &str, port: u16, id: &str) -> Result<Arc<Self>> {
        Ok(TcpListener::bind(format!("{}:{}", addr, port))
            .await
            .map(|inner| {
                Arc::new(Self {
                    inner,
                    streams: RwLock::new(BTreeMap::new()),
                    port,
                    id: id.into(),
                })
            })?)
    }

    /// Send a fully encoded packet to a peer.  At this point
    /// connection checking has already been done
    pub(crate) async fn send(self: Arc<Self>, peer: SocketAddr, data: Frame) -> Result<()> {
        unimplemented!()
    }

    /// Start peering by sending a Hello packet
    pub(crate) async fn introduce(self: &Arc<Self>, id: usize, ip: SocketAddr) -> Option<()> {
        if self.streams.read().await.contains_key(&id) {
            return None;
        }

        let mut s = TcpStream::connect(ip).await.unwrap();
        self.streams.write().await.insert(id, s.clone());

        &self.streams.read().await;
        send_packet(&mut s, Packet::Hello { port: self.port }, &self.id).await;
        Some(())
    }

    /// Run the async
    pub(crate) fn start(self: &Arc<Self>, mode: Mode, peers: &Arc<PeerList>) -> Receiver<Frame> {
        let socket = Arc::clone(&self);
        let peers = Arc::clone(peers);
        let (tx, rx) = channel(1);
        task::spawn(Self::run(tx, mode, socket, peers));
        rx
    }

    async fn run(tx: Sender<Frame>, mode: Mode, socket: Arc<Self>, peers: Arc<PeerList>) {
        let mut inc = socket.inner.incoming();

        println!(
            "{} Listening for: {:?}",
            socket.id,
            socket.inner.local_addr()
        );
        while let Some(Ok(mut stream)) = inc.next().await {
            loop {
                let addr = match stream.peer_addr() {
                    Ok(a) => a,
                    Err(_) => continue,
                };

                // Drop unknown connections
                let state = peers.peer_state(&addr).await;
                if state == PeerState::Unknown && !mode.dynamic() {
                    println!(
                        "{} Connection from unknown peer `{}`, closing!",
                        socket.id, addr
                    );
                    break;
                }

                // Try to read a packet
                let mut fb = PacketBuilder::new(&mut stream);
                fb.parse().await.unwrap(); // TODO: Don't panic!
                let f = fb.build().unwrap();

                println!("{} Full packet `{:?}` received!", socket.id, f);

                // Disambiguate differente packet types
                match (f, state) {
                    // Forward to inbox
                    (Packet::Frame(f), PeerState::Valid) => tx.send(f).await,
                    (Packet::Frame(_), PeerState::Unverified) => {
                        println!(
                            "Dropping incoming packet because peer {:?} is unverified!",
                            &addr
                        );
                    }

                    // Add to stream/ peer list
                    (Packet::Hello { port }, PeerState::Unverified) => {
                        let id = peers.add_src(&addr, port).await.unwrap();
                        let dst = peers.get_dst_by_src(&addr).await.unwrap();

                        // When we have already introduced ourselves, but
                        // the peer wasn't previously verified because we
                        // hadn't gotten a message from them, we need to
                        // cancel introduction and just switch to sending
                        // a keep-alive.
                        if socket.introduce(id, dst).await.is_none() {
                            let mut stream = get_stream(&socket.streams, id).await;
                            send_packet(&mut stream, Packet::KeepAlive, &socket.id).await;
                        }
                    }
                    (Packet::Hello { port: _ }, PeerState::Valid) => {
                        let id = peers.get_id_by_src(&addr).await.unwrap();
                        let mut stream = get_stream(&socket.streams, id).await;
                        send_packet(&mut stream, Packet::KeepAlive, &socket.id).await;
                    }

                    // Reply to a keep-alive with 2seconds delay
                    (Packet::KeepAlive, _) => {
                        let peers = Arc::clone(&peers);
                        let id = peers.get_id_by_src(&addr).await.unwrap();
                        let mut stream = get_stream(&socket.streams, id).await;
                        let node_id = socket.id.clone();
                        task::spawn(async move {
                            task::sleep(Duration::from_secs(2)).await;
                            println!("{} Replying to keep-alive!", node_id);
                            send_packet(&mut stream, Packet::KeepAlive, &node_id).await;
                        });
                    }
                    (packet, state) => {
                        panic!(format!("Failed with tuple: {:?}, {:?}", packet, state))
                    }
                }
            }

            println!("{} Exited read-work loop!", socket.id);
        }

        println!("{} Exited listen loop!", socket.id);
    }
}

async fn get_stream(streams: &RwLock<BTreeMap<usize, TcpStream>>, id: usize) -> TcpStream {
    let s = streams.read().await;
    s.get(&id)
        .expect(&format!("No stream for id: {}", id))
        .clone()
}

async fn send_packet(stream: &mut TcpStream, packet: Packet, id: &str) {
    let mut vec = serialize(&packet).unwrap();
    match packet {
        Packet::Hello { .. } => println!("{} Sending HELLO to {:?}", id, stream.peer_addr()),
        Packet::KeepAlive => println!("{} Sending KEEP-ALIVE to {:?}", id, stream.peer_addr()),
        _ => {}
    }

    let mut buf = vec![0; 8];
    BigEndian::write_u64(&mut buf, vec.len() as u64);
    buf.append(&mut vec);

    if let Err(e) = stream.write_all(&buf).await {
        println!("{} Failed to send data: {:?}", id, e);
    }
}

struct PacketBuilder<'s> {
    stream: &'s mut TcpStream,
    data: Option<Vec<u8>>,
}

impl<'s> PacketBuilder<'s> {
    /// Create a new frame builder from a stream
    fn new(stream: &'s mut TcpStream) -> Self {
        Self { stream, data: None }
    }

    /// Parse incoming data and initialise the builder
    async fn parse(&mut self) -> io::Result<()> {
        let mut len_buf = [0; 8];
        self.stream.read_exact(&mut len_buf).await?;
        let len = BigEndian::read_u64(&len_buf);

        let mut data_buf = vec![0; len as usize];
        self.stream.read_exact(&mut data_buf).await?;
        self.data = Some(data_buf);
        Ok(())
    }

    /// Consume the builder and maybe return a frame
    fn build(self) -> Option<Packet> {
        self.data.and_then(|vec| deserialize(&vec).ok())
    }
}

#[async_std::test]
async fn simple_send() {
    use std::net::{Ipv4Addr, SocketAddrV4};

    let s1 = Socket::new("127.0.0.1", 8000, "A =").await.unwrap();
    let s1_addr = SocketAddrV4::new(Ipv4Addr::new(127, 0, 0, 1), 8000);
    let p1 = PeerList::new();

    let s2 = Socket::new("127.0.0.1", 9000, "B =").await.unwrap();
    let s2_addr = SocketAddrV4::new(Ipv4Addr::new(127, 0, 0, 1), 9000);
    let p2 = PeerList::new();

    // Make p1 load p2's address, and vice versa
    p1.load(vec![s2_addr]).await.unwrap();
    p2.load(vec![s1_addr]).await.unwrap();

    s1.start(Mode::Static, &p1);
    s2.start(Mode::Static, &p2);

    // Make p1 introduce itself to p2
    let id = p1.get_id_by_dst(&s2_addr.into()).await.unwrap();
    s1.introduce(id, s2_addr.into()).await;

    // Give the test some time to run
    task::sleep(Duration::from_secs(10)).await;
}
