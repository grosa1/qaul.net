// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc/qaul_rpc.proto

#ifndef GOOGLE_PROTOBUF_INCLUDED_rpc_2fqaul_5frpc_2eproto
#define GOOGLE_PROTOBUF_INCLUDED_rpc_2fqaul_5frpc_2eproto

#include <limits>
#include <string>

#include <google/protobuf/port_def.inc>
#if PROTOBUF_VERSION < 3021000
#error This file was generated by a newer version of protoc which is
#error incompatible with your Protocol Buffer headers. Please update
#error your headers.
#endif
#if 3021007 < PROTOBUF_MIN_PROTOC_VERSION
#error This file was generated by an older version of protoc which is
#error incompatible with your Protocol Buffer headers. Please
#error regenerate this file with a newer version of protoc.
#endif

#include <google/protobuf/port_undef.inc>
#include <google/protobuf/io/coded_stream.h>
#include <google/protobuf/arena.h>
#include <google/protobuf/arenastring.h>
#include <google/protobuf/generated_message_util.h>
#include <google/protobuf/metadata_lite.h>
#include <google/protobuf/generated_message_reflection.h>
#include <google/protobuf/message.h>
#include <google/protobuf/repeated_field.h>  // IWYU pragma: export
#include <google/protobuf/extension_set.h>  // IWYU pragma: export
#include <google/protobuf/generated_enum_reflection.h>
#include <google/protobuf/unknown_field_set.h>
// @@protoc_insertion_point(includes)
#include <google/protobuf/port_def.inc>
#define PROTOBUF_INTERNAL_EXPORT_rpc_2fqaul_5frpc_2eproto
PROTOBUF_NAMESPACE_OPEN
namespace internal {
class AnyMetadata;
}  // namespace internal
PROTOBUF_NAMESPACE_CLOSE

