package com.lyf.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyunfei
 */
@RestController
public class TestController {
    
    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private String useLocalCache;
    
    @NacosValue(value = "${server.port}",autoRefreshed = true)
    private String port;
    
    @NacosValue(value = "${test1}",autoRefreshed = true)
    private String test1;
    // TODO didnt auto refresh
    @NacosValue(value = "${test2}")
    private String test2;
    
    @GetMapping("/get")
    public String get() {
        System.out.println(port+"::"+test1+"::"+test2);
        return useLocalCache;
    }
}
