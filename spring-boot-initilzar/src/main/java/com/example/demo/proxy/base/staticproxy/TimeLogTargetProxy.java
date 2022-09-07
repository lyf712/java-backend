package com.example.demo.proxy.base.staticproxy;

/**
 * @author liyunfei
 */
public class TimeLogTargetProxy extends AbstractTargetProxy {
    
    public TimeLogTargetProxy(ProxyTarget proxyTarget) {
        super(proxyTarget);
    }
    
    @Override
    public void work() {
        long var1 = System.currentTimeMillis();
        proxyTarget.work();
        long var2 = System.currentTimeMillis();
        System.out.println("time::" + (var2 - var1));
    }
}
