package com.lyf.consumer.controller;

import com.lyf.consumer.config.RestTemplateConfig;
import com.lyf.consumer.openfeign.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author liyunfei
 */
@RestController
public class ConsumerController {
    private static final String URL="http://demo-discovery-provider/provider/test/";
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ProviderService providerService;
   
    @GetMapping("/consumer/test1/{msg}")
    String test1(@PathVariable String msg){
        LOGGER.info("call by rest");
        return restTemplate.getForObject(URL+msg,String.class);
    }
    
    @GetMapping("/consumer/test2/{msg}")
    String test2(@PathVariable String msg){
        LOGGER.info("call by openfeign");
        return providerService.test(msg);//restTemplate.getForObject(URL+msg,String.class);
    }
}
