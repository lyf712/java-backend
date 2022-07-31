package com.lyf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * call other service sample.
 * @author liyunfei
 */
@RestController
public class CallController {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/get")
    String get(){return restTemplate.getForObject("http://provider-service/hello",String.class);}
}
