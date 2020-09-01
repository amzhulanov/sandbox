package grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.31.1)",
    comments = "Source: sandbox.proto")
public final class ChildServiceGrpc {

  private ChildServiceGrpc() {}

  public static final String SERVICE_NAME = "ChildService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Child,
      grpc.Child> getSaveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "save",
      requestType = grpc.Child.class,
      responseType = grpc.Child.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Child,
      grpc.Child> getSaveMethod() {
    io.grpc.MethodDescriptor<grpc.Child, grpc.Child> getSaveMethod;
    if ((getSaveMethod = ChildServiceGrpc.getSaveMethod) == null) {
      synchronized (ChildServiceGrpc.class) {
        if ((getSaveMethod = ChildServiceGrpc.getSaveMethod) == null) {
          ChildServiceGrpc.getSaveMethod = getSaveMethod =
              io.grpc.MethodDescriptor.<grpc.Child, grpc.Child>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "save"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Child.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Child.getDefaultInstance()))
              .setSchemaDescriptor(new ChildServiceMethodDescriptorSupplier("save"))
              .build();
        }
      }
    }
    return getSaveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.ParentId,
      grpc.ListChild> getGetAllChildsByParentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllChildsByParent",
      requestType = grpc.ParentId.class,
      responseType = grpc.ListChild.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.ParentId,
      grpc.ListChild> getGetAllChildsByParentMethod() {
    io.grpc.MethodDescriptor<grpc.ParentId, grpc.ListChild> getGetAllChildsByParentMethod;
    if ((getGetAllChildsByParentMethod = ChildServiceGrpc.getGetAllChildsByParentMethod) == null) {
      synchronized (ChildServiceGrpc.class) {
        if ((getGetAllChildsByParentMethod = ChildServiceGrpc.getGetAllChildsByParentMethod) == null) {
          ChildServiceGrpc.getGetAllChildsByParentMethod = getGetAllChildsByParentMethod =
              io.grpc.MethodDescriptor.<grpc.ParentId, grpc.ListChild>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllChildsByParent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ParentId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ListChild.getDefaultInstance()))
              .setSchemaDescriptor(new ChildServiceMethodDescriptorSupplier("getAllChildsByParent"))
              .build();
        }
      }
    }
    return getGetAllChildsByParentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChildServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChildServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChildServiceStub>() {
        @java.lang.Override
        public ChildServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChildServiceStub(channel, callOptions);
        }
      };
    return ChildServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChildServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChildServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChildServiceBlockingStub>() {
        @java.lang.Override
        public ChildServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChildServiceBlockingStub(channel, callOptions);
        }
      };
    return ChildServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChildServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChildServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChildServiceFutureStub>() {
        @java.lang.Override
        public ChildServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChildServiceFutureStub(channel, callOptions);
        }
      };
    return ChildServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ChildServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void save(grpc.Child request,
        io.grpc.stub.StreamObserver<grpc.Child> responseObserver) {
      asyncUnimplementedUnaryCall(getSaveMethod(), responseObserver);
    }

    /**
     */
    public void getAllChildsByParent(grpc.ParentId request,
        io.grpc.stub.StreamObserver<grpc.ListChild> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllChildsByParentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSaveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Child,
                grpc.Child>(
                  this, METHODID_SAVE)))
          .addMethod(
            getGetAllChildsByParentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.ParentId,
                grpc.ListChild>(
                  this, METHODID_GET_ALL_CHILDS_BY_PARENT)))
          .build();
    }
  }

  /**
   */
  public static final class ChildServiceStub extends io.grpc.stub.AbstractAsyncStub<ChildServiceStub> {
    private ChildServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChildServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChildServiceStub(channel, callOptions);
    }

    /**
     */
    public void save(grpc.Child request,
        io.grpc.stub.StreamObserver<grpc.Child> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSaveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllChildsByParent(grpc.ParentId request,
        io.grpc.stub.StreamObserver<grpc.ListChild> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllChildsByParentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ChildServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ChildServiceBlockingStub> {
    private ChildServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChildServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChildServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.Child save(grpc.Child request) {
      return blockingUnaryCall(
          getChannel(), getSaveMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.ListChild getAllChildsByParent(grpc.ParentId request) {
      return blockingUnaryCall(
          getChannel(), getGetAllChildsByParentMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChildServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ChildServiceFutureStub> {
    private ChildServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChildServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChildServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Child> save(
        grpc.Child request) {
      return futureUnaryCall(
          getChannel().newCall(getSaveMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.ListChild> getAllChildsByParent(
        grpc.ParentId request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllChildsByParentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAVE = 0;
  private static final int METHODID_GET_ALL_CHILDS_BY_PARENT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChildServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChildServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAVE:
          serviceImpl.save((grpc.Child) request,
              (io.grpc.stub.StreamObserver<grpc.Child>) responseObserver);
          break;
        case METHODID_GET_ALL_CHILDS_BY_PARENT:
          serviceImpl.getAllChildsByParent((grpc.ParentId) request,
              (io.grpc.stub.StreamObserver<grpc.ListChild>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChildServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChildServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Sandbox.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChildService");
    }
  }

  private static final class ChildServiceFileDescriptorSupplier
      extends ChildServiceBaseDescriptorSupplier {
    ChildServiceFileDescriptorSupplier() {}
  }

  private static final class ChildServiceMethodDescriptorSupplier
      extends ChildServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChildServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChildServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChildServiceFileDescriptorSupplier())
              .addMethod(getSaveMethod())
              .addMethod(getGetAllChildsByParentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
