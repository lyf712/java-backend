package com.lyf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liyunfei
 */
@SpringBootApplication
//@NacosPropertySource(dataId = "example", autoRefreshed = true)
public class NacosSpringBootConfigApp {
    
    public static void main(String[] args) {
        SpringApplication.run(NacosSpringBootConfigApp.class,args);
    }
}
