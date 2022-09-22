package com.lyf.juc.threadpool;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Fork,Join框架 异步框架
 * Jdk1.8后出现CompleteFuture
 * @author liyunfei
 */
public class FutureTests {
    @Test
    public void testFuture(){
        Callable callable = () -> "call!ok";
        Future futureTask = new FutureTask(callable);
        
//        while (futureTask.isDone()){
//            try {
//                System.out.println(futureTask.get());
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
//        Future completedFuture = new CompletableFuture();
        System.out.println(System.currentTimeMillis()+"start");
        Executor executor = CompletableFuture.delayedExecutor(3, TimeUnit.SECONDS);
        executor.execute(()->{
            System.out.println(System.currentTimeMillis()+"execute");
        });
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ScheduledExecutorService executor1 = new ScheduledThreadPoolExecutor(2);
        //executor1.schedule()
    }
}
