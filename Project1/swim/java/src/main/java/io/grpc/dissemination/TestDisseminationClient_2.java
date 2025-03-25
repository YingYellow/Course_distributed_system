package main.java.io.grpc.dissemination;

// Node.java
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.dissemination.*;

import java.io.IOException;
import java.util.*;

public class TestDisseminationClient_2 {
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
            try {
                Thread.sleep(1000); // Wait for server to be up


                if ("node-1".equals(NODE_ID)){

                    String failedNode = chooseOtherNode();
                    System.out.println("Simulating failure of node " + failedNode);

                    membershipList.add("node-1");
                    membershipList.add("node-3");
                    membershipList.add("node-5");

                    // Broadcast
                    membershipList.remove(failedNode.split(":")[0]);
                    System.out.println(membershipList);
                    for (String target : membershipList) {
                        if (target.equals(NODE_ID)) continue;
                        int port = NODE_PORTS.getOrDefault(target, 50052); // 默认防御性处理
                        DisseminationClient client = new DisseminationClient(target + ":" + port, NODE_ID);
                        client.sendFailure(failedNode);
                    }

                    Thread.sleep(5000);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
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
