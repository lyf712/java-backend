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
public class InersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0,lenB=0;
        ListNode ptrA = headA,ptrB=headB;
        while(ptrA!=null){
            lenA++;
            ptrA = ptrA.next;
        }
        while(ptrB!=null){
            lenB++;
            ptrB = ptrB.next;
        }
        ptrA = headA;
        ptrB = headB;
        int index=0;
        if(lenA>lenB){
            int len = lenA-lenB;
            while(index<len){
                ptrA=ptrA.next;
                index++;
            }
        }else if(lenB>lenA){
            int len = lenB-lenA;
            while(index<len){
                ptrB=ptrB.next;
                index++;
            }
        }
        // 不考虑环
        while(ptrA!=ptrB){
            ptrA=ptrA.next;
            ptrB=ptrB.next;
        }

        return ptrA;
    }
}
