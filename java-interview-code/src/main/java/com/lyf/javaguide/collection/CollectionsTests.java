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

package com.lyf.javaguide.collection;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liyunfei
 **/
public class CollectionsTests {
    @Test
    public void test(){
        Collection collection = new ArrayList();
        List list = new ArrayList<>();
        List list1 = new LinkedList();
        List list2 = new Vector();
        List list3 = new Stack();
        //Stack stack = new Stack();

        Queue queue = new LinkedList();
        Queue queue1 = new ArrayDeque();
        Queue queue2 = new PriorityQueue();

        //new LinkedList<>()
        // review collecton

        Map map = new HashMap();
        Map map1 = new Hashtable();
        Map map2 = new LinkedHashMap();
        Map map3 = new Properties();
        Map map4 = new ConcurrentHashMap();

    }
}
