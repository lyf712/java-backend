package com.lyf.juc.base;

import org.junit.Test;

import java.util.Arrays;

/**
 * CPU核心数等概念
 *
 * @author liyunfei
 */
public class CpuCoresTests {
    
    @Test
    public void testCpuCores() {
        //System.getProperty("system.cpus");
        //Runtime.getRuntime().
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors() + "::" +
                runtime.maxMemory() +"::" +runtime.freeMemory() + "::"+runtime.totalMemory());
    }
    
    // 采用WPS进行画图-理解--熟悉掌握
    @Test
    public void testThreadStatus(){
        System.out.println(Arrays.stream(Thread.State.values()).toList());// [NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED]
//        Object.class.notify();
//        Object.class.notifyAll();
//        Object.class.wait();
//        Object o = new Object();
//        Thread thread = new Thread();
//        thread.join();
//        thread.interrupt();
//        thread.start();
//        thread.isInterrupted();
    }
    
    // 线程的实现方式：
    
    private static class MyThreadByExtend1 extends Thread{
    
        @Override
        public void run() {
            System.out.println("执行MyThread1 Function");
            //super.run();
        }
    }
    
    private static class MyThreadByRunnable1 implements Runnable{
    
        @Override
        public void run() {
            System.out.println("执行MyThreadByRunnable1 Function");
        }
    }
    
    private static class MyThreadByRunnable2 implements Runnable{
        
        @Override
        public void run() {
            System.out.println("执行MyThreadByRunnable2 Function");
        }
    }
    
    private static class MyThreadByRunnable3 implements MyRunnable1{
        
        @Override
        public void run() {
            System.out.println("执行MyThreadByRunnable2 Function");
        }
    }
    
    interface MyRunnable1 extends Runnable{
    
        @Override
        default void run() {
        
        }
    }
    
    
}
