package com.lyf.sentinel.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liyunfei
 */
@EnableDiscoveryClient
@SpringBootApplication
public class DemoSentinelGatewayApp {
    
    public static void main(String[] args) {
        SpringApplication.run(DemoSentinelGatewayApp.class,args);
    }
}
