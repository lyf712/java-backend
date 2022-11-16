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

package com.lyf.juc.base;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.StampedLock;

/**
 * @authorliyunfei
 * @date2022/11/16
 **/
class Resource{
      private int count=0;
      //read
      int getCount(){return count;}
      //write
      void addCount(){count++;}
}
public class StampedLockTests {
    @Test
    public void test() throws InterruptedException {
        Resource resource = new Resource();
        StampedLock stampedLock = new StampedLock();
        Lock readLock = stampedLock.asReadLock();
        Lock writeLock = stampedLock.asWriteLock();

        // 模拟写操作（有写则不能读，有读则写退出，写不能同时写，读可同时读）
        for(int i=0;i<10;i++){
            new Thread(()->{
                String curThreadName = Thread.currentThread().getName();
                try {
                    writeLock.lock();
                    System.out.println(curThreadName+"get write lock");
                    System.out.println("write data");
                    resource.addCount();
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    writeLock.unlock();
                }
            },"writer-"+i).start();
        }

        for(int i=0;i<10;i++){
            new Thread(()->{
                while (true){
                    // 一直读
                    String curThreadName = Thread.currentThread().getName();
                    try {
                        readLock.lock();
                        System.out.println(curThreadName+"get read lock");
                        System.out.println("read data: count is"+resource.getCount());
                    }finally {
                        readLock.unlock();
                    }
                }
            },"reader-"+i).start();
        }

        TimeUnit.SECONDS.sleep(100);
    }
}
