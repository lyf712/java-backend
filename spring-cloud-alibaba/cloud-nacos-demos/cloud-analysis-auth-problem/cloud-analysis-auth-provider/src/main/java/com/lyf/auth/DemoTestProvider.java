package com.lyf.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liyunfei
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DemoTestProvider {
    
    public static void main(String[] args) {
        SpringApplication.run(DemoTestProvider.class,args);
    }
}
