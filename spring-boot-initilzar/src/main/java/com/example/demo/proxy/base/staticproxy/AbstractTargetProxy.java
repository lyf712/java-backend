package com.example.demo.proxy.base.staticproxy;

/**
 * @author liyunfei
 */
public abstract class AbstractTargetProxy implements ProxyTarget{
    ProxyTarget proxyTarget;
    
    public AbstractTargetProxy(ProxyTarget proxyTarget) {
        this.proxyTarget = proxyTarget;
    }
    
    public void setProxyTarget(ProxyTarget proxyTarget) {
        this.proxyTarget = proxyTarget;
    }
}
