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

package com.lyf.juc.util;

import org.junit.Test;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @authorliyunfei
 * @date2022/11/14
 **/
public class ExchangerTests {
    private static final Exchanger<String> exchanger = new Exchanger<String>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);
    @Test
    public void test(){
       threadPool.execute(()->{
           try {
               String a = "bank - a";
               exchanger.exchange(a);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }

       });
       // 交叉检验
       threadPool.execute(()->{

           try {
               String b = "bank - b";
               // * Waits for another thread to arrive at this exchange point (unless
               //     * the current thread is {@linkplain Thread#interrupt interrupted}),
               //     * and then transfers the given object to it, receiving its object
               //     * in return.
               String a = exchanger.exchange(b);//--a的值
               //String c = exchanger.exchange(a); //Exchanger仅可用作两个线程之间的信息交换，当超过2个线程调用同一个Exchanger时，得到的结果是不可预料的。
               System.out.println("a，b是否一致？"+a.equals(b) + ";a:"+a+";b:"+b+";c:");
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }

       });
       threadPool.shutdown();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
