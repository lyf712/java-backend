package com.lyf.juc.util;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author liyunfei
 */
class Resource {
    
    private AtomicLong count = new AtomicLong(0);
    
    void add() {
        count.getAndIncrement();
    }
    
    void print() {
        System.out.println("num::" + count.get());
    }
}

public class MainUtil {
    
    // 信号量
    Semaphore semaphore = new Semaphore(3);
    
    //
    CountDownLatch countDownLatch = new CountDownLatch(8);
    
    //
    CyclicBarrier cyclicBarrier = new CyclicBarrier(8);
    
    @Test
    public void testCountDownLatchUtil() {
        Resource resource = new Resource();
        for (int i = 0; i < 10; i++) {
            new Thread(
                    ()->{
                        resource.add();
                        countDownLatch.countDown();
                    }
            ).start();
        }
        try {
            // 阻塞在这儿
            countDownLatch.await();
            resource.print();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testCyclicBarrierUtil(){
        try {
            
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testSemaphore(){
       // semaphore.
       
       
    }
}
