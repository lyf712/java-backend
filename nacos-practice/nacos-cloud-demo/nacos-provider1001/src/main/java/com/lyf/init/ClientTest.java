package com.lyf.init;

import com.alibaba.nacos.api.config.ConfigFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author liyunfei
 */
@Component
public class ClientTest {
    @PostConstruct
    void printBaseInfo() throws NacosException {
        // 1.4.2--client
        ConfigService configService = ConfigFactory.createConfigService("");
    }
}
