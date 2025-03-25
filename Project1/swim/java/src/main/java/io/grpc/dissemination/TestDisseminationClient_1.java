package main.java.io.grpc.dissemination;

// Node.java
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.dissemination.*;

import java.io.IOException;
import java.util.*;

public class TestDisseminationClient_1 {
    private static final String NODE_ID = System.getenv().getOrDefault("NODE_ID", "unknown-node");
    private static final int PORT = Integer.parseInt(System.getenv().getOrDefault("JAVA_PORT", "50052"));
    private static final List<String> ALL_NODES = Arrays.asList(
            "node-1:50051", "node-2:50052", "node-3:50053", "node-4:50054", "node-5:50055"
    );

    private static final Map<String, Integer> NODE_PORTS = Map.of(
            "node-1", 50051,
            "node-2", 50052,
            "node-3", 50053,
            "node-4", 50054,
            "node-5", 50055
    );


    private static final List<String> membershipList = new ArrayList<>();

    public static void main(String[] args) throws IOException, InterruptedException {
//        for (String n : ALL_NODES) {
//            if (!n.startsWith(NODE_ID)) {
//                membershipList.add(n);
//            }
//        }

        Thread clientThread = new Thread(() -> {
            if ("node-1".equals(NODE_ID)){
                try {
                    Thread.sleep(1000); // Wait for server to be up
                    // Join: contact another node
                    for (int i = 0; i < 2; i++){
                        String bootstrap = chooseOtherNode();
                        DisseminationClient bootstrapClient = new DisseminationClient(bootstrap, NODE_ID);
                        MembershipList list = bootstrapClient.join(NODE_ID);
                        membershipList.clear();
                        membershipList.addAll(list.getNodesList());
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }});
        clientThread.start();

        clientThread.join();
    }

    private static String chooseOtherNode() {
        List<String> others = new ArrayList<>(ALL_NODES);
        others.removeIf(n -> n.startsWith(NODE_ID));
        Collections.shuffle(others);
        return others.get(0);
    }
}
