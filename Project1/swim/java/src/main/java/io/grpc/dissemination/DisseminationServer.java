package main.java.io.grpc.dissemination;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.dissemination.*;
import java.io.IOException;

public class DisseminationServer {
    private static final int PORT = Integer.parseInt(System.getenv().getOrDefault("JAVA_PORT", "50052"));

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = PORT;

        Server server = ServerBuilder.forPort(port)
                .addService(new DisseminationService())  // 服务实现类
                .build()
                .start();

        System.out.println("Dissemination java server started at port " + port);
        server.awaitTermination();
    }
}