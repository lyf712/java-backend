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
public class TestAspect2 {
    
    private static final String SERVICE_1 = "execution(* com.example.demo.service.Service1.ok(..))";
    
    private static final String SERVICE_2 = "execution(* com.example.demo.service.Service2.ok(..))";
    
    private static final String SERVICE_INTERFACE = "execution(* com.example.demo.service.HelloService.ok(..))";
    
    @Around(SERVICE_1)
    public Object test1(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aop::test1");
        return pjp.proceed();
    }
    
    @Around(SERVICE_2)
    public Object test2(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aop::test2");
        return pjp.proceed();
    }
    
    @Around(SERVICE_INTERFACE)
    public Object testInterface(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aop:interface");
        return pjp.proceed();
    }
    
    
}
