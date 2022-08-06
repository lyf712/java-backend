package com.lyf.design.designmodel.proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @AUTHOR LYF
 * @DATE 2022/6/7
 * @VERSION 1.0
 * @DESC
 */
public class LogProxy extends ObjectProxy{

    public LogProxy(Object object) {
        super(object);
    }

    @Override
    void proxyMethod() {
//        System.out.println("start log...");

        Class clazz = object.getClass();
        // .... proxy what method? --- give name--
        Arrays.stream(clazz.getDeclaredMethods()).forEach(e->{
//            try {
//                e.invoke(object);
//            } catch (IllegalAccessException illegalAccessException) {
//                illegalAccessException.printStackTrace();
//            } catch (InvocationTargetException invocationTargetException) {
//                invocationTargetException.printStackTrace();
//            }
            //e.getParameters()
            logHandler(e,object);
        });
//        System.out.println("stop log...");
    }

    void logHandler(Method method, Object o){
        // --
        System.out.println("start log...");
        try {
            method.invoke(o);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("stop log...");
    }


}
