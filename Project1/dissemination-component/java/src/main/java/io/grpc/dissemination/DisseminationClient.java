package main.java.io.grpc.dissemination;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.dissemination.*;

public class DisseminationClient {

    private final DisseminationGrpc.DisseminationBlockingStub stub;
    private final String nodeId;

    public DisseminationClient(String target, String nodeId) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();
        stub = DisseminationGrpc.newBlockingStub(channel);
        this.nodeId = nodeId;
    }

    public void sendFailure(String failedNode) {
        FailureReport report = FailureReport.newBuilder()
                .setSenderId(nodeId)
                .setFailedNode(failedNode)
                .build();

        System.out.printf("Component Dissemination of Node %s sends Failure of %s to Component Dissemination of Node %s\n", nodeId, failedNode, stub.getChannel().authority());


        AckResponse response = stub.reportFailure(report);
    }



    public MembershipList join(String joiningNodeId) {

        JoinRequestMessage msg = JoinRequestMessage.newBuilder()
                .setNewNodeId(joiningNodeId)
                .build();

        System.out.printf("Component Dissemination of Node %s sends RPC JoinRequest to Component Dissemination of Node %s\n", nodeId, stub.getChannel().authority());

        MembershipList list = stub.joinRequest(msg);
        System.out.println("Membership list received of " + nodeId + " is" + list.getNodesList());
        return list;
    }
}
