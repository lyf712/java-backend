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

package com.lyf.alg.carl.link;

/**
 * @authorliyunfei
 * @date2022/12/5
 **/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class ReserveLinkedList {
    // 多加理解
    ListNode reverse(ListNode pre,ListNode cur){
        // 终止条件
        if(cur==null) return pre;
        // 递归处理
        ListNode tmp = cur.next;
        cur.next = pre;
        // 递归前进
        return reverse(cur,tmp);
    }
    // return reverse(null,head)
    public ListNode reverseListByIterator(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode pre = head;
        ListNode cur = head.next;
        pre.next = null;// 注意将首节点的next置空，否则出现循环---
        while(cur!=null){
            ListNode nextCur = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextCur;
        }
        return pre;

        // 1.迭代法
        //    ListNode pre=new ListNode();
        //    ListNode cur = head;
        //    pre.next = head;
        //    while(cur!=null&cur.next!=null){
        //        ListNode tmpCur = cur.next;
        //        // 操作反转
        //        cur.next = pre;
        //        //tmpCur.next = cur;
        //        pre = cur;
        //        cur = tmpCur;
        //    }
        //cur.next=pre;
        //Error - Found cycle in the ListNode
        // return pre;

    }
}
