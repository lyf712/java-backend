package com.lyf.controller;

import com.lyf.bean.UserBean1;
import com.lyf.bean.UserBean2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 配置自动刷新
 * 动态刷新原理：https://blog.csdn.net/gupaoedu_tom/article/details/126481559
 * 1.采用长轮询+MD5
 * 2.grpc主动推送
 * springcloud-client ; 注册集群-- server
 * 具体源码分析、解析
 * Listener 监听数据变化
 * longpollingService;configController;ConfigChangeEvent
 * NacosContextRefresher
 * 与SpringCloud的打通见 PropertiesListener
 * 与Spring的打通：https://github.com/nacos-group/nacos-spring-project
 * @author liyunfei
 */
@RestController
@RefreshScope
public class ConfigController {
    
    private final Logger logger = LoggerFactory.getLogger(ConfigController.class);
    
    @Value("${user.name}")
    private String userName;
    
    @Value("${user.age}")
    private int userAge;
    
    @Autowired
    UserBean1 userBean1;
    
    @Autowired
    UserBean2 userBean2;
    
    @PostConstruct
    public void init(){
        logger.info("configController init {} {}", userName, userAge);
    }
    
    @PreDestroy
    public void pre(){
        logger.info("configController preDestroy {} {}", userName, userAge);
    }
    
    @GetMapping("/test")
    public String test() {
        logger.info("[http] {} {}", userName, userAge);
        return userName + ":" + userAge;
    }
    
}
