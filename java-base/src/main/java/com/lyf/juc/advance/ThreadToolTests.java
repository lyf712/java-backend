package com.lyf.juc.advance;

import com.lyf.juc.threadpool.NameThreadFactory;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池：
 * 池化思想：享元设计模式，线程池，连接池
 *
 * @author liyunfei
 */
public class ThreadToolTests {

    // 创建线程池的工具类：Executors
    // Executor,Executors,ExecutorService,ThreadPoolExecutor
    @Test
    public void testExecutors(){
        // Executor executor = new ThreadPoolExecutor();
        //new ThreadPoolExecutor(2,5,1000, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>())
        
        new ThreadPoolExecutor(2,9,1000,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(5),Executors.defaultThreadFactory());
    }
    
}
