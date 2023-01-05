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

package com.lyf.alg.offer;

import java.util.HashMap;

/**
 * @authorliyunfei
 * @date2023/1/5
 **/
public class OfferVII35 {
    private class Node{
        int val;
        Node next,random;

        public Node(int val) {
            this.val = val;
        }
    }
    public Node copyRandomList(Node head) {
        // 先处理复制 单链表，--无法处理random
        // 利用哈希建立映射处理
        if(head==null) return null;
        // 原-新
        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur!=null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur =head;
        while(cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random =map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
