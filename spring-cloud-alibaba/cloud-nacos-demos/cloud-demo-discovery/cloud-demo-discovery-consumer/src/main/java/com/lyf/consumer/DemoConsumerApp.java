package com.lyf.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author liyunfei
 */
@EnableDiscoveryClient
@SpringBootApplication
// 扫描---
@EnableFeignClients
public class DemoConsumerApp {
    
    public static void main(String[] args) {
        SpringApplication.run(DemoConsumerApp.class,args);
    }
}
