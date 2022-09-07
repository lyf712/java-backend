package com.example.demo.config.transactionbroadcast;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author liyunfei
 */
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@Aspect
@Component
public class TestAspect2 {
    
    private static final String SERVICE_1 = "execution(* com.example.demo.service.transactionbroadcast.Service1.doPost(..))";
    
    private static final String SERVICE_2 = "execution(* com.example.demo.service.transactionbroadcast.Service2.doPost(..))";
    
    private static final String SERVICE_INTERFACE = "execution(* com.example.demo.service.transactionbroadcast.HelloService.dispatcher(..))";
    
    private static final String SERVICE_INTERFACE_POST = "execution(* com.example.demo.service.transactionbroadcast.HelloService.doPost(..))";
    
    private static final String SERVICE_INTERFACE_GET = "execution(* com.example.demo.service.transactionbroadcast.HelloService.doGet(..))";
    
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
    
    @Around(SERVICE_INTERFACE_POST)
    public Object testInterfacePost(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aop:interface-post");
        return pjp.proceed();
    }
    
    @Around(SERVICE_INTERFACE_GET)
    public Object testInterfaceGet(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aop:interface-get");
        return pjp.proceed();
    }
}
