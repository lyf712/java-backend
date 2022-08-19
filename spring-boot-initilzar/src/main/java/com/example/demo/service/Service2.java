package com.example.demo.service;

import com.example.demo.config.ServiceOnCondition2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

/**
 * @author liyunfei
 */
@Conditional(value = ServiceOnCondition2.class)
@Service
public class Service2 implements HelloService{
    
    @Override
    public void ok() {
        System.out.println("service2");
    }
}
