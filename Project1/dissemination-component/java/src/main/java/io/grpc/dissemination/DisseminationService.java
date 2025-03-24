package main.java.io.grpc.dissemination;
import io.grpc.dissemination.*;
import io.grpc.stub.StreamObserver;
import java.util.*;

public class DisseminationService extends DisseminationGrpc.DisseminationImplBase {

    private static final String NODE_ID = System.getenv().getOrDefault("NODE_ID", "unknown-node");
    private static final List<String> ALL_NODES = Arrays.asList(
            "node-1:50051", "node-2:50052", "node-3:50053", "node-4:50054", "node-5:50055"
    );

    private final Set<String> membershipList = Collections.synchronizedSet(new HashSet<>());

    @Override
    public void reportFailure(FailureReport request, StreamObserver<AckResponse> responseObserver) {

        String sender = request.getSenderId();
        String failedNode = request.getFailedNode();

        System.out.printf("Component Dissemination of Node %s runs RPC ReportFailure called by Component Dissemination of Node %s\n", System.getenv("NODE_ID"), sender);

        boolean removed = membershipList.remove(failedNode);

        AckResponse response = AckResponse.newBuilder()
                .setSuccess(removed)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


//    @Override
//    public void reportFailure(FailureReport request, StreamObserver<AckResponse> responseObserver) {
//        String failedNode = request.getFailedNode();
//        String sender = request.getSenderId();
//
//        System.out.println("Component " + COMPONENT_NAME + " of Node " + NODE_ID +
//                " runs RPC reportFailure called by Component " + COMPONENT_NAME + " of Node " + sender);
//
//        boolean removed = membershipList.remove(failedNode);
//
//        // 广播故障信息给所有剩余节点
//        for (String target : membershipList) {
//            DisseminationClient client = new DisseminationClient(target, NODE_ID);
//            client.sendFailure(NODE_ID, failedNode);
//        }
//
//        AckResponse response = AckResponse.newBuilder()
//                .setSuccess(removed)
//                .build();
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
    @Override
    public void joinRequest(JoinRequestMessage request, StreamObserver<MembershipList> responseObserver) {
        String newNode = request.getNewNodeId();

        System.out.printf("Component Dissemination of Node %s runs RPC JoinRequest called by Component Dissemination of Node %s\n",
                System.getenv("NODE_ID"),
                newNode);
        membershipList.add(System.getenv("NODE_ID"));
        membershipList.add(newNode);

        MembershipList list = MembershipList.newBuilder()
                .addAllNodes(membershipList)
                .build();

        responseObserver.onNext(list);
        responseObserver.onCompleted();
    }
}