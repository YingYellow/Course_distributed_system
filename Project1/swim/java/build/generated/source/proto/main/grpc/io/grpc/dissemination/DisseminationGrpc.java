package io.grpc.dissemination;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.71.0)",
    comments = "Source: dissemination.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DisseminationGrpc {

  private DisseminationGrpc() {}

  public static final java.lang.String SERVICE_NAME = "dissemination.Dissemination";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.dissemination.FailureReport,
      io.grpc.dissemination.AckResponse> getReportFailureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReportFailure",
      requestType = io.grpc.dissemination.FailureReport.class,
      responseType = io.grpc.dissemination.AckResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.dissemination.FailureReport,
      io.grpc.dissemination.AckResponse> getReportFailureMethod() {
    io.grpc.MethodDescriptor<io.grpc.dissemination.FailureReport, io.grpc.dissemination.AckResponse> getReportFailureMethod;
    if ((getReportFailureMethod = DisseminationGrpc.getReportFailureMethod) == null) {
      synchronized (DisseminationGrpc.class) {
        if ((getReportFailureMethod = DisseminationGrpc.getReportFailureMethod) == null) {
          DisseminationGrpc.getReportFailureMethod = getReportFailureMethod =
              io.grpc.MethodDescriptor.<io.grpc.dissemination.FailureReport, io.grpc.dissemination.AckResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReportFailure"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.dissemination.FailureReport.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.dissemination.AckResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DisseminationMethodDescriptorSupplier("ReportFailure"))
              .build();
        }
      }
    }
    return getReportFailureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.dissemination.JoinRequestMessage,
      io.grpc.dissemination.MembershipList> getJoinRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "JoinRequest",
      requestType = io.grpc.dissemination.JoinRequestMessage.class,
      responseType = io.grpc.dissemination.MembershipList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.dissemination.JoinRequestMessage,
      io.grpc.dissemination.MembershipList> getJoinRequestMethod() {
    io.grpc.MethodDescriptor<io.grpc.dissemination.JoinRequestMessage, io.grpc.dissemination.MembershipList> getJoinRequestMethod;
    if ((getJoinRequestMethod = DisseminationGrpc.getJoinRequestMethod) == null) {
      synchronized (DisseminationGrpc.class) {
        if ((getJoinRequestMethod = DisseminationGrpc.getJoinRequestMethod) == null) {
          DisseminationGrpc.getJoinRequestMethod = getJoinRequestMethod =
              io.grpc.MethodDescriptor.<io.grpc.dissemination.JoinRequestMessage, io.grpc.dissemination.MembershipList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JoinRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.dissemination.JoinRequestMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.dissemination.MembershipList.getDefaultInstance()))
              .setSchemaDescriptor(new DisseminationMethodDescriptorSupplier("JoinRequest"))
              .build();
        }
      }
    }
    return getJoinRequestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DisseminationStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DisseminationStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DisseminationStub>() {
        @java.lang.Override
        public DisseminationStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DisseminationStub(channel, callOptions);
        }
      };
    return DisseminationStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static DisseminationBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DisseminationBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DisseminationBlockingV2Stub>() {
        @java.lang.Override
        public DisseminationBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DisseminationBlockingV2Stub(channel, callOptions);
        }
      };
    return DisseminationBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DisseminationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DisseminationBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DisseminationBlockingStub>() {
        @java.lang.Override
        public DisseminationBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DisseminationBlockingStub(channel, callOptions);
        }
      };
    return DisseminationBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DisseminationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DisseminationFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DisseminationFutureStub>() {
        @java.lang.Override
        public DisseminationFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DisseminationFutureStub(channel, callOptions);
        }
      };
    return DisseminationFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void reportFailure(io.grpc.dissemination.FailureReport request,
        io.grpc.stub.StreamObserver<io.grpc.dissemination.AckResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReportFailureMethod(), responseObserver);
    }

    /**
     */
    default void joinRequest(io.grpc.dissemination.JoinRequestMessage request,
        io.grpc.stub.StreamObserver<io.grpc.dissemination.MembershipList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJoinRequestMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Dissemination.
   */
  public static abstract class DisseminationImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return DisseminationGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Dissemination.
   */
  public static final class DisseminationStub
      extends io.grpc.stub.AbstractAsyncStub<DisseminationStub> {
    private DisseminationStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DisseminationStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DisseminationStub(channel, callOptions);
    }

    /**
     */
    public void reportFailure(io.grpc.dissemination.FailureReport request,
        io.grpc.stub.StreamObserver<io.grpc.dissemination.AckResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReportFailureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void joinRequest(io.grpc.dissemination.JoinRequestMessage request,
        io.grpc.stub.StreamObserver<io.grpc.dissemination.MembershipList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getJoinRequestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Dissemination.
   */
  public static final class DisseminationBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DisseminationBlockingV2Stub> {
    private DisseminationBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DisseminationBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DisseminationBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public io.grpc.dissemination.AckResponse reportFailure(io.grpc.dissemination.FailureReport request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReportFailureMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.dissemination.MembershipList joinRequest(io.grpc.dissemination.JoinRequestMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getJoinRequestMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Dissemination.
   */
  public static final class DisseminationBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DisseminationBlockingStub> {
    private DisseminationBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DisseminationBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DisseminationBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.dissemination.AckResponse reportFailure(io.grpc.dissemination.FailureReport request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReportFailureMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.dissemination.MembershipList joinRequest(io.grpc.dissemination.JoinRequestMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getJoinRequestMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Dissemination.
   */
  public static final class DisseminationFutureStub
      extends io.grpc.stub.AbstractFutureStub<DisseminationFutureStub> {
    private DisseminationFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DisseminationFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DisseminationFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.dissemination.AckResponse> reportFailure(
        io.grpc.dissemination.FailureReport request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReportFailureMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.dissemination.MembershipList> joinRequest(
        io.grpc.dissemination.JoinRequestMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getJoinRequestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REPORT_FAILURE = 0;
  private static final int METHODID_JOIN_REQUEST = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REPORT_FAILURE:
          serviceImpl.reportFailure((io.grpc.dissemination.FailureReport) request,
              (io.grpc.stub.StreamObserver<io.grpc.dissemination.AckResponse>) responseObserver);
          break;
        case METHODID_JOIN_REQUEST:
          serviceImpl.joinRequest((io.grpc.dissemination.JoinRequestMessage) request,
              (io.grpc.stub.StreamObserver<io.grpc.dissemination.MembershipList>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getReportFailureMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.grpc.dissemination.FailureReport,
              io.grpc.dissemination.AckResponse>(
                service, METHODID_REPORT_FAILURE)))
        .addMethod(
          getJoinRequestMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.grpc.dissemination.JoinRequestMessage,
              io.grpc.dissemination.MembershipList>(
                service, METHODID_JOIN_REQUEST)))
        .build();
  }

  private static abstract class DisseminationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DisseminationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.dissemination.DisseminationOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Dissemination");
    }
  }

  private static final class DisseminationFileDescriptorSupplier
      extends DisseminationBaseDescriptorSupplier {
    DisseminationFileDescriptorSupplier() {}
  }

  private static final class DisseminationMethodDescriptorSupplier
      extends DisseminationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DisseminationMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DisseminationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DisseminationFileDescriptorSupplier())
              .addMethod(getReportFailureMethod())
              .addMethod(getJoinRequestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
