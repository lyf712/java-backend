package com.lyf.design.designmodel.proxy.dynamicproxy.jdk;

import com.lyf.design.learn.designmodel.proxy.staticproxy.v2.Actionable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @AUTHOR LYF
 * @DATE 2022/6/7
 * @VERSION 1.0
 * @DESC
 */
//interface Movable{
//    void move();
//}
//class Tank implements Movable{
//
//    @Override
//    public void move() {
//
//    }
//}
public class Main {
    public static void main(String[] args) {
//        new LogProxy(new Tank()).proxyMethod();

        Tank tank =new Tank();
        //Proxy.newProxyInstance()
        Actionable a =(Actionable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Actionable.class}, new InvocationHandler() {
//            Object o;

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("hello,proxy");
                // proxy??
                Object o = method.invoke(tank,args);
                System.out.println("stop..");
                return o;
            }
        });
        a.move();

    }
}
