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

import com.google.common.base.Suppliers;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @authorliyunfei
 * @date2022/11/15
 **/
public class ComputerFutrureTests {
    @Test
    public void test(){
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.thenRun(()->{
            System.out.println("ok");
        });
        //CompletableFuture.delayedExecutor(10, TimeUnit.MILLISECONDS,new ScheduledThreadPoolExecutor());

        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(()->{
            System.out.println("ok");
        });
        // Consumer,Supplier
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(()->{return "ok";});
        try {
            System.out.println(completableFuture2.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
