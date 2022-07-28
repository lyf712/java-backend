package com.lyf.doclearn.config;

import com.alibaba.nacos.api.config.ConfigFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.Assert;
import org.junit.Test;

/**
 * 通过jdk-java client1.x 测试配置管理 （1）nacos client1.x通过走http的方式.
 *
 * @author liyunfei
 */
public class ConfigTests {
    
    //测试单机版
    String serverAddrStandalone = "localhost:8848";
    
    @Test
    public void testPublishConfig() throws NacosException {
        ConfigService configService = ConfigFactory.createConfigService(serverAddrStandalone);
        configService.publishConfig("nacos.test.1", "DEFUALT_GROUP", "test:ok");
        String content = configService.getConfig("nacos.test.1", "DEFAULT_GROUP", 2000);
        System.out.println(content);
        Assert.assertNotNull(content);
    }
    
    
}
