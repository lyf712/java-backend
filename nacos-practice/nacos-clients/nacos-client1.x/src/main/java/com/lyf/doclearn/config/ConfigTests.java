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
    String serverAddrCluster = "localhost:8847,localhost:8849,localhost:8851";
    
    @Test
    public void testPublishConfig() throws NacosException {
        ConfigService configService = ConfigFactory.createConfigService(serverAddrCluster);
        //configService.publishConfig("nacos.test.cluster1", "DEFAULT_GROUP", "test:ok");
        // --sleep
        String content = configService.getConfig("nacos.test.cluster1", "DEFAULT_GROUP", 5000);
        System.out.println(content);
        Assert.assertNotNull(content);
    }
    
    
}
