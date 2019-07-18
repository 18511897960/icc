// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Person.proto

package com.icc.web.netty.protobuf3;

/**
 * Protobuf type {@code com.icc.web.netty.protobuf3.RequestHeaderList}
 */
public  final class RequestHeaderList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.icc.web.netty.protobuf3.RequestHeaderList)
    RequestHeaderListOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RequestHeaderList.newBuilder() to construct.
  private RequestHeaderList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RequestHeaderList() {
    request_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RequestHeaderList(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              request_ = new java.util.ArrayList<com.icc.web.netty.protobuf3.RequestHeader>();
              mutable_bitField0_ |= 0x00000001;
            }
            request_.add(
                input.readMessage(com.icc.web.netty.protobuf3.RequestHeader.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        request_ = java.util.Collections.unmodifiableList(request_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.icc.web.netty.protobuf3.DataInfo.internal_static_com_icc_web_netty_protobuf3_RequestHeaderList_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.icc.web.netty.protobuf3.DataInfo.internal_static_com_icc_web_netty_protobuf3_RequestHeaderList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.icc.web.netty.protobuf3.RequestHeaderList.class, com.icc.web.netty.protobuf3.RequestHeaderList.Builder.class);
  }

  public static final int REQUEST_FIELD_NUMBER = 1;
  private java.util.List<com.icc.web.netty.protobuf3.RequestHeader> request_;
  /**
   * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
   */
  public java.util.List<com.icc.web.netty.protobuf3.RequestHeader> getRequestList() {
    return request_;
  }
  /**
   * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
   */
  public java.util.List<? extends com.icc.web.netty.protobuf3.RequestHeaderOrBuilder> 
      getRequestOrBuilderList() {
    return request_;
  }
  /**
   * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
   */
  public int getRequestCount() {
    return request_.size();
  }
  /**
   * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
   */
  public com.icc.web.netty.protobuf3.RequestHeader getRequest(int index) {
    return request_.get(index);
  }
  /**
   * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
   */
  public com.icc.web.netty.protobuf3.RequestHeaderOrBuilder getRequestOrBuilder(
      int index) {
    return request_.get(index);
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
    for (int i = 0; i < request_.size(); i++) {
      output.writeMessage(1, request_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < request_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, request_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.icc.web.netty.protobuf3.RequestHeaderList)) {
      return super.equals(obj);
    }
    com.icc.web.netty.protobuf3.RequestHeaderList other = (com.icc.web.netty.protobuf3.RequestHeaderList) obj;

    if (!getRequestList()
        .equals(other.getRequestList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getRequestCount() > 0) {
      hash = (37 * hash) + REQUEST_FIELD_NUMBER;
      hash = (53 * hash) + getRequestList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.icc.web.netty.protobuf3.RequestHeaderList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.icc.web.netty.protobuf3.RequestHeaderList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.icc.web.netty.protobuf3.RequestHeaderList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.icc.web.netty.protobuf3.RequestHeaderList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.icc.web.netty.protobuf3.RequestHeaderList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.icc.web.netty.protobuf3.RequestHeaderList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.icc.web.netty.protobuf3.RequestHeaderList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.icc.web.netty.protobuf3.RequestHeaderList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.icc.web.netty.protobuf3.RequestHeaderList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.icc.web.netty.protobuf3.RequestHeaderList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.icc.web.netty.protobuf3.RequestHeaderList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.icc.web.netty.protobuf3.RequestHeaderList parseFrom(
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
  public static Builder newBuilder(com.icc.web.netty.protobuf3.RequestHeaderList prototype) {
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
   * Protobuf type {@code com.icc.web.netty.protobuf3.RequestHeaderList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.icc.web.netty.protobuf3.RequestHeaderList)
      com.icc.web.netty.protobuf3.RequestHeaderListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.icc.web.netty.protobuf3.DataInfo.internal_static_com_icc_web_netty_protobuf3_RequestHeaderList_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.icc.web.netty.protobuf3.DataInfo.internal_static_com_icc_web_netty_protobuf3_RequestHeaderList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.icc.web.netty.protobuf3.RequestHeaderList.class, com.icc.web.netty.protobuf3.RequestHeaderList.Builder.class);
    }

    // Construct using com.icc.web.netty.protobuf3.RequestHeaderList.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getRequestFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (requestBuilder_ == null) {
        request_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        requestBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.icc.web.netty.protobuf3.DataInfo.internal_static_com_icc_web_netty_protobuf3_RequestHeaderList_descriptor;
    }

    @java.lang.Override
    public com.icc.web.netty.protobuf3.RequestHeaderList getDefaultInstanceForType() {
      return com.icc.web.netty.protobuf3.RequestHeaderList.getDefaultInstance();
    }

    @java.lang.Override
    public com.icc.web.netty.protobuf3.RequestHeaderList build() {
      com.icc.web.netty.protobuf3.RequestHeaderList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.icc.web.netty.protobuf3.RequestHeaderList buildPartial() {
      com.icc.web.netty.protobuf3.RequestHeaderList result = new com.icc.web.netty.protobuf3.RequestHeaderList(this);
      int from_bitField0_ = bitField0_;
      if (requestBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          request_ = java.util.Collections.unmodifiableList(request_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.request_ = request_;
      } else {
        result.request_ = requestBuilder_.build();
      }
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
      if (other instanceof com.icc.web.netty.protobuf3.RequestHeaderList) {
        return mergeFrom((com.icc.web.netty.protobuf3.RequestHeaderList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.icc.web.netty.protobuf3.RequestHeaderList other) {
      if (other == com.icc.web.netty.protobuf3.RequestHeaderList.getDefaultInstance()) return this;
      if (requestBuilder_ == null) {
        if (!other.request_.isEmpty()) {
          if (request_.isEmpty()) {
            request_ = other.request_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureRequestIsMutable();
            request_.addAll(other.request_);
          }
          onChanged();
        }
      } else {
        if (!other.request_.isEmpty()) {
          if (requestBuilder_.isEmpty()) {
            requestBuilder_.dispose();
            requestBuilder_ = null;
            request_ = other.request_;
            bitField0_ = (bitField0_ & ~0x00000001);
            requestBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getRequestFieldBuilder() : null;
          } else {
            requestBuilder_.addAllMessages(other.request_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
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
      com.icc.web.netty.protobuf3.RequestHeaderList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.icc.web.netty.protobuf3.RequestHeaderList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.icc.web.netty.protobuf3.RequestHeader> request_ =
      java.util.Collections.emptyList();
    private void ensureRequestIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        request_ = new java.util.ArrayList<com.icc.web.netty.protobuf3.RequestHeader>(request_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.icc.web.netty.protobuf3.RequestHeader, com.icc.web.netty.protobuf3.RequestHeader.Builder, com.icc.web.netty.protobuf3.RequestHeaderOrBuilder> requestBuilder_;

    /**
     * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
     */
    public java.util.List<com.icc.web.netty.protobuf3.RequestHeader> getRequestList() {
      if (requestBuilder_ == null) {
        return java.util.Collections.unmodifiableList(request_);
      } else {
        return requestBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
     */
    public int getRequestCount() {
      if (requestBuilder_ == null) {
        return request_.size();
      } else {
        return requestBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
     */
    public com.icc.web.netty.protobuf3.RequestHeader getRequest(int index) {
      if (requestBuilder_ == null) {
        return request_.get(index);
      } else {
        return requestBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
     */
    public Builder setRequest(
        int index, com.icc.web.netty.protobuf3.RequestHeader value) {
      if (requestBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRequestIsMutable();
        request_.set(index, value);
        onChanged();
      } else {
        requestBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
     */
    public Builder setRequest(
        int index, com.icc.web.netty.protobuf3.RequestHeader.Builder builderForValue) {
      if (requestBuilder_ == null) {
        ensureRequestIsMutable();
        request_.set(index, builderForValue.build());
        onChanged();
      } else {
        requestBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
     */
    public Builder addRequest(com.icc.web.netty.protobuf3.RequestHeader value) {
      if (requestBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRequestIsMutable();
        request_.add(value);
        onChanged();
      } else {
        requestBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
     */
    public Builder addRequest(
        int index, com.icc.web.netty.protobuf3.RequestHeader value) {
      if (requestBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRequestIsMutable();
        request_.add(index, value);
        onChanged();
      } else {
        requestBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
     */
    public Builder addRequest(
        com.icc.web.netty.protobuf3.RequestHeader.Builder builderForValue) {
      if (requestBuilder_ == null) {
        ensureRequestIsMutable();
        request_.add(builderForValue.build());
        onChanged();
      } else {
        requestBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
     */
    public Builder addRequest(
        int index, com.icc.web.netty.protobuf3.RequestHeader.Builder builderForValue) {
      if (requestBuilder_ == null) {
        ensureRequestIsMutable();
        request_.add(index, builderForValue.build());
        onChanged();
      } else {
        requestBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
     */
    public Builder addAllRequest(
        java.lang.Iterable<? extends com.icc.web.netty.protobuf3.RequestHeader> values) {
      if (requestBuilder_ == null) {
        ensureRequestIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, request_);
        onChanged();
      } else {
        requestBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
     */
    public Builder clearRequest() {
      if (requestBuilder_ == null) {
        request_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        requestBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
     */
    public Builder removeRequest(int index) {
      if (requestBuilder_ == null) {
        ensureRequestIsMutable();
        request_.remove(index);
        onChanged();
      } else {
        requestBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
     */
    public com.icc.web.netty.protobuf3.RequestHeader.Builder getRequestBuilder(
        int index) {
      return getRequestFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
     */
    public com.icc.web.netty.protobuf3.RequestHeaderOrBuilder getRequestOrBuilder(
        int index) {
      if (requestBuilder_ == null) {
        return request_.get(index);  } else {
        return requestBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
     */
    public java.util.List<? extends com.icc.web.netty.protobuf3.RequestHeaderOrBuilder> 
         getRequestOrBuilderList() {
      if (requestBuilder_ != null) {
        return requestBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(request_);
      }
    }
    /**
     * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
     */
    public com.icc.web.netty.protobuf3.RequestHeader.Builder addRequestBuilder() {
      return getRequestFieldBuilder().addBuilder(
          com.icc.web.netty.protobuf3.RequestHeader.getDefaultInstance());
    }
    /**
     * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
     */
    public com.icc.web.netty.protobuf3.RequestHeader.Builder addRequestBuilder(
        int index) {
      return getRequestFieldBuilder().addBuilder(
          index, com.icc.web.netty.protobuf3.RequestHeader.getDefaultInstance());
    }
    /**
     * <code>repeated .com.icc.web.netty.protobuf3.RequestHeader request = 1;</code>
     */
    public java.util.List<com.icc.web.netty.protobuf3.RequestHeader.Builder> 
         getRequestBuilderList() {
      return getRequestFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.icc.web.netty.protobuf3.RequestHeader, com.icc.web.netty.protobuf3.RequestHeader.Builder, com.icc.web.netty.protobuf3.RequestHeaderOrBuilder> 
        getRequestFieldBuilder() {
      if (requestBuilder_ == null) {
        requestBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.icc.web.netty.protobuf3.RequestHeader, com.icc.web.netty.protobuf3.RequestHeader.Builder, com.icc.web.netty.protobuf3.RequestHeaderOrBuilder>(
                request_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        request_ = null;
      }
      return requestBuilder_;
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


    // @@protoc_insertion_point(builder_scope:com.icc.web.netty.protobuf3.RequestHeaderList)
  }

  // @@protoc_insertion_point(class_scope:com.icc.web.netty.protobuf3.RequestHeaderList)
  private static final com.icc.web.netty.protobuf3.RequestHeaderList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.icc.web.netty.protobuf3.RequestHeaderList();
  }

  public static com.icc.web.netty.protobuf3.RequestHeaderList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RequestHeaderList>
      PARSER = new com.google.protobuf.AbstractParser<RequestHeaderList>() {
    @java.lang.Override
    public RequestHeaderList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RequestHeaderList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RequestHeaderList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RequestHeaderList> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.icc.web.netty.protobuf3.RequestHeaderList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

