package com.lyf.provider;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author liyunfei
 */
public class GrpcServer {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(1010)
                        .addService(new HelloServiceImpl())
                        .build()
                        .start();
        server.awaitTermination();
    }
}
