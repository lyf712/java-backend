package com.lyf.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liyunfei
 */
@EnableDiscoveryClient
@SpringBootApplication
public class DemoProviderApp {
    
    public static void main(String[] args) {
        SpringApplication.run(DemoProviderApp.class,args);
    }
}
