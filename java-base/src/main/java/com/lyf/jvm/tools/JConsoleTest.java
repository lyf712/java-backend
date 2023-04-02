/*
 *    Copyright 1999-2022  lyf712
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.lyf.jvm.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 **/
public class JConsoleTest {
    static final int num = 1000;
    private static class PlaceObject{
        byte[] placeHolder = new byte[1024*64];
    }
    static void fillHeap() throws Exception{
        List<PlaceObject> list = new ArrayList<>();
        for(int i=0;i<num;i++){
            Thread.sleep(50);
            list.add(new PlaceObject());
        }
        System.gc();
    }
    static void lockThread() throws InterruptedException {
        new Thread(()->{
            // 空耗资源，死循环
            while (true){}
        },"testBuyThread").start();
        final Object lock = new Object();
        new Thread(()->{
            synchronized (lock){
                try {
                    // 等待被唤醒
                    System.out.println("waiting");
                    lock.wait();
                    System.out.println("notify");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"testLockThread").start();
        Thread.sleep(1000*10);
        synchronized (lock){
            lock.notify();
        }
    }
    static class Task implements Runnable{
        private Integer lock1,lock2;

        public Task(Integer lock1, Integer lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        @Override
        public void run() {
            synchronized (lock1){
                synchronized (lock2){
                    System.out.println("ok");
                }
            }
        }
    }
    static void deadLock(){
        for (int i=0;i<200;i++){
            new Thread(new Task(Integer.valueOf(1),Integer.valueOf(2))).start();
            new Thread(new Task(Integer.valueOf(2),Integer.valueOf(1))).start();
        }
    }
    public static void main(String[] args) throws Exception {
        //fillHeap();
        //System.gc();
        //lockThread();
        TimeUnit.SECONDS.sleep(10);
        deadLock();
    }
}
