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

package com.lyf.demo;

import com.lyf.demo.executor.ServiceExecutor;
import jdk.jfr.StackTrace;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Jsoup框架爬虫
 * @authorliyunfei
 * @date2022/11/3
 **/
public class JsoupTest {
    private final static String BASE_URL = "https://gitee.com/";
    private final static String ORDER_SEARCH_URL = "https://gitee.com/explore/all?order=starred";
    //https://gitee.com/explore/all?order=starred&page=3
    private final static String BASE_ORDER_SEARCH_URL = "https://gitee.com/explore/all?order=starred&page=";// + pageNo

    @Test
    public void testJsoup(){
        Connection connect =  Jsoup.connect(ORDER_SEARCH_URL); // HttpUrlConnection
        try {
            Document document = connect.get();
            //System.out.println(document.body());
            // 爬取标题
            Elements element = document.body().getElementsByClass("project-desc mb-1");
            //document.getElementById()
            //document.body().getElementsByClass()
            //System.out.println(element.get(0));
            //System.out.println(document.body().getAllElements().size());
            Elements elements = document.body().getAllElements();
            System.out.println(elements.size()+":"+elements.hasClass("project-desc mb-1"));
            Iterator<Element> elementIterator = elements.iterator();
            int count=0;
            while(elementIterator.hasNext()){
                Element element1 = elementIterator.next();
                //System.out.println(element1.data());
                //System.out.println(element1.className());
                // project-desc mb-1
                if(element1.className().equals("project-desc mb-1")){
                    count++;
                    //System.out.println(element1 + "\n");
                    System.out.println(element1.attr("title")); // 关键词切分，，做词云
                }
            }
            System.out.println("=====size"+count);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testC(){
        ServiceExecutor.execute();
    }



}
