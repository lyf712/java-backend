//package com.lyf.design.designmodel.proxy.dynamicproxy.cglib;
//
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//import org.junit.Test;
//
//import java.lang.reflect.Method;
//
///**
// * @AUTHOR LYF
// * @DATE 2022/6/7
// * @VERSION 1.0
// * @DESC
// */
//public class CglibProxyTests {
//
//    @Test
//    public void test1(){
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(Tank.class);
//        enhancer.setCallback(new MethodInterceptor() {
//            @Override
//            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                System.out.println("before..");
//                Object rs=methodProxy.invokeSuper(o,objects);
//                System.out.println("end...");
//                return rs;
//            }
//        });
//        Tank tank = (Tank) enhancer.create();
//        tank.move();
//    }
//
//}
