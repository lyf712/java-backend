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

import java.util.concurrent.*;

/**
 * @author liyunfei
 **/
public class CoreExecutors {

    private final static ExecutorService CORE_THREAD_POOL
            = new ThreadPoolExecutor(5,5,0L,
            TimeUnit.SECONDS,new ArrayBlockingQueue<>(10000),new SampleThreadFactory("coreThread"));

    private final static ScheduledExecutorService CORE_SCHEDULE_THREAD_POOL
            = new ScheduledThreadPoolExecutor(5,new SampleThreadFactory("coreThread"));

    public static void executeAtFixed(Runnable r,long rate){
        CORE_SCHEDULE_THREAD_POOL.scheduleAtFixedRate(r,0,rate,TimeUnit.SECONDS);
    }
}
