package com.lyf.juc.threadpool.demo;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liyunfei
 */
public class DefaultThreadFactory implements ThreadFactory {
    
    private final String DOT = ".";
    
    private volatile AtomicInteger threadId = new AtomicInteger(0);
    
    private String name;
    
    public DefaultThreadFactory(String name) {
        if(!name.endsWith(DOT)){
            name = name + DOT;
        }
        this.name = name;
    }
    
    @Override
    public Thread newThread(Runnable r) {
        int id  = threadId.getAndIncrement();
        String threadName = name + id;
        Thread thread = new Thread(r,threadName);
        thread.setDaemon(true);// 守护线程，--可结合docker容器运用交互式、守式
        return thread;
    }
}
