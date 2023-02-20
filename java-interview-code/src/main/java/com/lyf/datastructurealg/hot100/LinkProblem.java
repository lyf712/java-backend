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

package com.lyf.datastructurealg.hot100;

/**
 * @author liyunfei
 **/
public class LinkProblem {
    class ListNode{private int val;private ListNode next;}
    public ListNode mergeKLists(ListNode[] lists) {
        // 1、递归两两合并 log2m  * n
        // 2、ptr[list.length]个指针进行比较 m*n
        return mergeKList(lists,0,lists.length);
    }
    private ListNode mergeKList(ListNode[] lists,int left,int right){
        if(right-left<=0){
            return null;
        }else if(right-left==1){
            return lists[left];
        }else if(right-left==2){
            return merge2List(lists[left],lists[left+1]);
        }
        ListNode leftList= mergeKList(lists,left,left+(right-left)/2+1);
        ListNode rightList = mergeKList(lists,left+(right-left)/2+1,right);
        return merge2List(leftList,rightList);
    }
    private ListNode merge2List(ListNode list1,ListNode list2){
        ListNode ptr1 = list1,ptr2 = list2;
        ListNode newHead = new ListNode();// 虚拟头结点
        ListNode headPtr = newHead;
        while(ptr1!=null || ptr2!=null){
            if(ptr1==null){
                headPtr.next = ptr2;
                break;
            }
            if(ptr2==null){
                headPtr.next = ptr1;
                break;
            }
            if(ptr1.val<ptr2.val){
                ListNode tmp = ptr1.next;
                ptr1.next = headPtr.next;
                headPtr.next=ptr1;
                ptr1 = tmp;
            }else{
                ListNode tmp = ptr2.next;
                ptr2.next = headPtr.next;
                headPtr.next=ptr2;
                ptr2 = tmp;
            }
            headPtr = headPtr.next;
        }
        return newHead.next;
    }
}
