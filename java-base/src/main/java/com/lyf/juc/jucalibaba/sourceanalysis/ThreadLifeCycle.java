package com.lyf.juc.jucalibaba.sourceanalysis;

import org.junit.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * 测试线程的生命周期
 * 1.线程的状态及转换过程
 * 2.
 * @author liyunfei
 */
public class ThreadLifeCycle {
    private Object object = new Object();
    
    /**
     * 理解join,wait\notify,sleep,susppend,以及LockSupport的使用
     */
    @Test
    public void testJoinAndWait(){
        // 1.创建线程，分配对象-堆及资源，未就绪状态；
        // Thread的关注点：（1）doamon，ThreadGroup（null则为parent -  currentThread的--）
        // ，(2)ThreadLocalMap(3)系列的native方法
        // 思考JDK是如何进行管理、命令这些线程的，然后再思考如何去协作、共同工作（结合OS提供的资源（CPU、内存等）
        Thread t1 = new Thread(()-> {
            try {
                // 引起当前线程睡眠
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 work");
        }
        );  // NEW State
        // 2.start启动,进入就绪状态，等待分配CPU → 执行态（未定，顺序也未定）
        t1.start();// RUNNING State
        //Thread.State.
        try {
            // join() -- join(0)
            // 思考点：（1）加锁sychronized 为什么需要去抢锁、同步 (2)抛中断异常
            // while(isAlive) wait(0) -- wait native方法（Causes the current thread to wait until it is awakened）
            // isAlive说明正在执行还未died，死亡当该进程死亡及run任务结束后停止
            t1.join();// 3. WAITING; 区别WAITING（主动的？通知等待）和BLOCKED(抢锁、等待其他线程释放锁)的区别
            // t1.join(10);
            
           // t1.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("join end!");
        
        // 此时t1死亡介绍，再来wait:IllegalMonitorStateException: current thread is not owner --
        // 优先有Notify 否则会一直wait
        // t1.start();// 重新开启：IllegalThreadStateException 线程是一次活动轨迹无法反复开启
        t1 = new Thread(()->{
            try {
                // 引起当前线程睡眠
                //TimeUnit.SECONDS.sleep(1);
                //this.wait();
                //synchronized (object){
                    object.wait(); // 需要进行加锁，否则 可能同时进入
                //}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait end");
            System.out.println("t1 work again");
        });// 再次创建
 
       
        t1.start();
//        try {
//            t1.wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Thread finalT = t1;
        Thread t2 = new Thread(()->{
            System.out.println("t2 exec");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //synchronized (object){
                object.notify();
            //}
            //finalT.notify();//Wakes up a single thread that is waiting on this object' monitor.
            System.out.println("t2 exec end");
        });
        t2.start();
    
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
    }
    
    
    
}
