package com.lyf.dubboconsumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liyunfei
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableDubbo
public class DemoDubboConsumerApp {
    
    public static void main(String[] args) {
        SpringApplication.run(DemoDubboConsumerApp.class,args);
    }
}
