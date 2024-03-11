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

package com.lyf.sample.excutors;

import com.lyf.sample.excutors.threads.SampleThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 **/
public class NotifyExecutors {

    private final static ExecutorService NOTIFY_THREAD_POOL
            = new ThreadPoolExecutor(5,5,0L,
            TimeUnit.SECONDS,new ArrayBlockingQueue<>(10000),new SampleThreadFactory("notifyThread"));

    public static void submit(Runnable r){
        NOTIFY_THREAD_POOL.submit(r);
    }

}
