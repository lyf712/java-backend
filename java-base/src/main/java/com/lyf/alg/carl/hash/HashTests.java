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

package com.lyf.alg.carl.hash;

import org.junit.Test;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @authorliyunfei
 * @date2022/12/6
 **/
public class HashTests {
       @Test
       public void testHashSet(){
              HashSet<Integer> hashSet = new HashSet<>();
              Integer[]tmp = new Integer[hashSet.size()];
              //Integer[] cannot be converted to int[]
              tmp =(Integer[]) hashSet.toArray();
              //Arrays.cop
           //hashSet.forEach();
           hashSet.forEach(u->{});

           int [] rs = new int[hashSet.size()];
           AtomicInteger index= new AtomicInteger();
           hashSet.forEach(val->{rs[index.getAndIncrement()]=val;});
       }
}
