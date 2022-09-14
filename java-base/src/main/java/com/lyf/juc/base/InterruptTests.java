package com.lyf.juc.base;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * static boolean interrupted()
 * void interrupt()
 * boolean isInterrupted()
 *
 * @author liyunfei
 */
class TestSingleTask implements Runnable{
    
    @Override
    public void run() {
        for (;;){
            System.out.println("isInterrupted::"+Thread.currentThread().isInterrupted());
            if(Thread.currentThread().isInterrupted()){
                System.out.println("stop execute");// ??
                break;
            }
            System.out.println(new Date()+"::"+Thread.currentThread().getName()+"execute task..");
            
            
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                System.out.println("interruptedE stop execute");
//                break;
//            }
        }
    }
}
public class InterruptTests {
    @Test
    public void testInterrupt1(){
//        Thread thread = new Thread();
//        thread.interrupt();
//        thread.isInterrupted();
//        Thread.interrupted();
          Thread thread1 = new Thread(new TestSingleTask(),"thread-1");
          Thread thread2 = new Thread(new TestSingleTask(),"thread-2");
          thread1.start();
          thread2.start();
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("interrupt thread-1");
            thread1.interrupt();
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    // 若run中无TimeUnit.sleep ，不存在睡眠状态---中断异常的情况
    @Test
    public void testInterrupt2(){
        Thread thread1 = new Thread(new TestSingleTask(),"thread-1");
        Thread thread2 = new Thread(new TestSingleTask(),"thread-2");
        thread1.start();
        thread2.start();
        thread1.interrupt();
        thread2.interrupt();
        // test-2
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
