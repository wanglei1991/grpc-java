package com.my.grpc.service;

import com.my.grpc.protobuf.Data;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.9.1)",
    comments = "Source: data.proto")
public final class BaseServiceGrpc {

  private BaseServiceGrpc() {}

  public static final String SERVICE_NAME = "BaseService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @Deprecated // Use {@link #getMethodMethod()} instead.
  public static final io.grpc.MethodDescriptor<Data.Request,
      Data.Response> METHOD_METHOD = getMethodMethod();

  private static volatile io.grpc.MethodDescriptor<Data.Request,
      Data.Response> getMethodMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<Data.Request,
      Data.Response> getMethodMethod() {
    io.grpc.MethodDescriptor<Data.Request, Data.Response> getMethodMethod;
    if ((getMethodMethod = BaseServiceGrpc.getMethodMethod) == null) {
      synchronized (BaseServiceGrpc.class) {
        if ((getMethodMethod = BaseServiceGrpc.getMethodMethod) == null) {
          BaseServiceGrpc.getMethodMethod = getMethodMethod = 
              io.grpc.MethodDescriptor.<Data.Request, Data.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "BaseService", "method"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Data.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Data.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new BaseServiceMethodDescriptorSupplier("method"))
                  .build();
          }
        }
     }
     return getMethodMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @Deprecated // Use {@link #getListMethodMethod()} instead.
  public static final io.grpc.MethodDescriptor<Data.Request,
      Data.ListResponse> METHOD_LIST_METHOD = getListMethodMethod();

  private static volatile io.grpc.MethodDescriptor<Data.Request,
      Data.ListResponse> getListMethodMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<Data.Request,
      Data.ListResponse> getListMethodMethod() {
    io.grpc.MethodDescriptor<Data.Request, Data.ListResponse> getListMethodMethod;
    if ((getListMethodMethod = BaseServiceGrpc.getListMethodMethod) == null) {
      synchronized (BaseServiceGrpc.class) {
        if ((getListMethodMethod = BaseServiceGrpc.getListMethodMethod) == null) {
          BaseServiceGrpc.getListMethodMethod = getListMethodMethod = 
              io.grpc.MethodDescriptor.<Data.Request, Data.ListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "BaseService", "listMethod"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Data.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Data.ListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BaseServiceMethodDescriptorSupplier("listMethod"))
                  .build();
          }
        }
     }
     return getListMethodMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BaseServiceStub newStub(io.grpc.Channel channel) {
    return new BaseServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BaseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BaseServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BaseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BaseServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BaseServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void method(Data.Request request,
                       io.grpc.stub.StreamObserver<Data.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getMethodMethod(), responseObserver);
    }

    /**
     */
    public void listMethod(Data.Request request,
                           io.grpc.stub.StreamObserver<Data.ListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListMethodMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMethodMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Data.Request,
                Data.Response>(
                  this, METHODID_METHOD)))
          .addMethod(
            getListMethodMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Data.Request,
                Data.ListResponse>(
                  this, METHODID_LIST_METHOD)))
          .build();
    }
  }

  /**
   */
  public static final class BaseServiceStub extends io.grpc.stub.AbstractStub<BaseServiceStub> {
    private BaseServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BaseServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected BaseServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BaseServiceStub(channel, callOptions);
    }

    /**
     */
    public void method(Data.Request request,
                       io.grpc.stub.StreamObserver<Data.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMethodMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listMethod(Data.Request request,
                           io.grpc.stub.StreamObserver<Data.ListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListMethodMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BaseServiceBlockingStub extends io.grpc.stub.AbstractStub<BaseServiceBlockingStub> {
    private BaseServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BaseServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected BaseServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BaseServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Data.Response method(Data.Request request) {
      return blockingUnaryCall(
          getChannel(), getMethodMethod(), getCallOptions(), request);
    }

    /**
     */
    public Data.ListResponse listMethod(Data.Request request) {
      return blockingUnaryCall(
          getChannel(), getListMethodMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BaseServiceFutureStub extends io.grpc.stub.AbstractStub<BaseServiceFutureStub> {
    private BaseServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BaseServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected BaseServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BaseServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Data.Response> method(
        Data.Request request) {
      return futureUnaryCall(
          getChannel().newCall(getMethodMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Data.ListResponse> listMethod(
        Data.Request request) {
      return futureUnaryCall(
          getChannel().newCall(getListMethodMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_METHOD = 0;
  private static final int METHODID_LIST_METHOD = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BaseServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BaseServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_METHOD:
          serviceImpl.method((Data.Request) request,
              (io.grpc.stub.StreamObserver<Data.Response>) responseObserver);
          break;
        case METHODID_LIST_METHOD:
          serviceImpl.listMethod((Data.Request) request,
              (io.grpc.stub.StreamObserver<Data.ListResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BaseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BaseServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Data.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BaseService");
    }
  }

  private static final class BaseServiceFileDescriptorSupplier
      extends BaseServiceBaseDescriptorSupplier {
    BaseServiceFileDescriptorSupplier() {}
  }

  private static final class BaseServiceMethodDescriptorSupplier
      extends BaseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BaseServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BaseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BaseServiceFileDescriptorSupplier())
              .addMethod(getMethodMethod())
              .addMethod(getListMethodMethod())
              .build();
        }
      }
    }
    return result;
  }
}
