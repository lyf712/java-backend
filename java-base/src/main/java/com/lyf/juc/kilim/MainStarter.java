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

package com.lyf.juc.kilim;

import kilim.Mailbox;
import kilim.Task;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liyunfei
 **/
public class MainStarter {

    final static Map<Integer, Mailbox<Object>> mailMap = new ConcurrentHashMap<>(1000);

    public static void main(String[] args) {
        if(kilim.tools.Kilim.trampoline(false,args)) {
            return;
        }
        Properties properties = new Properties();
        properties.setProperty("kilim.Scheduler.numThreads","4");
        System.setProperties(properties);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Mailbox<Object> mb = new Mailbox<>(10);
            new ProducerTask(i,mb).start();
            mailMap.put(i,mb);
        }
        for (int i = 0; i < 100; i++) {
            new ConsumerTask(mailMap.get(i)).start();
        }

        Task.idledown();
        long end = System.currentTimeMillis();
        System.out.printf("耗时 %d",end-start);

    }
}
