package com.example.demo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author liyunfei
 */
@Aspect
@Component
public class TestAopCutServiceAspect {
    
    private static final String TEST_METHOD0 = "execution(* com.example.demo.service.TestAspectService.testMethod0())";
    
    private static final String TEST_METHOD2 =
            "execution(* com.example.demo.service.TestAspectService.testMethod2(..))" + " && args(arg1)";
    
    @Before(TEST_METHOD2)
    String beforeTestMethod2(JoinPoint joinPoint, String arg1) throws Exception {
        System.out.println("before..");
        int random = new Random().nextInt(20);
//        try {
//            System.out.println(random);
//            if (random < 10) {
//                throw new Exception("not success");
//            }
//        } catch (Exception ignored) {
//            System.out.println(ignored.getMessage());
//        }
//        if(random<10){
//            throw new Exception("not success");
//        }
        
        return "ok";
    }
    
    @After(TEST_METHOD2)
    String afterTestMethod2(JoinPoint joinPoint, String arg1) {
        System.out.println("after.." + arg1);
        return "ok";
    }
    
    
    @AfterReturning(value = TEST_METHOD2, returning = "retVal")
    String afterReturningTestMethod2(JoinPoint joinPoint, String arg1, String retVal) {
        System.out.println("after return.." + retVal);
        return "ok";
    }
    
    @AfterThrowing(value = TEST_METHOD2, throwing = "ex")
    String afterThrowingTestMethod2(JoinPoint joinPoint, String arg1, Exception ex) {
        System.out.println("after throwing.." + ex);
        return "ok";
    }
}