// Internal implementation detail -- do not use these members.
struct TableStruct_rpc_2fqaul_5frpc_2eproto {
  static const uint32_t offsets[];
};
extern const ::PROTOBUF_NAMESPACE_ID::internal::DescriptorTable descriptor_table_rpc_2fqaul_5frpc_2eproto;
namespace qaul {
namespace rpc {
class QaulRpc;
struct QaulRpcDefaultTypeInternal;
extern QaulRpcDefaultTypeInternal _QaulRpc_default_instance_;
}  // namespace rpc
}  // namespace qaul
PROTOBUF_NAMESPACE_OPEN
template<> ::qaul::rpc::QaulRpc* Arena::CreateMaybeMessage<::qaul::rpc::QaulRpc>(Arena*);
PROTOBUF_NAMESPACE_CLOSE
namespace qaul {
namespace rpc {

enum Modules : int {
  NONE = 0,
  RPC = 1,
  NODE = 2,
  USERACCOUNTS = 3,
  USERS = 4,
  ROUTER = 5,
  FEED = 6,
  CONNECTIONS = 7,
  DEBUG = 8,
  GROUP = 9,
  CHAT = 10,
  CHATFILE = 11,
  BLE = 12,
  RTC = 13,
  DTN = 14,
  Modules_INT_MIN_SENTINEL_DO_NOT_USE_ = std::numeric_limits<int32_t>::min(),
  Modules_INT_MAX_SENTINEL_DO_NOT_USE_ = std::numeric_limits<int32_t>::max()
};
bool Modules_IsValid(int value);
constexpr Modules Modules_MIN = NONE;
constexpr Modules Modules_MAX = DTN;
constexpr int Modules_ARRAYSIZE = Modules_MAX + 1;

const ::PROTOBUF_NAMESPACE_ID::EnumDescriptor* Modules_descriptor();
template<typename T>
inline const std::string& Modules_Name(T enum_t_value) {
  static_assert(::std::is_same<T, Modules>::value ||
    ::std::is_integral<T>::value,
    "Incorrect type passed to function Modules_Name.");
  return ::PROTOBUF_NAMESPACE_ID::internal::NameOfEnum(
    Modules_descriptor(), enum_t_value);
}
inline bool Modules_Parse(
    ::PROTOBUF_NAMESPACE_ID::ConstStringParam name, Modules* value) {
  return ::PROTOBUF_NAMESPACE_ID::internal::ParseNamedEnum<Modules>(
    Modules_descriptor(), name, value);
}
// ===================================================================

class QaulRpc final :
    public ::PROTOBUF_NAMESPACE_ID::Message /* @@protoc_insertion_point(class_definition:qaul.rpc.QaulRpc) */ {
 public:
  inline QaulRpc() : QaulRpc(nullptr) {}
  ~QaulRpc() override;
  explicit PROTOBUF_CONSTEXPR QaulRpc(::PROTOBUF_NAMESPACE_ID::internal::ConstantInitialized);

  QaulRpc(const QaulRpc& from);
  QaulRpc(QaulRpc&& from) noexcept
    : QaulRpc() {
    *this = ::std::move(from);
  }

  inline QaulRpc& operator=(const QaulRpc& from) {
    CopyFrom(from);
    return *this;
  }
  inline QaulRpc& operator=(QaulRpc&& from) noexcept {
    if (this == &from) return *this;
    if (GetOwningArena() == from.GetOwningArena()
  #ifdef PROTOBUF_FORCE_COPY_IN_MOVE
        && GetOwningArena() != nullptr
  #endif  // !PROTOBUF_FORCE_COPY_IN_MOVE
    ) {
      InternalSwap(&from);
    } else {
      CopyFrom(from);
    }
    return *this;
  }

  static const ::PROTOBUF_NAMESPACE_ID::Descriptor* descriptor() {
    return GetDescriptor();
  }
  static const ::PROTOBUF_NAMESPACE_ID::Descriptor* GetDescriptor() {
    return default_instance().GetMetadata().descriptor;
  }
  static const ::PROTOBUF_NAMESPACE_ID::Reflection* GetReflection() {
    return default_instance().GetMetadata().reflection;
  }
  static const QaulRpc& default_instance() {
    return *internal_default_instance();
  }
  static inline const QaulRpc* internal_default_instance() {
    return reinterpret_cast<const QaulRpc*>(
               &_QaulRpc_default_instance_);
  }
  static constexpr int kIndexInFileMessages =
    0;

  friend void swap(QaulRpc& a, QaulRpc& b) {
    a.Swap(&b);
  }
  inline void Swap(QaulRpc* other) {
    if (other == this) return;
  #ifdef PROTOBUF_FORCE_COPY_IN_SWAP
    if (GetOwningArena() != nullptr &&
        GetOwningArena() == other->GetOwningArena()) {
   #else  // PROTOBUF_FORCE_COPY_IN_SWAP
    if (GetOwningArena() == other->GetOwningArena()) {
  #endif  // !PROTOBUF_FORCE_COPY_IN_SWAP
      InternalSwap(other);
    } else {
      ::PROTOBUF_NAMESPACE_ID::internal::GenericSwap(this, other);
    }
  }
  void UnsafeArenaSwap(QaulRpc* other) {
    if (other == this) return;
    GOOGLE_DCHECK(GetOwningArena() == other->GetOwningArena());
    InternalSwap(other);
  }

  // implements Message ----------------------------------------------

  QaulRpc* New(::PROTOBUF_NAMESPACE_ID::Arena* arena = nullptr) const final {
    return CreateMaybeMessage<QaulRpc>(arena);
  }
  using ::PROTOBUF_NAMESPACE_ID::Message::CopyFrom;
  void CopyFrom(const QaulRpc& from);
  using ::PROTOBUF_NAMESPACE_ID::Message::MergeFrom;
  void MergeFrom( const QaulRpc& from) {
    QaulRpc::MergeImpl(*this, from);
  }
  private:
  static void MergeImpl(::PROTOBUF_NAMESPACE_ID::Message& to_msg, const ::PROTOBUF_NAMESPACE_ID::Message& from_msg);
  public:
  PROTOBUF_ATTRIBUTE_REINITIALIZES void Clear() final;
  bool IsInitialized() const final;

  size_t ByteSizeLong() const final;
  const char* _InternalParse(const char* ptr, ::PROTOBUF_NAMESPACE_ID::internal::ParseContext* ctx) final;
  uint8_t* _InternalSerialize(
      uint8_t* target, ::PROTOBUF_NAMESPACE_ID::io::EpsCopyOutputStream* stream) const final;
  int GetCachedSize() const final { return _impl_._cached_size_.Get(); }

  private:
  void SharedCtor(::PROTOBUF_NAMESPACE_ID::Arena* arena, bool is_message_owned);
  void SharedDtor();
  void SetCachedSize(int size) const final;
  void InternalSwap(QaulRpc* other);

  private:
  friend class ::PROTOBUF_NAMESPACE_ID::internal::AnyMetadata;
  static ::PROTOBUF_NAMESPACE_ID::StringPiece FullMessageName() {
    return "qaul.rpc.QaulRpc";
  }
  protected:
  explicit QaulRpc(::PROTOBUF_NAMESPACE_ID::Arena* arena,
                       bool is_message_owned = false);
  public:

  static const ClassData _class_data_;
  const ::PROTOBUF_NAMESPACE_ID::Message::ClassData*GetClassData() const final;

  ::PROTOBUF_NAMESPACE_ID::Metadata GetMetadata() const final;

  // nested types ----------------------------------------------------

  // accessors -------------------------------------------------------

  enum : int {
    kRequestIdFieldNumber = 2,
    kUserIdFieldNumber = 3,
    kDataFieldNumber = 4,
    kModuleFieldNumber = 1,
  };
  // string request_id = 2;
  void clear_request_id();
  const std::string& request_id() const;
  template <typename ArgT0 = const std::string&, typename... ArgT>
  void set_request_id(ArgT0&& arg0, ArgT... args);
  std::string* mutable_request_id();
  PROTOBUF_NODISCARD std::string* release_request_id();
  void set_allocated_request_id(std::string* request_id);
  private:
  const std::string& _internal_request_id() const;
  inline PROTOBUF_ALWAYS_INLINE void _internal_set_request_id(const std::string& value);
  std::string* _internal_mutable_request_id();
  public:

  // bytes user_id = 3;
  void clear_user_id();
  const std::string& user_id() const;
  template <typename ArgT0 = const std::string&, typename... ArgT>
  void set_user_id(ArgT0&& arg0, ArgT... args);
  std::string* mutable_user_id();
  PROTOBUF_NODISCARD std::string* release_user_id();
  void set_allocated_user_id(std::string* user_id);
  private:
  const std::string& _internal_user_id() const;
  inline PROTOBUF_ALWAYS_INLINE void _internal_set_user_id(const std::string& value);
  std::string* _internal_mutable_user_id();
  public:

  // bytes data = 4;
  void clear_data();
  const std::string& data() const;
  template <typename ArgT0 = const std::string&, typename... ArgT>
  void set_data(ArgT0&& arg0, ArgT... args);
  std::string* mutable_data();
  PROTOBUF_NODISCARD std::string* release_data();
  void set_allocated_data(std::string* data);
  private:
  const std::string& _internal_data() const;
  inline PROTOBUF_ALWAYS_INLINE void _internal_set_data(const std::string& value);
  std::string* _internal_mutable_data();
  public:

  // .qaul.rpc.Modules module = 1;
  void clear_module();
  ::qaul::rpc::Modules module() const;
  void set_module(::qaul::rpc::Modules value);
  private:
  ::qaul::rpc::Modules _internal_module() const;
  void _internal_set_module(::qaul::rpc::Modules value);
  public:

  // @@protoc_insertion_point(class_scope:qaul.rpc.QaulRpc)
 private:
  class _Internal;

  template <typename T> friend class ::PROTOBUF_NAMESPACE_ID::Arena::InternalHelper;
  typedef void InternalArenaConstructable_;
  typedef void DestructorSkippable_;
  struct Impl_ {
    ::PROTOBUF_NAMESPACE_ID::internal::ArenaStringPtr request_id_;
    ::PROTOBUF_NAMESPACE_ID::internal::ArenaStringPtr user_id_;
    ::PROTOBUF_NAMESPACE_ID::internal::ArenaStringPtr data_;
    int module_;
    mutable ::PROTOBUF_NAMESPACE_ID::internal::CachedSize _cached_size_;
  };
  union { Impl_ _impl_; };
  friend struct ::TableStruct_rpc_2fqaul_5frpc_2eproto;
};
// ===================================================================


// ===================================================================

#ifdef __GNUC__
  #pragma GCC diagnostic push
  #pragma GCC diagnostic ignored "-Wstrict-aliasing"
#endif  // __GNUC__
// QaulRpc

// .qaul.rpc.Modules module = 1;
inline void QaulRpc::clear_module() {
  _impl_.module_ = 0;
}
inline ::qaul::rpc::Modules QaulRpc::_internal_module() const {
  return static_cast< ::qaul::rpc::Modules >(_impl_.module_);
}
inline ::qaul::rpc::Modules QaulRpc::module() const {
  // @@protoc_insertion_point(field_get:qaul.rpc.QaulRpc.module)
  return _internal_module();
}
inline void QaulRpc::_internal_set_module(::qaul::rpc::Modules value) {
  
  _impl_.module_ = value;
}
inline void QaulRpc::set_module(::qaul::rpc::Modules value) {
  _internal_set_module(value);
  // @@protoc_insertion_point(field_set:qaul.rpc.QaulRpc.module)
}

// string request_id = 2;
inline void QaulRpc::clear_request_id() {
  _impl_.request_id_.ClearToEmpty();
}
inline const std::string& QaulRpc::request_id() const {
  // @@protoc_insertion_point(field_get:qaul.rpc.QaulRpc.request_id)
  return _internal_request_id();
}
template <typename ArgT0, typename... ArgT>
inline PROTOBUF_ALWAYS_INLINE
void QaulRpc::set_request_id(ArgT0&& arg0, ArgT... args) {
 
 _impl_.request_id_.Set(static_cast<ArgT0 &&>(arg0), args..., GetArenaForAllocation());
  // @@protoc_insertion_point(field_set:qaul.rpc.QaulRpc.request_id)
}
inline std::string* QaulRpc::mutable_request_id() {
  std::string* _s = _internal_mutable_request_id();
  // @@protoc_insertion_point(field_mutable:qaul.rpc.QaulRpc.request_id)
  return _s;
}
inline const std::string& QaulRpc::_internal_request_id() const {
  return _impl_.request_id_.Get();
}
inline void QaulRpc::_internal_set_request_id(const std::string& value) {
  
  _impl_.request_id_.Set(value, GetArenaForAllocation());
}
inline std::string* QaulRpc::_internal_mutable_request_id() {
  
  return _impl_.request_id_.Mutable(GetArenaForAllocation());
}
inline std::string* QaulRpc::release_request_id() {
  // @@protoc_insertion_point(field_release:qaul.rpc.QaulRpc.request_id)
  return _impl_.request_id_.Release();
}
inline void QaulRpc::set_allocated_request_id(std::string* request_id) {
  if (request_id != nullptr) {
    
  } else {
    
  }
  _impl_.request_id_.SetAllocated(request_id, GetArenaForAllocation());
#ifdef PROTOBUF_FORCE_COPY_DEFAULT_STRING
  if (_impl_.request_id_.IsDefault()) {
    _impl_.request_id_.Set("", GetArenaForAllocation());
  }
#endif // PROTOBUF_FORCE_COPY_DEFAULT_STRING
  // @@protoc_insertion_point(field_set_allocated:qaul.rpc.QaulRpc.request_id)
}

// bytes user_id = 3;
inline void QaulRpc::clear_user_id() {
  _impl_.user_id_.ClearToEmpty();
}
inline const std::string& QaulRpc::user_id() const {
  // @@protoc_insertion_point(field_get:qaul.rpc.QaulRpc.user_id)
  return _internal_user_id();
}
template <typename ArgT0, typename... ArgT>
inline PROTOBUF_ALWAYS_INLINE
void QaulRpc::set_user_id(ArgT0&& arg0, ArgT... args) {
 
 _impl_.user_id_.SetBytes(static_cast<ArgT0 &&>(arg0), args..., GetArenaForAllocation());
  // @@protoc_insertion_point(field_set:qaul.rpc.QaulRpc.user_id)
}
inline std::string* QaulRpc::mutable_user_id() {
  std::string* _s = _internal_mutable_user_id();
  // @@protoc_insertion_point(field_mutable:qaul.rpc.QaulRpc.user_id)
  return _s;
}
inline const std::string& QaulRpc::_internal_user_id() const {
  return _impl_.user_id_.Get();
}
inline void QaulRpc::_internal_set_user_id(const std::string& value) {
  
  _impl_.user_id_.Set(value, GetArenaForAllocation());
}
inline std::string* QaulRpc::_internal_mutable_user_id() {
  
  return _impl_.user_id_.Mutable(GetArenaForAllocation());
}
inline std::string* QaulRpc::release_user_id() {
  // @@protoc_insertion_point(field_release:qaul.rpc.QaulRpc.user_id)
  return _impl_.user_id_.Release();
}
inline void QaulRpc::set_allocated_user_id(std::string* user_id) {
  if (user_id != nullptr) {
    
  } else {
    
  }
  _impl_.user_id_.SetAllocated(user_id, GetArenaForAllocation());
#ifdef PROTOBUF_FORCE_COPY_DEFAULT_STRING
  if (_impl_.user_id_.IsDefault()) {
    _impl_.user_id_.Set("", GetArenaForAllocation());
  }
#endif // PROTOBUF_FORCE_COPY_DEFAULT_STRING
  // @@protoc_insertion_point(field_set_allocated:qaul.rpc.QaulRpc.user_id)
}

// bytes data = 4;
inline void QaulRpc::clear_data() {
  _impl_.data_.ClearToEmpty();
}
inline const std::string& QaulRpc::data() const {
  // @@protoc_insertion_point(field_get:qaul.rpc.QaulRpc.data)
  return _internal_data();
}
template <typename ArgT0, typename... ArgT>
inline PROTOBUF_ALWAYS_INLINE
void QaulRpc::set_data(ArgT0&& arg0, ArgT... args) {
 
 _impl_.data_.SetBytes(static_cast<ArgT0 &&>(arg0), args..., GetArenaForAllocation());
  // @@protoc_insertion_point(field_set:qaul.rpc.QaulRpc.data)
}
inline std::string* QaulRpc::mutable_data() {
  std::string* _s = _internal_mutable_data();
  // @@protoc_insertion_point(field_mutable:qaul.rpc.QaulRpc.data)
  return _s;
}
inline const std::string& QaulRpc::_internal_data() const {
  return _impl_.data_.Get();
}
inline void QaulRpc::_internal_set_data(const std::string& value) {
  
  _impl_.data_.Set(value, GetArenaForAllocation());
}
inline std::string* QaulRpc::_internal_mutable_data() {
  
  return _impl_.data_.Mutable(GetArenaForAllocation());
}
inline std::string* QaulRpc::release_data() {
  // @@protoc_insertion_point(field_release:qaul.rpc.QaulRpc.data)
  return _impl_.data_.Release();
}
inline void QaulRpc::set_allocated_data(std::string* data) {
  if (data != nullptr) {
    
  } else {
    
  }
  _impl_.data_.SetAllocated(data, GetArenaForAllocation());
#ifdef PROTOBUF_FORCE_COPY_DEFAULT_STRING
  if (_impl_.data_.IsDefault()) {
    _impl_.data_.Set("", GetArenaForAllocation());
  }
#endif // PROTOBUF_FORCE_COPY_DEFAULT_STRING
  // @@protoc_insertion_point(field_set_allocated:qaul.rpc.QaulRpc.data)
}

#ifdef __GNUC__
  #pragma GCC diagnostic pop
#endif  // __GNUC__

// @@protoc_insertion_point(namespace_scope)

}  // namespace rpc
}  // namespace qaul

PROTOBUF_NAMESPACE_OPEN

template <> struct is_proto_enum< ::qaul::rpc::Modules> : ::std::true_type {};
template <>
inline const EnumDescriptor* GetEnumDescriptor< ::qaul::rpc::Modules>() {
  return ::qaul::rpc::Modules_descriptor();
}

PROTOBUF_NAMESPACE_CLOSE

// @@protoc_insertion_point(global_scope)

#include <google/protobuf/port_undef.inc>
#endif  // GOOGLE_PROTOBUF_INCLUDED_GOOGLE_PROTOBUF_INCLUDED_rpc_2fqaul_5frpc_2eproto
