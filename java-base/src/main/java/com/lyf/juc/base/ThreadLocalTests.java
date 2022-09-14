package com.lyf.juc.base;

/**
 * @author liyunfei
 */

public class ThreadLocalTests {
    
    private static ThreadLocal<Integer> retry = ThreadLocal.withInitial(() -> 0);
    
    static class Task1 implements Runnable{
        private int var1=1;
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"::"+var1++);
            System.out.println(retry.get());
            retry.set(retry.get()+1);
        }
    }
    
    public static void main(String[] args) {
        for(int i=0;i<10;i++)
            new Thread(new Task1(),"thread-"+i).start();
    }
}
