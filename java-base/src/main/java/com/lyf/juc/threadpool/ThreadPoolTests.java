package com.lyf.juc.threadpool;

import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author liyunfei
 */
class SelfFactory implements ThreadFactory{
    
    private final ThreadGroup group = new ThreadGroup(SystemConfig.SELF_THREAD_FACTORY);
    
    private AtomicLong threadId = new AtomicLong(0);
    
//    private String name;
    
//    private Thread thread;
    
//    public SelfFactory(String name) {
//        this.name = name;
//    }
    
    @Override
    public Thread newThread(Runnable r) {
        //r.run();
        Long id = threadId.getAndIncrement();
        Thread newThread = new Thread(group,r,SystemConfig.SELF_THREAD_NAME_PREFIX+id);
        return newThread;
    }
}

public class ThreadPoolTests {
    // 新线程 → 核心数执行 → 等待队列 → 最大数 → 等待队列 → 核心；
    private final int coreSize = 2;
    private final int maxSize = 9;
    // 工作队列-等待队列
    private final BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(5);
    private ThreadFactory threadFactory; //= new SelfFactory()
    
    @Test
    public void testSelfExecutors(){
        Executor executor = new ThreadPoolExecutor(coreSize,maxSize,
                1000L, TimeUnit.MILLISECONDS,workQueue,new SelfFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
        
        // 调整threadNum ,mock concurrent num
        final int threadNum = 4;
        for (int i=0;i<threadNum;i++){
            final long finalI = i;
            executor.execute(()-> System.out.println(Thread.currentThread().getName()+"execute-"+finalI));
        }
       
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
