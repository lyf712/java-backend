package com.lyf.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author liyunfei
 */
@Configuration
public class RestTemplateConfig {
    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){return new RestTemplate();}
}
