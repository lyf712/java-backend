package com.lyf.juc.advance;

import org.junit.Test;

import java.sql.Time;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列
 * 重点关注 put,take 和 add,remove几个API的对比
 *
 * @author liyunfei
 */
public class BlockingQueueTests {
    @Test
    public void testApi(){
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(2);
        blockingQueue.add(1);
        blockingQueue.add(2);
        new Thread(()->{
            // 等待主线程去执行放操作后在取走
            System.out.println(blockingQueue);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("取走一个");
            blockingQueue.remove();
        }).start();
        // full
        // blockingQueue.add(3); //java.lang.IllegalStateException: Queue full
        
        
        
        
        try {

            blockingQueue.put(3);// 阻塞该线程在这儿，放中断异常，
            System.out.println(blockingQueue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // 需要单开线程--
//        System.out.println("消费---queue");
//        blockingQueue.remove();
    
    }
    
    /**
     * 简单案例
     */
    
    
    private static class Log{
        private long recordTs;
        private String content;
    
        public Log(long recordTs, String content) {
            this.recordTs = recordTs;
            this.content = content;
        }
    }
    
    private static class LogService{
        //private Log log;
        void printLog(Log log){
            System.out.println(Thread.currentThread().getName()+"-service work and print log::"+log);
        }
    }
    
    @Test
    public void testBlockingQ(){
      
        final int capacity = 10;
        final int workerCount = 4;
        final LogService logService = new LogService();
        BlockingQueue<Log> blockingQueue = new ArrayBlockingQueue<>(10);
        for (int i=0;i<workerCount;i++){
            new Thread(()->{
                for (;;){
//                    System.out.println(Thread.currentThread().getName()+"::print log");
                    try {
                        logService.printLog(blockingQueue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"thread-"+i).start();
        }
        for (;;){
            try {
                blockingQueue.put(new Log(System.currentTimeMillis(),"content-"+new Random().nextInt(1000)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
