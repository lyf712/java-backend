package com.lyf.sentinel.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liyunfei
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DemoSentinelProviderApp {
    
    public static void main(String[] args) {
        SpringApplication.run(DemoSentinelProviderApp.class,args);
    }
}
