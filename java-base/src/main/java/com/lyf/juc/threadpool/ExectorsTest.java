package com.lyf.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 */
public class ExectorsTest {
    
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newScheduledThreadPool(100, new NameThreadFactory("com.pool.test"));
        executorService.submit(() -> System.out.println(Thread.currentThread().getName() + ":: hello"));
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
