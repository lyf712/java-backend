package com.lyf.design.designmodel.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @AUTHOR LYF
 * @DATE 2022/6/7
 * @VERSION 1.0
 * @DESC
 */
class Hello{
    void say(){
        System.out.println("hello");
    }
}

class SayMethodInterceptor implements MethodInterceptor{
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before...");
        Object rs = methodProxy.invokeSuper(o,objects);
        System.out.println("after...");
        return rs;
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Hello.class);
        enhancer.setCallback(new SayMethodInterceptor());
        Hello hello = (Hello)enhancer.create();
        hello.say();
    }
}
