package doclearn.config;

import com.alibaba.nacos.api.config.ConfigFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

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
        
        configService.publishConfig("rpc-test.text", "DEFAULT_GROUP", "ok");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String content = configService.getConfig("rpc-test.text", "DEFAULT_GROUP", 5000);
        Assert.assertNotNull(content);
    }
    
    @Test
    public void testRemoveConfig() throws NacosException {
        ConfigService configService = ConfigFactory.createConfigService(serverAddrStandalone);
        boolean rs = configService.removeConfig("rpc-test.text","DEFAULT_GROUP");
        Assert.assertTrue(rs);
    }
    
}
