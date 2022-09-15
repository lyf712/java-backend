package com.lyf.juc.base.threadsafe;

import org.junit.Test;

import java.sql.Time;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 */
public class ThreadUnsafeTest {
    
    private final int nThread = 5;
    
    private CountDownLatch countDownLatch = new CountDownLatch(nThread);
    
    private class CountTask implements Runnable {
        
        private CountResource countResource;
        
        public CountTask(CountResource countResource) {
            this.countResource = countResource;
        }
        
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ":: operate");
            countResource.add();
            countDownLatch.countDown();
            //countResource.printCount();
        }
    }
    
    @Test
    public void testUnsafe() {
        CountResource countResource = new CountResource();
        for (int i = 0; i < nThread; i++) {
            new Thread(new CountTask(countResource), "thread-" + i).start();
        }
    
//        try {
//            TimeUnit.SECONDS.sleep(1);
//            countResource.printCount();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
        try {
            countDownLatch.await();
            // 原则上为10
            countResource.printCount();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
