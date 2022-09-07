package com.lyf.juc.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liyunfei
 */
public class NameThreadFactory implements ThreadFactory {
    
    private static final String DOT = ".";
    
    private String name;
    
    private volatile AtomicInteger index = new AtomicInteger(0);
    
    public NameThreadFactory(String name) {
        if (!name.startsWith(DOT)) {
            name = name + DOT;
        }
        this.name = name;
    }
    
    @Override
    public Thread newThread(Runnable r) {
        String threadName = name + index.getAndIncrement();
        //        r.run();
        //        return new Thread(name);
        Thread thread = new Thread(r, threadName);
        // thread.setDaemon(true);
        return thread;
    }
}
