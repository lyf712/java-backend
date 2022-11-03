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

package com.lyf.demo.task;

import com.lyf.demo.config.Consistency;
import com.lyf.demo.service.CrawlDataService;
import com.lyf.demo.service.CrawlDataServiceImpl;
import com.lyf.demo.storage.DB;

import java.util.List;

/**
 * // 爬取数据并存入DB、HDFS、持久化文件
 * // 保证顺序性，--
 *
 * @authorliyunfei
 * @date2022/11/3
 **/
public class GiteeCrawlerTask implements Runnable{
    private String crawlerUrl;
    private CrawlDataService crawlDataService;

    private int executeId;

    public GiteeCrawlerTask(String crawlerUrl, CrawlDataService crawlDataService, int executeId) {
        this.crawlerUrl = crawlerUrl;
        this.crawlDataService = crawlDataService;
        this.executeId = executeId;
    }

    @Override
    public void run() {
        // 大量网络开销，时间消耗
        List<String> rs = crawlDataService.crawlData(crawlerUrl);
        // 内存小数据遍历
        while (!Consistency.getAtomicInteger(executeId));
        DB.putData(rs,executeId);
    }
}
