// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc/qaul_rpc.proto

package qaul.rpc;

public final class QaulRpcOuterClass {
  private QaulRpcOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * <pre>
   * Identification to which module the message shall be
   * handed to.
   * </pre>
   *
   * Protobuf enum {@code qaul.rpc.Modules}
   */
  public enum Modules
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <pre>
     * default value, when nothing is defined.
     * drop this message
     * </pre>
     *
     * <code>NONE = 0;</code>
     */
    NONE(0),
    /**
     * <pre>
     * RPC related messages
     * such as authorisation etc.
     * </pre>
     *
     * <code>RPC = 1;</code>
     */
    RPC(1),
    /**
     * <pre>
     * node information
     * </pre>
     *
     * <code>NODE = 2;</code>
     */
    NODE(2),
    /**
     * <pre>
     * user accounts on this node
     * </pre>
     *
     * <code>USERACCOUNTS = 3;</code>
     */
    USERACCOUNTS(3),
    /**
     * <pre>
     * all users in the network
     * </pre>
     *
     * <code>USERS = 4;</code>
     */
    USERS(4),
    /**
     * <pre>
     * routing information
     * </pre>
     *
     * <code>ROUTER = 5;</code>
     */
    ROUTER(5),
    /**
     * <pre>
     * feed module handling
     * send and retrieve feed messages
     * </pre>
     *
     * <code>FEED = 6;</code>
     */
    FEED(6),
    /**
     * <pre>
     * connection information to other nodes
     * </pre>
     *
     * <code>CONNECTIONS = 7;</code>
     */
    CONNECTIONS(7),
    /**
     * <pre>
     * debug information &amp; settings
     * </pre>
     *
     * <code>DEBUG = 8;</code>
     */
    DEBUG(8),
    /**
     * <pre>
     * chat group handling
     * manage chat groups and group invites
     * </pre>
     *
     * <code>GROUP = 9;</code>
     */
    GROUP(9),
    /**
     * <pre>
     * chat module
     * to send chat messages, get a
     * conversation overiew and all
     * messages within a conversation
     * </pre>
     *
     * <code>CHAT = 10;</code>
     */
    CHAT(10),
    /**
     * <pre>
     * all functions to send and manage
     * files sent into a chat conversation
     * </pre>
     *
     * <code>CHATFILE = 11;</code>
     */
    CHATFILE(11),
    /**
     * <pre>
     * BLE module handling
     * </pre>
     *
     * <code>BLE = 12;</code>
     */
    BLE(12),
    /**
     * <pre>
     * Real Time Communication handling
     * </pre>
     *
     * <code>RTC = 13;</code>
     */
    RTC(13),
    /**
     * <pre>
     * Delay Tolerant Networking
     * </pre>
     *
     * <code>DTN = 14;</code>
     */
    DTN(14),
    UNRECOGNIZED(-1),
    ;

