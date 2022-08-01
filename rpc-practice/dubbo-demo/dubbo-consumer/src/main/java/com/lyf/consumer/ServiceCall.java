package com.lyf.consumer;

import com.lyf.rpc.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author liyunfei
 */
@Service
public class ServiceCall {
    @DubboReference
    HelloService helloService;
    @PostConstruct
    void init(){
        System.out.println("consumer receive::"+helloService.sayHello("i am consumer!!"));
    }
}
