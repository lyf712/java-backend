package com.lyf.server.config;

import com.lyf.server.service.DemoService1GrpcImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @author liyunfei
 */
@Configuration
public class GrpcServerConfig {
    
    @Value("${server.port}")
    int serverPort;
    
    @PostConstruct
    void init() throws IOException {
        int grpc = 1001;
        if (serverPort > 2000) {
            grpc = serverPort - 1000;
        }
        System.out.println(serverPort+"::"+grpc);
        Server server = ServerBuilder.forPort(grpc)
                .addService(new DemoService1GrpcImpl())
                .build()
                .start();
        try {
            System.out.println("grpc server started!!");
            server.awaitTermination();
            System.out.println("grpc finish");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
