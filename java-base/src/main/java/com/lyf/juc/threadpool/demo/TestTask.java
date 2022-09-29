package com.lyf.juc.threadpool.demo;

/**
 * @author liyunfei
 */
public class TestTask implements Runnable{
    
//    private String taskName;
//
//    public TestTask(String taskName) {
//        this.taskName = taskName;
//    }
    
    @Override
    public void run() {
        System.out.println("hello , i am "+Thread.currentThread().getName());
    }
}
