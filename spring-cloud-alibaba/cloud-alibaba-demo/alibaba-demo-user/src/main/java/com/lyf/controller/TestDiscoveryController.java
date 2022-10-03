package com.lyf.controller;

import com.alibaba.nacos.common.http.client.NacosRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author liyunfei
 */
@RestController
public class TestDiscoveryController {
    @Autowired
    DiscoveryClient discoveryClient;
    // RestTemplate接口？
//    @Autowired
//    NacosRestTemplate nacosRestTemplate;
    @Autowired
    RestTemplate restTemplate;
    
    
}
