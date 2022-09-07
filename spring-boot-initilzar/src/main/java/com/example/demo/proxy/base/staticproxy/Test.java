package com.example.demo.proxy.base.staticproxy;

/**
 * @author liyunfei
 */
public class Test {
    
    public static void main(String[] args) {
        ProxyTarget proxyTarget = new TimeLogTargetProxy(new ProxyTargetA());//.work();
        proxyTarget.work();
    }
}
