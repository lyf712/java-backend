package com.lyf.doclearn.naming;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Cluster;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.api.naming.pojo.Service;
import com.alibaba.nacos.api.naming.pojo.healthcheck.AbstractHealthChecker;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过Client1.x,http的通信方式进行实例服务操作.
 *
 * @author liyunfei
 */
public class NamingTests {
    // 单机版
    String serverListStandalone = "localhost:8847";
    
    String serverAddrCluster = "localhost:8847,localhost:8849,localhost:8851";
    
    String serverAddrCluster2 = "localhost:8802,localhost:8804,localhost:8806";
    
    @Test
    public void testRegisterServiceInstance() throws NacosException {
        
        NamingService namingService = NamingFactory.createNamingService(serverAddrCluster2);
        Instance instance = new Instance();
        instance.setInstanceId("provider.id.2");
        instance.setServiceName("provider-test-1");
        instance.setIp("localhost");
        instance.setPort(1002);
        namingService.registerInstance("provider-test-1",instance);
        
        namingService.getAllInstances("provider-test-1").forEach(System.out::println);
    }
    @Test
    public void testRegisterInstanceCluster() throws NacosException {
        NamingService naming = NamingFactory.createNamingService(serverListStandalone);
        naming.registerInstance("nacos.test.3", "11.11.11.11", 8888, "TEST1");
    
//        Instance instance = new Instance();
//        instance.setIp("55.55.55.55");
//        instance.setPort(9999);
//        instance.setHealthy(false);
//        instance.setWeight(2.0);
//        Map<String, String> instanceMeta = new HashMap<>();
//        instanceMeta.put("site", "et2");
//        instance.setMetadata(instanceMeta);
    
//        Service service = new Service("nacos.test.4");
////        service.setApp("nacos-naming");
////        service.sethealthCheckMode("server");
////        service.setEnableHealthCheck(true);
//        service.setProtectThreshold(0.8F);
//        //service.setGroup("CNCF");
//        Map<String, String> serviceMeta = new HashMap<>();
//        serviceMeta.put("symmetricCall", "true");
//        service.setMetadata(serviceMeta);
        //instance.setService(service);
    
//        Cluster cluster = new Cluster();
//        cluster.setName("TEST5");
//        AbstractHealthChecker.Http healthChecker = new AbstractHealthChecker.Http();
//        healthChecker.setExpectedResponseCode(400);
//        healthChecker.setCurlHost("USer-Agent|Nacos");
//        healthChecker.setCurlPath("/xxx.html");
//        cluster.setHealthChecker(healthChecker);
//        Map<String, String> clusterMeta = new HashMap<>();
//        clusterMeta.put("xxx", "yyyy");
//        cluster.setMetadata(clusterMeta);
//
//        instance.setCluster(cluster);
//
//        naming.registerInstance("nacos.test.4", instance);
    }
    
}
