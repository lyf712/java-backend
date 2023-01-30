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
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author liyunfei
 **/
public class LockTest {
    AtomicInteger integer = new AtomicInteger();
    AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1,0);
    LongAdder longAdder = new LongAdder();
    @Test
    public void test(){
       // ClassLayout.parseClass().toPrintable();
        System.out.println(ClassLayout.parseClass(LockTest.class).toPrintable());
        //longAdder.sum();
    }
    // 锁升级：无 状态->偏向锁->轻量级锁->重量锁
    @Test
    public void testSynchronizedOpt(){

    }
}
