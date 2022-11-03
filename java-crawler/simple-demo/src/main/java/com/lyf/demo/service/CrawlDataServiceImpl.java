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

package com.lyf.demo.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @authorliyunfei
 * @date2022/11/3
 **/
public class CrawlDataServiceImpl implements CrawlDataService{

    /**
     * 爬取title
     * @param url
     * @return
     */
    @Override
    public List<String> crawlData(String url) {
        List<String> contents = new ArrayList<>(15);
        Connection connection = Jsoup.connect(url);
        try {
            Document document = connection.get();
            Elements elements = document.getAllElements();
            Iterator<Element> iterator = elements.iterator();
            while (iterator.hasNext()){
                Element element = iterator.next();
                if(element.className().equals("project-desc mb-1")){
                      contents.add(element.attr("title"));
                }
            }
        } catch (IOException e) {
            // 网络出错处理
            throw new RuntimeException(e);
        }
        return contents;
    }
}
