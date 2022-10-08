package com.lyf.alg.leetcode.concurrent;

import org.junit.Test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://leetcode.cn/problems/print-foobar-alternately/submissions/
 * 1、查看分析Semphore的实现机制.
 * 2、理解熟悉fair、permits
 * Condition的使用？结合指示变量？
 * @author liyunfei
 */
class Foo1115 {
    
    private int n;
    
    private Semaphore s1 = new Semaphore(1);
    
    private Semaphore s2 = new Semaphore(1);
    
    public Foo1115(int n) {
        this.n = n;
    }
    
    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            s1.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            s2.release();
        }
    }
    
    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            //s.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
        }
    }
}

public class LC1115 {
    
    @Test
    public void testSemaphore() {
        //Sync -AQS;permits初始许可证数量
        Semaphore semaphore1 = new Semaphore(1, true);
        Semaphore semaphore2 = new Semaphore(0, true);
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphore1.acquire();
                    System.out.println("foo");
                    semaphore2.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                //semaphore.release();
            }
        }).start();
        
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphore2.acquire();
                    System.out.println("bar");
                    semaphore1.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testLock(){
        Lock lock = new ReentrantLock();
        //Lock lock2 = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        
        new Thread(() -> {
            
            for (int i = 0; i < 10; i++) {
                lock.lock();
                //c1.signal();
                try {
                    //semaphore1.acquire();
                    //c1.await();
                    System.out.println("foo");
                    //semaphore2.release();
                } finally {
                    lock.unlock();
                    c2.signal();
                }
                //semaphore.release();
            }
        }).start();
    
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    c2.await();
                    //semaphore2.acquire();
                    System.out.println("bar");
                    //semaphore1.release();
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    //c1.signal();
                }
            
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    // lock是锁住某个资源，结合资源控制变量进行控制使用
    // 思考：原子类和lock+变量的区别
    volatile boolean isPermit = true;
    final Lock lock = new ReentrantLock(true);
    Condition condition = lock.newCondition();
    final int n = 10;
    volatile AtomicInteger integer = new AtomicInteger(0);
    @Test
    public void testFairLock(){
        
        new Thread(()->{
            for(int i=0;i<n;){
                lock.lock();
                try {
                    //System.out.println("foo-print-"+i);
                    if(isPermit){
                        System.out.println("foo");
                        i++;
                        isPermit = false;
                    }
                }finally {
                    lock.unlock();
                }
            }
        }).start();
        new Thread(()->{
            for(int i=0;i<n;i++){
                lock.lock();
                try {
                    //System.out.println("bar-print-"+i);
                    if(!isPermit){
                        System.out.println("bar");
                        i++;
                        isPermit = true;
                    }
                }finally {
                    lock.unlock();
                }
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testAtomic() {//Condition
        //System.out.println(integer.getAndIncrement());
        new Thread(()->{
            for(int i=0;i<n;i++){
                //System.out.println("foo:"+integer.get());
                //while (integer.getAndIncrement()%2!=0);
                lock.lock();
                if(!isPermit) {// 不允许则等待
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("foo");
                isPermit = false;
                condition.signal();
                lock.unlock();
            }
        }).start();
        new Thread(()->{
            for(int i=0;i<n;i++){
                //System.out.println("bar:"+integer.get());
                //while (integer.getAndIncrement()%2==0);
                lock.lock();
                if(isPermit) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("bar");
                isPermit = true;
                condition.signal();
                lock.unlock();
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
