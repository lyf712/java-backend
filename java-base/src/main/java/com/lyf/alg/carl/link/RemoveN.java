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
 * @date2022/12/6
 **/
public class RemoveN {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);//虚拟节点，方便删除
        pre.next = head;// 保留 pre,考虑 [1]的特殊情况，返回，若不要prePtr指针，返回head则无法删除--；或者也可排除删除头结点的情况
        ListNode cur = head,prePtr = pre;// 已走1一个
        // cur先走n个，pre再走
        int index = 1;
        while(index<n){
            cur = cur.next;
            index++;
        }
        // 一起走
        while(cur.next!=null){
            cur=cur.next;
            prePtr = prePtr.next;
        }
        prePtr.next = prePtr.next.next;
        return pre.next;
    }

    // 不引入多的指针，排除删除头结点的情况
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode pre = new ListNode(0);//虚拟节点 × 此处角色扮演的快慢指针，需要单独引入虚拟头结点，方便删除
        pre.next = head;
        //ListNode cur = head,prePtr = pre;// 已走1一个
        ListNode cur = head;
        // cur先走n个，pre再走
        int index = 1;
        while(index<n){
            cur = cur.next;
            index++;
        }
        // 一起走
        while(cur.next!=null){
            cur=cur.next;
            //prePtr = prePtr.next;
            pre=pre.next;
        }
        // prePtr.next = prePtr.next.next;
        if(pre.next==head)
            return pre.next.next;
        else{
            pre.next = pre.next.next;
            return head;
        }


        // return pre.next;
    }
}
