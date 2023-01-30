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

import java.lang.reflect.AnnotatedType;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author liyunfei
 **/
public class Counter {
    private int count = 0;
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(0,1);

    enum AddType{
           SYNC,
           ATOMIC,
           ATOMICREF
    }

    private AddType addType;

    public Counter(AddType addType) {
        this.addType = addType;
    }

    public void add(){//AddType addType
        switch (addType){
            case SYNC -> {
                synchronized (this){
                    count++;
                }
            }
            case ATOMIC -> {
                atomicInteger.getAndIncrement();
            }
            case ATOMICREF -> {
                //atomicStampedReference.set();
            }
        }
    }

    public int get(){
        switch (addType){
            case SYNC -> {
                return count;
            }
            case ATOMIC -> {
                //atomicInteger.getAndIncrement();
                return atomicInteger.get();
            }
            case ATOMICREF -> {
                //atomicStampedReference.set();
            }
        }
        return -1;
    }
}
