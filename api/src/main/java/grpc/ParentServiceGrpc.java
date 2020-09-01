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
public final class ParentServiceGrpc {

  private ParentServiceGrpc() {}

  public static final String SERVICE_NAME = "ParentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Parent,
      grpc.ParentId> getSaveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "save",
      requestType = grpc.Parent.class,
      responseType = grpc.ParentId.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Parent,
      grpc.ParentId> getSaveMethod() {
    io.grpc.MethodDescriptor<grpc.Parent, grpc.ParentId> getSaveMethod;
    if ((getSaveMethod = ParentServiceGrpc.getSaveMethod) == null) {
      synchronized (ParentServiceGrpc.class) {
        if ((getSaveMethod = ParentServiceGrpc.getSaveMethod) == null) {
          ParentServiceGrpc.getSaveMethod = getSaveMethod =
              io.grpc.MethodDescriptor.<grpc.Parent, grpc.ParentId>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "save"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Parent.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ParentId.getDefaultInstance()))
              .setSchemaDescriptor(new ParentServiceMethodDescriptorSupplier("save"))
              .build();
        }
      }
    }
    return getSaveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Email,
      grpc.ParentResponse> getFindParentByEmailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findParentByEmail",
      requestType = grpc.Email.class,
      responseType = grpc.ParentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Email,
      grpc.ParentResponse> getFindParentByEmailMethod() {
    io.grpc.MethodDescriptor<grpc.Email, grpc.ParentResponse> getFindParentByEmailMethod;
    if ((getFindParentByEmailMethod = ParentServiceGrpc.getFindParentByEmailMethod) == null) {
      synchronized (ParentServiceGrpc.class) {
        if ((getFindParentByEmailMethod = ParentServiceGrpc.getFindParentByEmailMethod) == null) {
          ParentServiceGrpc.getFindParentByEmailMethod = getFindParentByEmailMethod =
              io.grpc.MethodDescriptor.<grpc.Email, grpc.ParentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "findParentByEmail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Email.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ParentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ParentServiceMethodDescriptorSupplier("findParentByEmail"))
              .build();
        }
      }
    }
    return getFindParentByEmailMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ParentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ParentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ParentServiceStub>() {
        @java.lang.Override
        public ParentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ParentServiceStub(channel, callOptions);
        }
      };
    return ParentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ParentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ParentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ParentServiceBlockingStub>() {
        @java.lang.Override
        public ParentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ParentServiceBlockingStub(channel, callOptions);
        }
      };
    return ParentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ParentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ParentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ParentServiceFutureStub>() {
        @java.lang.Override
        public ParentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ParentServiceFutureStub(channel, callOptions);
        }
      };
    return ParentServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ParentServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void save(grpc.Parent request,
        io.grpc.stub.StreamObserver<grpc.ParentId> responseObserver) {
      asyncUnimplementedUnaryCall(getSaveMethod(), responseObserver);
    }

    /**
     */
    public void findParentByEmail(grpc.Email request,
        io.grpc.stub.StreamObserver<grpc.ParentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFindParentByEmailMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSaveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Parent,
                grpc.ParentId>(
                  this, METHODID_SAVE)))
          .addMethod(
            getFindParentByEmailMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Email,
                grpc.ParentResponse>(
                  this, METHODID_FIND_PARENT_BY_EMAIL)))
          .build();
    }
  }

  /**
   */
  public static final class ParentServiceStub extends io.grpc.stub.AbstractAsyncStub<ParentServiceStub> {
    private ParentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ParentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ParentServiceStub(channel, callOptions);
    }

    /**
     */
    public void save(grpc.Parent request,
        io.grpc.stub.StreamObserver<grpc.ParentId> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSaveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findParentByEmail(grpc.Email request,
        io.grpc.stub.StreamObserver<grpc.ParentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindParentByEmailMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ParentServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ParentServiceBlockingStub> {
    private ParentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ParentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ParentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.ParentId save(grpc.Parent request) {
      return blockingUnaryCall(
          getChannel(), getSaveMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.ParentResponse findParentByEmail(grpc.Email request) {
      return blockingUnaryCall(
          getChannel(), getFindParentByEmailMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ParentServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ParentServiceFutureStub> {
    private ParentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ParentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ParentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.ParentId> save(
        grpc.Parent request) {
      return futureUnaryCall(
          getChannel().newCall(getSaveMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.ParentResponse> findParentByEmail(
        grpc.Email request) {
      return futureUnaryCall(
          getChannel().newCall(getFindParentByEmailMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAVE = 0;
  private static final int METHODID_FIND_PARENT_BY_EMAIL = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ParentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ParentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAVE:
          serviceImpl.save((grpc.Parent) request,
              (io.grpc.stub.StreamObserver<grpc.ParentId>) responseObserver);
          break;
        case METHODID_FIND_PARENT_BY_EMAIL:
          serviceImpl.findParentByEmail((grpc.Email) request,
              (io.grpc.stub.StreamObserver<grpc.ParentResponse>) responseObserver);
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

  private static abstract class ParentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ParentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Sandbox.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ParentService");
    }
  }

  private static final class ParentServiceFileDescriptorSupplier
      extends ParentServiceBaseDescriptorSupplier {
    ParentServiceFileDescriptorSupplier() {}
  }

  private static final class ParentServiceMethodDescriptorSupplier
      extends ParentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ParentServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ParentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ParentServiceFileDescriptorSupplier())
              .addMethod(getSaveMethod())
              .addMethod(getFindParentByEmailMethod())
              .build();
        }
      }
    }
    return result;
  }
}
