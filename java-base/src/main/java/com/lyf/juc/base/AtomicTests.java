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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子性问题：lock&cas
 *
 * @authorliyunfei
 * @date2022/11/8
 **/
class Counter{
    private int i=0;
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    void addI(){i++;}
    void addAtomicI(){
         for(;;){
             int val = atomicInteger.get();
             boolean rs = atomicInteger.compareAndSet(val,++val);
             if(rs){
                 break;
             }
         }

    }

    public int getI() {
        return i;
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }
}
public class AtomicTests {
    @Test
    public void test() throws InterruptedException {
        final Counter counter = new Counter();
        List<Thread> threadList = new ArrayList<>(100);
        for(int i=0;i<100;i++){
            threadList.add(new Thread(()->{
                   for(int j=0;j<1000;j++){
                       counter.addI();
                       counter.addAtomicI();
                   }
            }));
        }
        for(Thread thread:threadList){
            thread.start();
        }

        for(Thread thread:threadList){
            thread.join();
        }

        System.out.println(counter.getI()+"::"+counter.getAtomicInteger().get());
    }

}
