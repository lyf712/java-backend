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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @authorliyunfei
 * @date2022/11/11
 **/
public class StateTransferTests {
       List<Thread> threadList;
       @Test
       public void testTransfer() throws InterruptedException {
           threadList = new ArrayList<>();
           // NEW 创建
           for (int i=0;i<10;i++){
               int finalI = i;
               threadList.add(new Thread(()->{
                   if(finalI %2==0){
                       System.out.println("偶数线程进行LockSupport测试:parkNanos-2");
                       //LockSupport.parkNanos(2000); nanos
                       //LockSupport.parkNanos(Thread.currentThread(),4000);
                   }else if(finalI%3==0){
                        // not to do anything{
                           System.out.println("park:"+Thread.currentThread().getName());
                           LockSupport.park(Thread.currentThread());
                           System.out.println("unpark:"+Thread.currentThread().getName());
                   }
                   for (;;){
                       System.out.println(Thread.currentThread().getName()+
                               "::working::state::"+Thread.currentThread().getState().name());


//                       try {
//                           Thread.currentThread().wait(1000);
//                       } catch (InterruptedException e) {
//                           throw new RuntimeException(e);
//                       }

                       try {
                           // wait,
//                           do {
//                               wait(delay);
//                           } while (isAlive() && (delay = millis -
//                                   TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime)) > 0);
                           Thread.currentThread().join(1000);
                       } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                       }

                   }

               },"thread-"+i));
           }

           // START
           for (Thread thread:threadList){
               thread.start();
           }

           // LockSupport random
//           int i=0;
//           for(Thread thread:threadList){
//               if(i++%3==0){
//                   System.out.println("park:"+thread.getName());
//                   LockSupport.park(thread);
//                   System.out.println("unpark:"+thread.getName());
//               }
//           }

           // 主线程 wait / notify配合
           // Thread.currentThread().wait(10000);
           Thread.currentThread().join(5000);


           // TERMINAL
//           for (Thread thread:threadList){
//               thread.stop(); // 优雅的提出建议设置 boolean变量
//           }
       }


}
