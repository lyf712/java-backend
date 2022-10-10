package com.lyf.dubboprovider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liyunfei
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableDubbo
public class DemoDubboProviderApp {
    
    public static void main(String[] args) {
        SpringApplication.run(DemoDubboProviderApp.class,args);
    }
}
