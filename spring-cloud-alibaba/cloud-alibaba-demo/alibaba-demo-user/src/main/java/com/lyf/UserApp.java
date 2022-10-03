package com.lyf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liyunfei
 */
@EnableDiscoveryClient
@SpringBootApplication
public class UserApp {
    
    public static void main(String[] args) {
        SpringApplication.run(UserApp.class,args);
    }
}
