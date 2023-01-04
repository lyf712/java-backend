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

import java.util.*;

/**
 * @authorliyunfei
 * @date2023/1/4
 **/
public class OfferVII31 {
    //栈操作
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int ptr1=0,ptr2=0;
        while(ptr1<pushed.length){
            stack.push(pushed[ptr1++]);
            while(!stack.isEmpty()&&stack.peek()==popped[ptr2]){
                stack.pop();
                ptr2++;
            }
        }
        // 多次一举
//        while(!stack.isEmpty()&&stack.peek()==popped[ptr2]){
//            stack.pop();
//            ptr2++;
//        }
        return stack.isEmpty();

    }
}
