package com.lyf.design.designmodel.proxy.dynamicproxy.jdk;

/**
 * @AUTHOR LYF
 * @DATE 2022/6/7
 * @VERSION 1.0
 * @DESC
 */
public abstract class ObjectProxy {
    Object object;
    public ObjectProxy(Object object) {
        this.object = object;
    }
    abstract void proxyMethod();
}
