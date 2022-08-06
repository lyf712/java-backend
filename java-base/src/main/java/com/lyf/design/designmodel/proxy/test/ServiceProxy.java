package com.lyf.design.designmodel.proxy.test;

/**
 * @AUTHOR LYF
 * @DATE 2022/6/7
 * @VERSION 1.0
 * @DESC
 */
public class ServiceProxy implements Service{
    private ProxyObject proxyObject=new ProxyObject();
    @Override
    public void call() {
        // --handle
        proxyObject.call();
    }
}
