package com.example.demo.service.transactionbroadcast;

import com.example.demo.config.ServiceOnCondition2;
import org.springframework.aop.framework.AopContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

/**
 * @author liyunfei
 */
@Conditional(value = ServiceOnCondition2.class)
@Service
public class Service2 implements HelloService{
    @Override
    public void dispatcher(String args) {
        if ("post".equals(args)) {
            ((Service2) AopContext.currentProxy()).doPost();
            return;
        } else if ("get".equals(args)) {
            ((HelloService) AopContext.currentProxy()).doGet();
            return;
        }
        System.out.println("args error...");
    }
    
    @Override
    public void doPost() {
        System.out.println("service2 do post");
    }
    
    @Override
    public void doGet() {
        System.out.println("service2 do get");
    }
}
