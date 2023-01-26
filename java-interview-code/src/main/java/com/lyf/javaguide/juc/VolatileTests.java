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

package com.lyf.javaguide.juc;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://github.com/openjdk-mirror
 * 
 * @author liyunfei
 **/
public class VolatileTests {
    volatile int  count = 1;
    // 可见性和原子性保证
    @Test
    public void test(){

           ExecutorService executorService = Executors.newFixedThreadPool(5);
           executorService.execute(()->{

           });
           // 可见性保证
           executorService.shutdown();
    }

    //保证原子性 synchronized,lock,atomic
    @Test
    public void testSource(){
        //synchronied--jvm关键字

        //Sync extends AbstractQueuedSynchronizer
        /**
         * AQS
         *
         */
        Lock lock = new ReentrantLock();
        //LockSupport.park();
        //Unsafe:
        /**
         * cas
         int v;
         do {
         v = getIntVolatile(o, offset);
         } while (!weakCompareAndSetInt(o, offset, v, newValue));
         */
        new AtomicInteger();

    }


}
