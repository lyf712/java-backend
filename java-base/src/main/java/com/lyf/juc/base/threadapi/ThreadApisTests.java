package com.lyf.juc.base.threadapi;

import org.junit.Test;

import java.util.Random;

/**
 * @author liyunfei
 */
class MyThread implements Runnable {
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getThreadGroup().getName() +
                        "::" + Thread.currentThread().getName() + "::执行");
        try {
            Thread.sleep(new Random().nextInt(4));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadApisTests {
    final String TEST_GROUP1 = "mythread.test.group1";
    @Test
    public void testJvmToolCheck(){
        ThreadGroup threadGroup1 = new ThreadGroup(TEST_GROUP1);
        for(int i=0;i<5;i++)
           new Thread(threadGroup1,new MyThread(),"thread-"+i).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
