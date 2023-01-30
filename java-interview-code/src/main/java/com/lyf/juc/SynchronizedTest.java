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

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 **/
public class SynchronizedTest {
    final int nThread = 10;
    // 对比CAS和synchronized的时间消耗
    @Test
    public void test() throws InterruptedException {
        Counter counter = new Counter(Counter.AddType.ATOMIC);
        CountDownLatch countDownLatch = new CountDownLatch(nThread);
        long start = System.currentTimeMillis();
        for(int i=0;i<nThread;i++)
        new Thread(()->{
            for (int j = 0; j < 10000; j++) {
                counter.add();
            }
            countDownLatch.countDown();
        }).start();
        //TimeUnit.SECONDS.sleep(1);
        countDownLatch.await();

        System.out.println(counter.get()+"::"+(System.currentTimeMillis() - start));
    }
}
