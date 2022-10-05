package com.lyf.alg.leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liyunfei
 */
class Foo {
    //private int[] singal ={1,0,0};
    private final ReentrantLock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    Semaphore semaphore = new Semaphore(0);
    Lock lock2 = new ReentrantLock();
    public Foo() {
//        lock.lock();
//        System.out.println("init success");
//        condition1.signal();
//        lock.unlock();
    }
    
    public void first(Runnable printFirst) throws InterruptedException {
        //while(singal[0]!=1);// 阻塞
//        System.out.println("enter");
        //semaphore.acquire();
        lock.lock();
//        System.out.println("fisrt success");
//        //condition1.await();
//        System.out.println("fisrt print");
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        condition2.signal();
        lock.unlock();
        //singal[0]=0;
        //singal[1]=1;
    }
    
    public void second(Runnable printSecond) throws InterruptedException {
        //while(singal[1]!=1);// 阻塞
        lock.lock();
        condition2.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        condition3.signal();
        lock.unlock();
        //  singal[1]=0;
        // singal[2]=1;
    }
    
    public void third(Runnable printThird) throws InterruptedException {
        //while(singal[2]!=1);
        lock.lock();
        condition3.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        lock.unlock();
        //condition1.signal();
        //singal[2]=0;
        //singal[0]=1;
    }
}
public class LC1114 {
    
    public static void main(String[] args) {
        Foo foo = new Foo();
        new Thread(()->{
            try {
                foo.first(()-> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        new Thread(()->{
            try {
                foo.first(()-> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
        new Thread(()->{
            try {
                foo.first(()-> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"C").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
