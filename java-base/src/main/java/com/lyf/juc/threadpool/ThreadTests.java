package com.lyf.juc.threadpool;

import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 */
public class ThreadTests {
    
    private final static String NOTIFY_GROUP_NAME = "hxink.notify.group";
    
    public static void main(String[] args) {
        
        ThreadGroup group = new ThreadGroup(NOTIFY_GROUP_NAME);
        
        for (int i=0;i<10;i++){
            new Thread(group,
                    ()-> {
                        ThreadGroup groupCur = Thread.currentThread().getThreadGroup();
                        System.out.println(groupCur.getName()+groupCur.activeCount()
                                +":"+Thread.currentThread().getName()+":execute");
                        try {
                            TimeUnit.MILLISECONDS.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    },"thread-"+i)
                    .start();
        }
        
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
