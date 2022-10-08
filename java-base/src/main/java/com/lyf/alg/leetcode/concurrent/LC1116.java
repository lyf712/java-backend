package com.lyf.alg.leetcode.concurrent;

import org.junit.Test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 综合lock+semaphore
 * 28%:效率较低，需要循环去抢锁，并判断是在范围之内
 * @author liyunfei
 */
class ZeroEvenOdd {
    // zero和 even / odd进行交替
    // even / odd 由 抢锁并判断决定
    Semaphore s1 = new Semaphore(1);
    Semaphore s2 = new Semaphore(0);
    Lock lock = new ReentrantLock(true);
    volatile int i = 1;
    
    private int n;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }
    
    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(i<=n){
            s1.acquire();
            //   if(i>n)
            //       break;
            if(i<=n)
                printNumber.accept(0);
            s2.release();
        }
    }
    
    public void even(IntConsumer printNumber) throws InterruptedException {
        
        while(i<=n){
            lock.lock();
            if(i<=n&&i%2==0){
                s2.acquire();
                printNumber.accept(i);
                i++;
                s1.release();
            }
            lock.unlock();
        }
        // lock.unlock();
    }
    
    public void odd(IntConsumer printNumber) throws InterruptedException {
        
        while(i<=n){
            lock.lock();
            if(i<=n&&i%2!=0){
                s2.acquire();
                printNumber.accept(i);
                i++;
                s1.release();
            }
            lock.unlock();
        }
        //  lock.unlock();
    }
}
public class LC1116 {
    @Test
    public void testZeroEvenOdd(){}
    
}
