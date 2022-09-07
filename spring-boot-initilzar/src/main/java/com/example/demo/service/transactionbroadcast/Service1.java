package com.example.demo.service.transactionbroadcast;

import com.example.demo.config.ServiceOnCondition1;
import org.springframework.aop.framework.AopContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

/**
 * ref:https://www.jb51.net/article/221085.htm
 * @author liyunfei
 */
@Conditional(value = ServiceOnCondition1.class)
@Service
public class Service1 implements HelloService {
    
    @Override
    public void dispatcher(String args) {
        if ("post".equals(args)) {
            //doPost();
            ((HelloService) AopContext.currentProxy()).doPost();
            return;
        } else if ("get".equals(args)) {
            ((HelloService) AopContext.currentProxy()).doGet();
            return;
        }
        System.out.println("args error...");
    }
    
    @Override
    public void doPost() {
        System.out.println("service1 do post");
    }
    
    @Override
    public void doGet() {
        System.out.println("service1 do get");
    }
}
