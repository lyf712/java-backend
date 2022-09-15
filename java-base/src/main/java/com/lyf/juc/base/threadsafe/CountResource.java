package com.lyf.juc.base.threadsafe;

import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 */
public class CountResource {
    private int count = 0;
    void add(){
        try {
            // mock -- 思考为啥此处很快的话，就会正常-- 若此处长，就会存在多个进程同时进来
            TimeUnit.MILLISECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }
    void printCount(){
        System.out.println(count);
    }
}
