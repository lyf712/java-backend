package com.lyf.rpc;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

/**
 * @author liyunfei
 */
@EnableDubbo
@SpringBootApplication
public class DubboProviderApp {
    
    public static void main(String[] args) throws InterruptedException {
        //org.apache.dubbo.common.URLBuilder
        //org.apache.commons.lang3.StringUtils
        new EmbedZookeeper(2181, false).start();
        SpringApplication.run(DubboProviderApp.class, args);
        //System.out.println("dubbo service started");
        //new CountDownLatch(1).await();
    }
}
