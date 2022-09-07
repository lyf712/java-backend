package com.example.demo.proxy.base.staticproxy;

import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 */
public class ProxyTargetA implements ProxyTarget {
    
    @Override
    public void work() {
        try {
            System.out.println("workerA working...");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
