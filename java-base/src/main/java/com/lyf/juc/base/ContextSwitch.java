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

/**
 * @authorliyunfei
 * @date2022/11/7
 **/
public class ContextSwitch {

    private final int count0 = 100*10000;
    private final int count1 = 10000;


    @Test
    public void test() throws InterruptedException {
        System.out.println(serial(count1));
        System.out.println(concurrency(count1));
    }
    long serial(int size){
        long start = System.currentTimeMillis();
        int a=0;
        for(int i=0;i<size;i++){a++;a+=5;}
        int b=0;
        for(int i=0;i<size;i++){b--;b+=5;}
        long end = System.currentTimeMillis();
        return end-start;
    }
    long concurrency(int size) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(()->{

        });
        thread.start();
        int b=0;
        for(int i=0;i<size;i++){b--;b+=5;}
        thread.join();
        long end = System.currentTimeMillis();
        return end-start;
    }
}
