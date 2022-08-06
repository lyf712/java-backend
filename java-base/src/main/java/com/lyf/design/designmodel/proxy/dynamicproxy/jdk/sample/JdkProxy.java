package com.lyf.design.designmodel.proxy.dynamicproxy.jdk.sample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @AUTHOR LYF
 * @DATE 2022/6/7
 * @VERSION 1.0
 * @DESC
 */
public class JdkProxy {
    Object proxyObject;
    Object proxyTarget;

    public JdkProxy(Object proxyObject, Object proxyTarget) {
        this.proxyObject = proxyObject;
        this.proxyTarget = proxyTarget;
    }

    void exec(){

    }

    public static void main(String[] args) {
        Tank tank = new Tank();
        //tank.move();

        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");

        Movable movable = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("proxy..start");
                Object o = method.invoke(tank,args);
                System.out.println("proxy..stop");
                return o;
            }
        });
        movable.move();
    }
}
