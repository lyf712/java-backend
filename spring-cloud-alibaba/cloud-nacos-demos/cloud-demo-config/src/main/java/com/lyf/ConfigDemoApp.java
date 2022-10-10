package com.lyf;

import com.lyf.bean.UserBean1;
import com.lyf.bean.UserBean2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * https://nacos.io/zh-cn/docs/quick-start-spring-cloud.html
 * @author liyunfei
 */
@EnableDiscoveryClient
@SpringBootApplication
//@RefreshScope
@EnableConfigurationProperties(value = {UserBean1.class, UserBean2.class})
public class ConfigDemoApp {
    
    @Value("${user.name}")
    private String userName;
    
    @Value("${user.age}")
    private int userAge;
    
    @PostConstruct
    public void init() {
        System.out.printf("[ConfigDemoApp init] user name : %s , age : %d%n", userName, userAge);
    }
    
    @PreDestroy
    public void preDestroy() {
        System.out.printf("[ConfigDemoApp preDestroy] user name : %s , age : %d%n", userName, userAge);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(ConfigDemoApp.class, args);
    }
}
