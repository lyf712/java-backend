package com.lyf;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liyunfei
 */
@EnableDubbo
@SpringBootApplication
public class DubboConsumerApp {
    
    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApp.class,args);
    }
}
