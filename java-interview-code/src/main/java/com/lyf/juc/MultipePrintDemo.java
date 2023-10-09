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

package com.lyf.juc;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liyunfei
 **/

public class MultipePrintDemo {

    // private static volatile ReentrantLock[] locks = new ReentrantLock[3];
    private static int printIndex = 0;

    private static int cnt = 1;

    private static final  ReentrantLock MAIN_LOCK = new ReentrantLock();

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(3, 5, 0L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });
        String[] name = new String[]{"A","B","C"};
        for(int i=0;i<3;i++){
            // executorService.submit(new PrintTask0(name[i],(i+1) % 3));

            executorService.submit(new PrintTask(name[i],i));
           // new Thread(new PrintTask(name[i], i)).start();
        }
    }


    // 通知指定的线程，如何实现

    private static final Object lock = new Object();
    private static int counter = 1;

    private static class PrintTask0 implements Runnable{

        private String name;

        private int index;

        public PrintTask0(String name, int index) {
            this.name = name;
            this.index = index;
        }

        @Override
        public void run() {
               for(;;){
                   // 严格控制争抢，争抢失败则会阻塞
                   synchronized (lock){

                       if(counter % 3 == index ){
                           System.out.println(name + "" + counter);
                           if(counter>=1000){
                               break;
                           }
                           counter++;
                           lock.notifyAll();
                       }else{
                           try {
                               // 释放锁，阻塞，等待其他线程唤醒，来竞争锁
                               lock.wait();
                           } catch (InterruptedException e) {
                               throw new RuntimeException(e);
                           }
                       }
                   }
               }

        }
    }

    private static class PrintTask implements Runnable{

        private String name;

        // 指针放在何处，怎么用思考 ,0,1,2
        private volatile int index;

        public PrintTask(String name, int index) {
            this.name = name;
            this.index = index;
        }

        @Override
        public void run() {
            // 三个并发抢，而非协作 通知唤醒模式（考虑
            for (;;){
                MAIN_LOCK.lock();
                try {
                    if(index == printIndex){
                        System.out.println(name + cnt);
                        if(cnt>=1000){
                            break;
                        }

                        cnt++;
                        printIndex = (printIndex+1) % 3;
                    }
                }finally {
                    MAIN_LOCK.unlock();
                }
            }
        }

    }
}
