package com.lyf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyunfei
 */
@RestController
@RefreshScope
public class ConfigController {
    @Value("${userCache:false}")
    String userCache;
    @Value("${test1:ok}")
    String test1;
    
    @GetMapping("/get")
    String get(){return userCache+"::"+test1;}
}
