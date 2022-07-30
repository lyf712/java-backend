package doclearn.naming;


import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.junit.Test;

/**
 * 通过Client1.x,http的通信方式进行实例服务操作.
 *
 * @author liyunfei
 */
public class NamingTests {
    // 单机版
    String serverListStandalone = "localhost:8848";
    
    @Test
    public void testRegisterServiceInstance() throws NacosException, NacosException {
        
        NamingService namingService = NamingFactory.createNamingService(serverListStandalone);
        Instance instance = new Instance();
        instance.setInstanceId("provider.id.1");
        instance.setServiceName("provider-test-1");
        instance.setIp("localhost");
        instance.setPort(1001);
        namingService.registerInstance("provider-test-1",instance);
        
        namingService.getAllInstances("provider-test-1").forEach(System.out::println);
    }
}