    /**
     * <pre>
     * default value, when nothing is defined.
     * drop this message
     * </pre>
     *
     * <code>NONE = 0;</code>
     */
    public static final int NONE_VALUE = 0;
    /**
     * <pre>
     * RPC related messages
     * such as authorisation etc.
     * </pre>
     *
     * <code>RPC = 1;</code>
     */
    public static final int RPC_VALUE = 1;
    /**
     * <pre>
     * node information
     * </pre>
     *
     * <code>NODE = 2;</code>
     */
    public static final int NODE_VALUE = 2;
    /**
     * <pre>
     * user accounts on this node
     * </pre>
     *
     * <code>USERACCOUNTS = 3;</code>
     */
    public static final int USERACCOUNTS_VALUE = 3;
    /**
     * <pre>
     * all users in the network
     * </pre>
     *
     * <code>USERS = 4;</code>
     */
    public static final int USERS_VALUE = 4;
    /**
     * <pre>
     * routing information
     * </pre>
     *
     * <code>ROUTER = 5;</code>
     */
    public static final int ROUTER_VALUE = 5;
    /**
     * <pre>
     * feed module handling
     * send and retrieve feed messages
     * </pre>
     *
     * <code>FEED = 6;</code>
     */
    public static final int FEED_VALUE = 6;
    /**
     * <pre>
     * connection information to other nodes
     * </pre>
     *
     * <code>CONNECTIONS = 7;</code>
     */
    public static final int CONNECTIONS_VALUE = 7;
    /**
     * <pre>
     * debug information &amp; settings
     * </pre>
     *
     * <code>DEBUG = 8;</code>
     */
    public static final int DEBUG_VALUE = 8;
    /**
     * <pre>
     * chat group handling
     * manage chat groups and group invites
     * </pre>
     *
     * <code>GROUP = 9;</code>
     */
    public static final int GROUP_VALUE = 9;
    /**
     * <pre>
     * chat module
     * to send chat messages, get a
     * conversation overiew and all
     * messages within a conversation
     * </pre>
     *
     * <code>CHAT = 10;</code>
     */
    public static final int CHAT_VALUE = 10;
    /**
     * <pre>
     * all functions to send and manage
     * files sent into a chat conversation
     * </pre>
     *
     * <code>CHATFILE = 11;</code>
     */
    public static final int CHATFILE_VALUE = 11;
    /**
     * <pre>
     * BLE module handling
     * </pre>
     *
     * <code>BLE = 12;</code>
     */
    public static final int BLE_VALUE = 12;
    /**
     * <pre>
     * Real Time Communication handling
     * </pre>
     *
     * <code>RTC = 13;</code>
     */
    public static final int RTC_VALUE = 13;
    /**
     * <pre>
     * Delay Tolerant Networking
     * </pre>
     *
     * <code>DTN = 14;</code>
     */
    public static final int DTN_VALUE = 14;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static Modules valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static Modules forNumber(int value) {
      switch (value) {
        case 0: return NONE;
        case 1: return RPC;
        case 2: return NODE;
        case 3: return USERACCOUNTS;
        case 4: return USERS;
        case 5: return ROUTER;
        case 6: return FEED;
        case 7: return CONNECTIONS;
        case 8: return DEBUG;
        case 9: return GROUP;
        case 10: return CHAT;
        case 11: return CHATFILE;
        case 12: return BLE;
        case 13: return RTC;
        case 14: return DTN;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<Modules>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        Modules> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<Modules>() {
            public Modules findValueByNumber(int number) {
              return Modules.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalStateException(
            "Can't get the descriptor of an unrecognized enum value.");
      }
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return qaul.rpc.QaulRpcOuterClass.getDescriptor().getEnumTypes().get(0);
    }

    private static final Modules[] VALUES = values();

    public static Modules valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private Modules(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:qaul.rpc.Modules)
  }

  public interface QaulRpcOrBuilder extends
      // @@protoc_insertion_point(interface_extends:qaul.rpc.QaulRpc)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * which module to approach
     * </pre>
     *
     * <code>.qaul.rpc.Modules module = 1;</code>
     * @return The enum numeric value on the wire for module.
     */
    int getModuleValue();
    /**
     * <pre>
     * which module to approach
     * </pre>
     *
     * <code>.qaul.rpc.Modules module = 1;</code>
     * @return The module.
     */
    qaul.rpc.QaulRpcOuterClass.Modules getModule();

    /**
     * <pre>
     * can be used to identify responses
     * </pre>
     *
     * <code>string request_id = 2;</code>
     * @return The requestId.
     */
    java.lang.String getRequestId();
    /**
     * <pre>
     * can be used to identify responses
     * </pre>
     *
     * <code>string request_id = 2;</code>
     * @return The bytes for requestId.
     */
    com.google.protobuf.ByteString
        getRequestIdBytes();

    /**
     * <pre>
     * authorisation
     * binary user id
     * </pre>
     *
     * <code>bytes user_id = 3;</code>
     * @return The userId.
     */
    com.google.protobuf.ByteString getUserId();

    /**
     * <pre>
     * the protobuf encoded binary message data
     * which is passed to the module.
     * </pre>
     *
     * <code>bytes data = 4;</code>
     * @return The data.
     */
    com.google.protobuf.ByteString getData();
  }
  /**
   * <pre>
   * The main libqaul RPC message container.
   * All RPC messages from and to libqaul are packed
   * into this container.
   * </pre>
   *
   * Protobuf type {@code qaul.rpc.QaulRpc}
   */
  public static final class QaulRpc extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:qaul.rpc.QaulRpc)
      QaulRpcOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use QaulRpc.newBuilder() to construct.
    private QaulRpc(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private QaulRpc() {
      module_ = 0;
      requestId_ = "";
      userId_ = com.google.protobuf.ByteString.EMPTY;
      data_ = com.google.protobuf.ByteString.EMPTY;
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new QaulRpc();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return qaul.rpc.QaulRpcOuterClass.internal_static_qaul_rpc_QaulRpc_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return qaul.rpc.QaulRpcOuterClass.internal_static_qaul_rpc_QaulRpc_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              qaul.rpc.QaulRpcOuterClass.QaulRpc.class, qaul.rpc.QaulRpcOuterClass.QaulRpc.Builder.class);
    }

    public static final int MODULE_FIELD_NUMBER = 1;
    private int module_;
    /**
     * <pre>
     * which module to approach
     * </pre>
     *
     * <code>.qaul.rpc.Modules module = 1;</code>
     * @return The enum numeric value on the wire for module.
     */
    @java.lang.Override public int getModuleValue() {
      return module_;
    }
    /**
     * <pre>
     * which module to approach
     * </pre>
     *
     * <code>.qaul.rpc.Modules module = 1;</code>
     * @return The module.
     */
    @java.lang.Override public qaul.rpc.QaulRpcOuterClass.Modules getModule() {
      @SuppressWarnings("deprecation")
      qaul.rpc.QaulRpcOuterClass.Modules result = qaul.rpc.QaulRpcOuterClass.Modules.valueOf(module_);
      return result == null ? qaul.rpc.QaulRpcOuterClass.Modules.UNRECOGNIZED : result;
    }

    public static final int REQUEST_ID_FIELD_NUMBER = 2;
    private volatile java.lang.Object requestId_;
    /**
     * <pre>
     * can be used to identify responses
     * </pre>
     *
     * <code>string request_id = 2;</code>
     * @return The requestId.
     */
    @java.lang.Override
    public java.lang.String getRequestId() {
      java.lang.Object ref = requestId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        requestId_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * can be used to identify responses
     * </pre>
     *
     * <code>string request_id = 2;</code>
     * @return The bytes for requestId.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getRequestIdBytes() {
      java.lang.Object ref = requestId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        requestId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int USER_ID_FIELD_NUMBER = 3;
    private com.google.protobuf.ByteString userId_;
    /**
     * <pre>
     * authorisation
     * binary user id
     * </pre>
     *
     * <code>bytes user_id = 3;</code>
     * @return The userId.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getUserId() {
      return userId_;
    }

    public static final int DATA_FIELD_NUMBER = 4;
    private com.google.protobuf.ByteString data_;
    /**
     * <pre>
     * the protobuf encoded binary message data
     * which is passed to the module.
     * </pre>
     *
     * <code>bytes data = 4;</code>
     * @return The data.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getData() {
      return data_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (module_ != qaul.rpc.QaulRpcOuterClass.Modules.NONE.getNumber()) {
        output.writeEnum(1, module_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(requestId_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, requestId_);
      }
      if (!userId_.isEmpty()) {
        output.writeBytes(3, userId_);
      }
      if (!data_.isEmpty()) {
        output.writeBytes(4, data_);
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (module_ != qaul.rpc.QaulRpcOuterClass.Modules.NONE.getNumber()) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(1, module_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(requestId_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, requestId_);
      }
      if (!userId_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(3, userId_);
      }
      if (!data_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(4, data_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof qaul.rpc.QaulRpcOuterClass.QaulRpc)) {
        return super.equals(obj);
      }
      qaul.rpc.QaulRpcOuterClass.QaulRpc other = (qaul.rpc.QaulRpcOuterClass.QaulRpc) obj;

      if (module_ != other.module_) return false;
      if (!getRequestId()
          .equals(other.getRequestId())) return false;
      if (!getUserId()
          .equals(other.getUserId())) return false;
      if (!getData()
          .equals(other.getData())) return false;
      if (!getUnknownFields().equals(other.getUnknownFields())) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + MODULE_FIELD_NUMBER;
      hash = (53 * hash) + module_;
      hash = (37 * hash) + REQUEST_ID_FIELD_NUMBER;
      hash = (53 * hash) + getRequestId().hashCode();
      hash = (37 * hash) + USER_ID_FIELD_NUMBER;
      hash = (53 * hash) + getUserId().hashCode();
      hash = (37 * hash) + DATA_FIELD_NUMBER;
      hash = (53 * hash) + getData().hashCode();
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static qaul.rpc.QaulRpcOuterClass.QaulRpc parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static qaul.rpc.QaulRpcOuterClass.QaulRpc parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static qaul.rpc.QaulRpcOuterClass.QaulRpc parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static qaul.rpc.QaulRpcOuterClass.QaulRpc parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static qaul.rpc.QaulRpcOuterClass.QaulRpc parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static qaul.rpc.QaulRpcOuterClass.QaulRpc parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static qaul.rpc.QaulRpcOuterClass.QaulRpc parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static qaul.rpc.QaulRpcOuterClass.QaulRpc parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static qaul.rpc.QaulRpcOuterClass.QaulRpc parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static qaul.rpc.QaulRpcOuterClass.QaulRpc parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static qaul.rpc.QaulRpcOuterClass.QaulRpc parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static qaul.rpc.QaulRpcOuterClass.QaulRpc parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(qaul.rpc.QaulRpcOuterClass.QaulRpc prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * <pre>
     * The main libqaul RPC message container.
     * All RPC messages from and to libqaul are packed
     * into this container.
     * </pre>
     *
     * Protobuf type {@code qaul.rpc.QaulRpc}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:qaul.rpc.QaulRpc)
        qaul.rpc.QaulRpcOuterClass.QaulRpcOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return qaul.rpc.QaulRpcOuterClass.internal_static_qaul_rpc_QaulRpc_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return qaul.rpc.QaulRpcOuterClass.internal_static_qaul_rpc_QaulRpc_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                qaul.rpc.QaulRpcOuterClass.QaulRpc.class, qaul.rpc.QaulRpcOuterClass.QaulRpc.Builder.class);
      }

      // Construct using qaul.rpc.QaulRpcOuterClass.QaulRpc.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        module_ = 0;

        requestId_ = "";

        userId_ = com.google.protobuf.ByteString.EMPTY;

        data_ = com.google.protobuf.ByteString.EMPTY;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return qaul.rpc.QaulRpcOuterClass.internal_static_qaul_rpc_QaulRpc_descriptor;
      }

      @java.lang.Override
      public qaul.rpc.QaulRpcOuterClass.QaulRpc getDefaultInstanceForType() {
        return qaul.rpc.QaulRpcOuterClass.QaulRpc.getDefaultInstance();
      }

      @java.lang.Override
      public qaul.rpc.QaulRpcOuterClass.QaulRpc build() {
        qaul.rpc.QaulRpcOuterClass.QaulRpc result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public qaul.rpc.QaulRpcOuterClass.QaulRpc buildPartial() {
        qaul.rpc.QaulRpcOuterClass.QaulRpc result = new qaul.rpc.QaulRpcOuterClass.QaulRpc(this);
        result.module_ = module_;
        result.requestId_ = requestId_;
        result.userId_ = userId_;
        result.data_ = data_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof qaul.rpc.QaulRpcOuterClass.QaulRpc) {
          return mergeFrom((qaul.rpc.QaulRpcOuterClass.QaulRpc)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(qaul.rpc.QaulRpcOuterClass.QaulRpc other) {
        if (other == qaul.rpc.QaulRpcOuterClass.QaulRpc.getDefaultInstance()) return this;
        if (other.module_ != 0) {
          setModuleValue(other.getModuleValue());
        }
        if (!other.getRequestId().isEmpty()) {
          requestId_ = other.requestId_;
          onChanged();
        }
        if (other.getUserId() != com.google.protobuf.ByteString.EMPTY) {
          setUserId(other.getUserId());
        }
        if (other.getData() != com.google.protobuf.ByteString.EMPTY) {
          setData(other.getData());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        if (extensionRegistry == null) {
          throw new java.lang.NullPointerException();
        }
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              case 8: {
                module_ = input.readEnum();

                break;
              } // case 8
              case 18: {
                requestId_ = input.readStringRequireUtf8();

                break;
              } // case 18
              case 26: {
                userId_ = input.readBytes();

                break;
              } // case 26
              case 34: {
                data_ = input.readBytes();

                break;
              } // case 34
              default: {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
            } // switch (tag)
          } // while (!done)
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.unwrapIOException();
        } finally {
          onChanged();
        } // finally
        return this;
      }

      private int module_ = 0;
      /**
       * <pre>
       * which module to approach
       * </pre>
       *
       * <code>.qaul.rpc.Modules module = 1;</code>
       * @return The enum numeric value on the wire for module.
       */
      @java.lang.Override public int getModuleValue() {
        return module_;
      }
      /**
       * <pre>
       * which module to approach
       * </pre>
       *
       * <code>.qaul.rpc.Modules module = 1;</code>
       * @param value The enum numeric value on the wire for module to set.
       * @return This builder for chaining.
       */
      public Builder setModuleValue(int value) {
        
        module_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * which module to approach
       * </pre>
       *
       * <code>.qaul.rpc.Modules module = 1;</code>
       * @return The module.
       */
      @java.lang.Override
      public qaul.rpc.QaulRpcOuterClass.Modules getModule() {
        @SuppressWarnings("deprecation")
        qaul.rpc.QaulRpcOuterClass.Modules result = qaul.rpc.QaulRpcOuterClass.Modules.valueOf(module_);
        return result == null ? qaul.rpc.QaulRpcOuterClass.Modules.UNRECOGNIZED : result;
      }
      /**
       * <pre>
       * which module to approach
       * </pre>
       *
       * <code>.qaul.rpc.Modules module = 1;</code>
       * @param value The module to set.
       * @return This builder for chaining.
       */
      public Builder setModule(qaul.rpc.QaulRpcOuterClass.Modules value) {
        if (value == null) {
          throw new NullPointerException();
        }
        
        module_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * which module to approach
       * </pre>
       *
       * <code>.qaul.rpc.Modules module = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearModule() {
        
        module_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object requestId_ = "";
      /**
       * <pre>
       * can be used to identify responses
       * </pre>
       *
       * <code>string request_id = 2;</code>
       * @return The requestId.
       */
      public java.lang.String getRequestId() {
        java.lang.Object ref = requestId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          requestId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <pre>
       * can be used to identify responses
       * </pre>
       *
       * <code>string request_id = 2;</code>
       * @return The bytes for requestId.
       */
      public com.google.protobuf.ByteString
          getRequestIdBytes() {
        java.lang.Object ref = requestId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          requestId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * can be used to identify responses
       * </pre>
       *
       * <code>string request_id = 2;</code>
       * @param value The requestId to set.
       * @return This builder for chaining.
       */
      public Builder setRequestId(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        requestId_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * can be used to identify responses
       * </pre>
       *
       * <code>string request_id = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearRequestId() {
        
        requestId_ = getDefaultInstance().getRequestId();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * can be used to identify responses
       * </pre>
       *
       * <code>string request_id = 2;</code>
       * @param value The bytes for requestId to set.
       * @return This builder for chaining.
       */
      public Builder setRequestIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        requestId_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString userId_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <pre>
       * authorisation
       * binary user id
       * </pre>
       *
       * <code>bytes user_id = 3;</code>
       * @return The userId.
       */
      @java.lang.Override
      public com.google.protobuf.ByteString getUserId() {
        return userId_;
      }
      /**
       * <pre>
       * authorisation
       * binary user id
       * </pre>
       *
       * <code>bytes user_id = 3;</code>
       * @param value The userId to set.
       * @return This builder for chaining.
       */
      public Builder setUserId(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        userId_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * authorisation
       * binary user id
       * </pre>
       *
       * <code>bytes user_id = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearUserId() {
        
        userId_ = getDefaultInstance().getUserId();
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString data_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <pre>
       * the protobuf encoded binary message data
       * which is passed to the module.
       * </pre>
       *
       * <code>bytes data = 4;</code>
       * @return The data.
       */
      @java.lang.Override
      public com.google.protobuf.ByteString getData() {
        return data_;
      }
      /**
       * <pre>
       * the protobuf encoded binary message data
       * which is passed to the module.
       * </pre>
       *
       * <code>bytes data = 4;</code>
       * @param value The data to set.
       * @return This builder for chaining.
       */
      public Builder setData(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        data_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * the protobuf encoded binary message data
       * which is passed to the module.
       * </pre>
       *
       * <code>bytes data = 4;</code>
       * @return This builder for chaining.
       */
      public Builder clearData() {
        
        data_ = getDefaultInstance().getData();
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:qaul.rpc.QaulRpc)
    }

    // @@protoc_insertion_point(class_scope:qaul.rpc.QaulRpc)
    private static final qaul.rpc.QaulRpcOuterClass.QaulRpc DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new qaul.rpc.QaulRpcOuterClass.QaulRpc();
    }

    public static qaul.rpc.QaulRpcOuterClass.QaulRpc getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<QaulRpc>
        PARSER = new com.google.protobuf.AbstractParser<QaulRpc>() {
      @java.lang.Override
      public QaulRpc parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        Builder builder = newBuilder();
        try {
          builder.mergeFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.setUnfinishedMessage(builder.buildPartial());
        } catch (com.google.protobuf.UninitializedMessageException e) {
          throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
        } catch (java.io.IOException e) {
          throw new com.google.protobuf.InvalidProtocolBufferException(e)
              .setUnfinishedMessage(builder.buildPartial());
        }
        return builder.buildPartial();
      }
    };

    public static com.google.protobuf.Parser<QaulRpc> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<QaulRpc> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public qaul.rpc.QaulRpcOuterClass.QaulRpc getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_qaul_rpc_QaulRpc_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_qaul_rpc_QaulRpc_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022rpc/qaul_rpc.proto\022\010qaul.rpc\"_\n\007QaulRp" +
      "c\022!\n\006module\030\001 \001(\0162\021.qaul.rpc.Modules\022\022\n\n" +
      "request_id\030\002 \001(\t\022\017\n\007user_id\030\003 \001(\014\022\014\n\004dat" +
      "a\030\004 \001(\014*\263\001\n\007Modules\022\010\n\004NONE\020\000\022\007\n\003RPC\020\001\022\010" +
      "\n\004NODE\020\002\022\020\n\014USERACCOUNTS\020\003\022\t\n\005USERS\020\004\022\n\n" +
      "\006ROUTER\020\005\022\010\n\004FEED\020\006\022\017\n\013CONNECTIONS\020\007\022\t\n\005" +
      "DEBUG\020\010\022\t\n\005GROUP\020\t\022\010\n\004CHAT\020\n\022\014\n\010CHATFILE" +
      "\020\013\022\007\n\003BLE\020\014\022\007\n\003RTC\020\r\022\007\n\003DTN\020\016b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_qaul_rpc_QaulRpc_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_qaul_rpc_QaulRpc_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_qaul_rpc_QaulRpc_descriptor,
        new java.lang.String[] { "Module", "RequestId", "UserId", "Data", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
