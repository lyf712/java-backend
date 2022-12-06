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
public class SwapPairs {
    // 迭代思维 考虑转换为递归（当 nextPre==null||nextPre.next==null 终止条件,
    // swapPairs(head.next.next)递进
    public ListNode swapPairs(ListNode head) {
        // 考虑边界（链表类考虑空指针，数组类，考虑下标，合法性
        if(head==null||head.next==null)
             return head;
        // 指针指向
        ListNode pre = head,cur=head.next;
        ListNode returnHead = cur;
        // 注意pre的指向，下一个迭代周期也会交换，因此需要考虑下一周期的 pre,cur
        ListNode nextPre,nextCur;
        while(pre!=null&&cur!=null){
            nextPre = cur.next;
            cur.next = pre;
            // 0,1,2三种情况
            if(nextPre==null||nextPre.next==null){// 对于下一周期的情况0,1可以归为无需交换的一类
                //nextCur = null;
                pre.next = nextPre;
                break;
            }else{// 需要交换的一类
                nextCur = nextPre.next;
                pre.next = nextCur;
                pre = nextPre;
                cur = nextCur;
            }
        }
        return returnHead;
    }
}
