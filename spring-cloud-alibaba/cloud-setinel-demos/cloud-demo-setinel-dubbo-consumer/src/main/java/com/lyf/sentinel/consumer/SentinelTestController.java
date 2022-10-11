package com.lyf.sentinel.consumer;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lyf.sentinel.api.SentinelTestService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 */
@RestController
public class SentinelTestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SentinelTestController.class);
    
    @Reference
    SentinelTestService sentinelTestService;
    @Autowired
    LocalService localService;
    
    //1.nacos宕机：Waiting server-side response timeout by scan timer. start time: 2022-10-11 20:41:37.930, end time: 2022-10-11 20:41:38.944, client elapsed: 0 ms, server elapsed: 1014 ms, timeout: 1000 ms, request: Request [id=11, version=2.0.2, twoway=true, event=false, broken=false, data=null], channel: /192.168.247.1:53273 -> /192.168.247.1:20881
    //	at org.ap
    // dubbo间无法保持RPC通信
    @SentinelResource(value = "SentinelTestController-testCall")
    @GetMapping("/demo/testCall/{param}")
    public String testCallProvider(@PathVariable("param")String param){
        LOGGER.info("enter consumer controller");
        return sentinelTestService.hello(param);
    }
    
    @SentinelResource(value = "SentinelTestController-testLocal")
    @GetMapping("/demo/testLocal/{param}")
    public String testLocal(@PathVariable("param")String param){
        return localService.localService(param);//sentinelTestService.hello(param);
    }
    
    @SentinelResource(value = "SentinelTestController-testMock")
    @GetMapping("/demo/testMock/{param}")
    public String testMock(@PathVariable("param")Integer param){
        try {
            TimeUnit.SECONDS.sleep(param);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";//sentinelTestService.hello(param);
    }
}
