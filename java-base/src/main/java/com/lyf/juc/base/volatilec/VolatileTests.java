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

package com.lyf.juc.base.volatilec;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liyunfei
 **/
public class VolatileTests {
    private static class CounterTask{
        private volatile int cnt1;

        private volatile int cnt2;

        private volatile boolean shutdown;

        private AtomicInteger atomicInteger = new AtomicInteger(0);

        public CounterTask(int cnt1, int cnt2) {
            this.cnt1 = cnt1;
            this.cnt2 = cnt2;
        }

        void add1(){
            cnt1 ++;
        }
        void add2(){
            cnt2 = (cnt2+1);
        }

        void add3(){
            atomicInteger.getAndIncrement();
        }
        public int getCnt1() {
            return cnt1;
        }

        public int getCnt2() {
            return cnt2;
        }

        public int getCnt3(){
           return atomicInteger.get();
        }
    }

    /**
     * 测试可见性.
     */
    @Test
    public void test(){
        CounterTask task = new CounterTask(0,0);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for(int i=0;i<10;i++){
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    task.add1();
                    task.add2();
                    task.add3();
                }
                countDownLatch.countDown();
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        try {
//            TimeUnit.SECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println(task.getCnt1());
        System.out.println(task.getCnt2());
        System.out.println(task.getCnt3());

    }
}
