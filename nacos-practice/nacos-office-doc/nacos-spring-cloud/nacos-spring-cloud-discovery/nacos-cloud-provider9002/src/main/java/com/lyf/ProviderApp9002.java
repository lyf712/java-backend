package com.lyf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liyunfei
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderApp9002 {
    
    public static void main(String[] args) {
        ///org.apache.http.impl.client.HttpClientBuilder
        SpringApplication.run(ProviderApp9002.class,args);
    }
}
