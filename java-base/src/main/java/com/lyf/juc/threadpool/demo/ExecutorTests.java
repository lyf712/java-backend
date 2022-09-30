package com.lyf.juc.threadpool.demo;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 */
public class ExecutorTests {

    @Test
    public void test(){
        final int taskNum = 100;
        Executor executor =  TestExecutor.getExecutor();
        for(int i=0;i<taskNum;i++)
            executor.execute(new TestTask()); //"task-"+i
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
