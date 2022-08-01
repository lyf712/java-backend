package com.lyf.rpc.impl;

import com.lyf.rpc.HelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;

/**
 * 通信的本质：建立通道、连接--公共点；内存共享，管道，netty网络通信，IO 都是需要 A、B至少两端+ 传输介质（socket通道等，物理介质，内存，文件，三方端公用).
 *
 * @author liyunfei
 */
@DubboService
public class HelloServiceImpl implements HelloService {
    
    @Override
    public String sayHello(String name) {
        System.out.println("hello:" + name + "::" + RpcContext.getContext().getRemoteAddressString());
        return "ok";
    }
}
