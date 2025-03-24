package main.java.io.grpc.dissemination;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.dissemination.*;
import java.io.IOException;

public class DisseminationServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 50052;

        Server server = ServerBuilder.forPort(port)
                .addService(new DisseminationService())  // 服务实现类
                .build()
                .start();

        System.out.println("Dissemination server started at port " + port);
        server.awaitTermination();
    }
}