package com.lyf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liyunfei
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderApp9001 {
    
    public static void main(String[] args) {
        SpringApplication.run(ProviderApp9001.class,args);
    }
}
