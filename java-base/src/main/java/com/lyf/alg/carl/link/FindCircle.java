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
public class FindCircle {
    public ListNode detectCycle(ListNode head) {
        // 方法1：HashMap

        // 方法2：快慢指针可判断有无，如何去确定？ fast 2 slow 1; 环的长度 len

        // circle : m , n-m;   证明 fast = n+m; slow = n;;   fast*t = n+m slow*t = m

        // x y z ;  fast:x+n*(y+z)+y;slow x + y

        // 证明 相遇节点出发到环入口和头结点出发距离相等

        ListNode fast = head,slow = head;
        while(fast!=null&&fast.next!=null){// 两个步长,保证fast即可
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){// 相遇
                ListNode index1 = head,index2 = fast;
                int index = 0;
                while(index1!=index2){
                    index++;
                    index1=index1.next;
                    index2=index2.next;
                }
                return index1;//index;
            }
        }
        return null;//-1;// 无环，出不来

    }
}
