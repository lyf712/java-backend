package com.example.demo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author liyunfei
 */
@Aspect
@Component
public class TestAopCutControllerAspect {
    
    private static final String POINTCUT_NAME =
            "execution(* com.example.demo.controller.TestAopController.testAop(..))" + "" + " && args(arg1,arg2)";
    
    private static final String BEFORE_EX1 = "beforeEx1";
    
    private static final String BEFORE_EX2 = "beforeEx2";
    
    // argsName可以单独在注解里面使用
    // 区别afterreturn和after
    // before的职责
    // 1.校验处理、拦截 2.将处理的信息传递给下游处理服务
    //
    //在连接点之前执行的建议，但是它不能阻止执行流程前进到连接点
    @Before(POINTCUT_NAME)
    Object beforeExecute(JoinPoint joinPoint, String arg1, Integer arg2) throws Exception {
        System.out.println("before target >> arg1:" + arg1 + ";arg2:" + arg2);
        // 投递信息
        // false → produce
        // true → 放行，return再produce
        // 执行beforePriorQueue
        
        // 不能阻断 execute;
        // 若在此进行抛异常，则可阻断---
        if (BEFORE_EX1.equals(arg1)) {
            throw new Exception("BEFORE_EX1");
        } else if (BEFORE_EX2.equals(arg1)) {
            try {
                // extends ConfigException?
                throw new Exception("BEFORE_EX2");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "before rs";
    }
    
    //在连接点正常完成后要执行
    @AfterReturning(value = POINTCUT_NAME, returning = "retVal")
    Object afterReturnExecute(JoinPoint joinPoint, String arg1, Integer arg2, Object retVal) {
        System.out.println("afterReturn target >> arg1:" + arg1 + ";arg2:" + arg2 + ";retVal" + retVal);
        // 此处进行after推送
        return "afterReturn rs";
    }
    
    //如果方法因抛出异常而退出，则要执行
    @AfterThrowing(value = POINTCUT_NAME, throwing = "ex")
    Object afterThrowingExecute(JoinPoint joinPoint, String arg1, Integer arg2, Exception ex) {
        System.out.println("afterThrowing target >> arg1:" + arg1 + ";arg2:" + arg2);
        System.out.println(ex.getMessage());
        return "afterThrowing rs";
    }
    
    // 无论连接点退出的方式如何（正常或特殊返回），都将执行
    @After(POINTCUT_NAME)
    Object afterExecute(JoinPoint joinPoint, String arg1, Integer arg2) {
        System.out.println("after target >> arg1:" + arg1 + ";arg2:" + arg2);
        return "after rs";
    }
    
    /**
     * 情况一
     * before target >> arg1:mockAlgEx;arg2:1
     *
     * enter controller >>> arg1:mockAlgEx;arg2:1
     * -----
     *
     * afterThrowing target >> arg1:mockAlgEx;arg2:1
     * / by zero
     *
     *
     * after target >> arg1:mockAlgEx;arg2:1
     *
     * 情况二
     * before target >> arg1:mockThrowEx;arg2:1
     *
     * enter controller >>> arg1:mockThrowEx;arg2:1
     * ------
     * afterReturn target >> arg1:mockThrowEx;arg2:1;retValrequest ok!!
     *
     * after target >> arg1:mockThrowEx;arg2:1
     *
     * java.lang.Exception: mock throw exception ok
     *
     * 情况三
     * before target >> arg1:beforeEx1;arg2:1
     * 2022-09-06 19:30:33.386 ERROR 17492 --- [nio-8081-exec-1] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is java.lang.reflect.UndeclaredThrowableException] with root cause
     *
     * java.lang.Exception: BEFORE_EX1
     *
     * 情况四
     * before target >> arg1:beforeEx2;arg2:1
     * enter controller >>> arg1:beforeEx2;arg2:1
     * afterReturn target >> arg1:beforeEx2;arg2:1;retValrequest ok!!
     * after target >> arg1:beforeEx2;arg2:1
     * java.lang.Exception: BEFORE_EX2
     *
     */
}
