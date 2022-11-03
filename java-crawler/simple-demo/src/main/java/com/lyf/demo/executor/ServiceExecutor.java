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

package com.lyf.demo.executor;

import com.lyf.demo.service.CrawlDataServiceImpl;
import com.lyf.demo.task.GiteeCrawlerTask;

import java.util.concurrent.*;

/**
 * @authorliyunfei
 * @date2022/11/3
 **/
public class ServiceExecutor {
    final static ExecutorService executorService = new ThreadPoolExecutor(2,9,
            2000L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(100));

    private final static String BASE_ORDER_SEARCH_URL = "https://gitee.com/explore/all?order=starred&page=";// + pageNo

    public static void execute(){
        int start = 1;
        int end = 100;// 过大,jvm会爆
        for(int i=start;i<end;i++)
            executorService.execute(new GiteeCrawlerTask
                    (BASE_ORDER_SEARCH_URL+i,new CrawlDataServiceImpl(),i));
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
