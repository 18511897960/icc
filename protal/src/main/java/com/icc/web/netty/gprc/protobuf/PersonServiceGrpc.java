package com.icc.web.netty.gprc.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.*;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.*;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.22.1)",
    comments = "Source: Person.proto")
public final class PersonServiceGrpc {

  private PersonServiceGrpc() {}

  public static final String SERVICE_NAME = "com.icc.web.netty.protobuf3.PersonService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<RequestHeader,
          ResponseHeader> getFindMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "find",
      requestType = RequestHeader.class,
      responseType = ResponseHeader.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RequestHeader,
          ResponseHeader> getFindMethod() {
    io.grpc.MethodDescriptor<RequestHeader, ResponseHeader> getFindMethod;
    if ((getFindMethod = PersonServiceGrpc.getFindMethod) == null) {
      synchronized (PersonServiceGrpc.class) {
        if ((getFindMethod = PersonServiceGrpc.getFindMethod) == null) {
          PersonServiceGrpc.getFindMethod = getFindMethod =
              io.grpc.MethodDescriptor.<RequestHeader, ResponseHeader>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.icc.web.netty.protobuf3.PersonService", "find"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RequestHeader.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ResponseHeader.getDefaultInstance()))
                  .setSchemaDescriptor(new PersonServiceMethodDescriptorSupplier("find"))
                  .build();
          }
        }
     }
     return getFindMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RequestHeader,
          ResponseHeaderList> getFindRequestStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findRequestStream",
      requestType = RequestHeader.class,
      responseType = ResponseHeaderList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<RequestHeader,
          ResponseHeaderList> getFindRequestStreamMethod() {
    io.grpc.MethodDescriptor<RequestHeader, ResponseHeaderList> getFindRequestStreamMethod;
    if ((getFindRequestStreamMethod = PersonServiceGrpc.getFindRequestStreamMethod) == null) {
      synchronized (PersonServiceGrpc.class) {
        if ((getFindRequestStreamMethod = PersonServiceGrpc.getFindRequestStreamMethod) == null) {
          PersonServiceGrpc.getFindRequestStreamMethod = getFindRequestStreamMethod =
              io.grpc.MethodDescriptor.<RequestHeader, ResponseHeaderList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.icc.web.netty.protobuf3.PersonService", "findRequestStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RequestHeader.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ResponseHeaderList.getDefaultInstance()))
                  .setSchemaDescriptor(new PersonServiceMethodDescriptorSupplier("findRequestStream"))
                  .build();
          }
        }
     }
     return getFindRequestStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RequestHeader,
          ResponseHeader> getFindResponseStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findResponseStream",
      requestType = RequestHeader.class,
      responseType = ResponseHeader.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<RequestHeader,
          ResponseHeader> getFindResponseStreamMethod() {
    io.grpc.MethodDescriptor<RequestHeader, ResponseHeader> getFindResponseStreamMethod;
    if ((getFindResponseStreamMethod = PersonServiceGrpc.getFindResponseStreamMethod) == null) {
      synchronized (PersonServiceGrpc.class) {
        if ((getFindResponseStreamMethod = PersonServiceGrpc.getFindResponseStreamMethod) == null) {
          PersonServiceGrpc.getFindResponseStreamMethod = getFindResponseStreamMethod =
              io.grpc.MethodDescriptor.<RequestHeader, ResponseHeader>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.icc.web.netty.protobuf3.PersonService", "findResponseStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RequestHeader.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ResponseHeader.getDefaultInstance()))
                  .setSchemaDescriptor(new PersonServiceMethodDescriptorSupplier("findResponseStream"))
                  .build();
          }
        }
     }
     return getFindResponseStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RequestHeader,
          ResponseHeader> getFindReqResStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findReqResStream",
      requestType = RequestHeader.class,
      responseType = ResponseHeader.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<RequestHeader,
          ResponseHeader> getFindReqResStreamMethod() {
    io.grpc.MethodDescriptor<RequestHeader, ResponseHeader> getFindReqResStreamMethod;
    if ((getFindReqResStreamMethod = PersonServiceGrpc.getFindReqResStreamMethod) == null) {
      synchronized (PersonServiceGrpc.class) {
        if ((getFindReqResStreamMethod = PersonServiceGrpc.getFindReqResStreamMethod) == null) {
          PersonServiceGrpc.getFindReqResStreamMethod = getFindReqResStreamMethod =
              io.grpc.MethodDescriptor.<RequestHeader, ResponseHeader>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.icc.web.netty.protobuf3.PersonService", "findReqResStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RequestHeader.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ResponseHeader.getDefaultInstance()))
                  .setSchemaDescriptor(new PersonServiceMethodDescriptorSupplier("findReqResStream"))
                  .build();
          }
        }
     }
     return getFindReqResStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PersonServiceStub newStub(io.grpc.Channel channel) {
    return new PersonServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PersonServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PersonServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PersonServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PersonServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PersonServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void find(RequestHeader request,
                     io.grpc.stub.StreamObserver<ResponseHeader> responseObserver) {
      asyncUnimplementedUnaryCall(getFindMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<RequestHeader> findRequestStream(
        io.grpc.stub.StreamObserver<ResponseHeaderList> responseObserver) {
      return asyncUnimplementedStreamingCall(getFindRequestStreamMethod(), responseObserver);
    }

    /**
     */
    public void findResponseStream(RequestHeader request,
                                   io.grpc.stub.StreamObserver<ResponseHeader> responseObserver) {
      asyncUnimplementedUnaryCall(getFindResponseStreamMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<RequestHeader> findReqResStream(
        io.grpc.stub.StreamObserver<ResponseHeader> responseObserver) {
      return asyncUnimplementedStreamingCall(getFindReqResStreamMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFindMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                      RequestHeader,
                      ResponseHeader>(
                  this, METHODID_FIND)))
          .addMethod(
            getFindRequestStreamMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                      RequestHeader,
                      ResponseHeaderList>(
                  this, METHODID_FIND_REQUEST_STREAM)))
          .addMethod(
            getFindResponseStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                      RequestHeader,
                      ResponseHeader>(
                  this, METHODID_FIND_RESPONSE_STREAM)))
          .addMethod(
            getFindReqResStreamMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                      RequestHeader,
                      ResponseHeader>(
                  this, METHODID_FIND_REQ_RES_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class PersonServiceStub extends io.grpc.stub.AbstractStub<PersonServiceStub> {
    private PersonServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected PersonServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonServiceStub(channel, callOptions);
    }

    /**
     */
    public void find(RequestHeader request,
                     io.grpc.stub.StreamObserver<ResponseHeader> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<RequestHeader> findRequestStream(
        io.grpc.stub.StreamObserver<ResponseHeaderList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getFindRequestStreamMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void findResponseStream(RequestHeader request,
                                   io.grpc.stub.StreamObserver<ResponseHeader> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getFindResponseStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<RequestHeader> findReqResStream(
        io.grpc.stub.StreamObserver<ResponseHeader> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getFindReqResStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class PersonServiceBlockingStub extends io.grpc.stub.AbstractStub<PersonServiceBlockingStub> {
    private PersonServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected PersonServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ResponseHeader find(RequestHeader request) {
      return blockingUnaryCall(
          getChannel(), getFindMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ResponseHeader> findResponseStream(
        RequestHeader request) {
      return blockingServerStreamingCall(
          getChannel(), getFindResponseStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PersonServiceFutureStub extends io.grpc.stub.AbstractStub<PersonServiceFutureStub> {
    private PersonServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PersonServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected PersonServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PersonServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ResponseHeader> find(
        RequestHeader request) {
      return futureUnaryCall(
          getChannel().newCall(getFindMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND = 0;
  private static final int METHODID_FIND_RESPONSE_STREAM = 1;
  private static final int METHODID_FIND_REQUEST_STREAM = 2;
  private static final int METHODID_FIND_REQ_RES_STREAM = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PersonServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PersonServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND:
          serviceImpl.find((RequestHeader) request,
              (io.grpc.stub.StreamObserver<ResponseHeader>) responseObserver);
          break;
        case METHODID_FIND_RESPONSE_STREAM:
          serviceImpl.findResponseStream((RequestHeader) request,
              (io.grpc.stub.StreamObserver<ResponseHeader>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_REQUEST_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.findRequestStream(
              (io.grpc.stub.StreamObserver<ResponseHeaderList>) responseObserver);
        case METHODID_FIND_REQ_RES_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.findReqResStream(
              (io.grpc.stub.StreamObserver<ResponseHeader>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PersonServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PersonServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return DataInfo.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PersonService");
    }
  }

  private static final class PersonServiceFileDescriptorSupplier
      extends PersonServiceBaseDescriptorSupplier {
    PersonServiceFileDescriptorSupplier() {}
  }

  private static final class PersonServiceMethodDescriptorSupplier
      extends PersonServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PersonServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PersonServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PersonServiceFileDescriptorSupplier())
              .addMethod(getFindMethod())
              .addMethod(getFindRequestStreamMethod())
              .addMethod(getFindResponseStreamMethod())
              .addMethod(getFindReqResStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
