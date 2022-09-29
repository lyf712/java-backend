package com.lyf.juc.threadpool.demo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 */
public class TestExecutor {
    
    // 定义线程池
    // 阻塞队列若不设置，则无限大
    private final static Executor executor = new ThreadPoolExecutor(ExecutorConfig.TEST_EXECUTOR_CORE_SIZE,ExecutorConfig.TEST_EXECUTOR_MAX_SIZE,1000L,
            TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(ExecutorConfig.TEST_EXECUTOR_QUEUE_SIZE),new DefaultThreadFactory(ExecutorConfig.DEFAULT_THREAD_FACTORY_NAME),
            new ThreadPoolExecutor.DiscardOldestPolicy());
    // 定义延时线程池
    private final static Executor scheduleExecutor = new ScheduledThreadPoolExecutor(ExecutorConfig.TEST_EXECUTOR_CORE_SIZE,
            new DefaultThreadFactory(ExecutorConfig.DEFAULT_THREAD_FACTORY_NAME));
    
    public static Executor getExecutor(){
           return executor;
    }
    
    public static Executor getScheduleExecutor(){
           return scheduleExecutor;
    }
}
