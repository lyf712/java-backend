package com.example.demo.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author liyunfei
 */
@EnableAspectJAutoProxy(exposeProxy = true)
@Aspect
@Component
public class TestAspect {
    
    private static final String SERVICE_1 = "execution(* com.example.demo.service.TestService.test(..))";
    
    private static final String SERVICE_2 = "execution(* com.example.demo.service.TestService.test2(..))";
    
    @Around(SERVICE_1)
    public Object test1(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("test1");
        return pjp.proceed();
    }
    
    @Around(SERVICE_2)
    public Object test2(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("test2");
        return pjp.proceed();
    }
    
    
    
    
    
    
}
