package com.lyf.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liyunfei
 */
@SpringBootApplication
public class GrpcServerApp {
    public static void main(String[] args) {
        SpringApplication.run(GrpcServerApp.class,args);
    }
}
