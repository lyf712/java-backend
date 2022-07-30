package com.lyf.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import javax.annotation.PostConstruct;

/**
 * @author liyunfei
 */
@RefreshScope
public class ConfigController {
    @Value("nacos.test.1")
    String test;
    
    @PostConstruct
    void readyInfo(){
        System.out.println(test);
    }
}
