package com.lyf.design.designmodel.proxy.test;

/**
 * @AUTHOR LYF
 * @DATE 2022/6/7
 * @VERSION 1.0
 * @DESC
 */
public class ProxyObject implements Service{
    @Override
    public void call() {
        System.out.println("proxyObject exec....");
    }
}
