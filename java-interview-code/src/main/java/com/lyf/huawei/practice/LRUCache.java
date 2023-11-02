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

package com.lyf.huawei.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyunfei
 **/
public class LRUCache implements Cache<Object,Object>{

    private final static int DEFAULT_CAPACITY = 16;

    private int capacity;

    private Map<Object,Node> hash;

    private Node head,tail;

    public LRUCache(int capacity) {
        if(capacity<=0){
            capacity = DEFAULT_CAPACITY;
        }
        this.capacity = capacity;
        hash = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    @Override
    public void put(Object o, Object o2) {
        if(hash.containsKey(o)){
            Node node = hash.get(o);
            node.val = o2;
            // moveToHead()
        }else{
            // 判断容量，若容量符合要求，则直接插入
            // 容容量不够，则进行淘汰策略（淘汰末尾）（hash移除，链表移除


        }
    }

    @Override
    public Object get(Object o) {
        return hash.getOrDefault(o,new Node()).val;
    }


    private static class Node{
        private Node pre,next;
        private Object val;
    }
}
