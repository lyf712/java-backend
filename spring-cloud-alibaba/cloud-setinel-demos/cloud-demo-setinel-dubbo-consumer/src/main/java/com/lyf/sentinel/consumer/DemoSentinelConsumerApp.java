package com.lyf.sentinel.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liyunfei
 */
@EnableDiscoveryClient
@SpringBootApplication
public class DemoSentinelConsumerApp {
    
    public static void main(String[] args) {
        SpringApplication.run(DemoSentinelConsumerApp.class,args);
    }
}
