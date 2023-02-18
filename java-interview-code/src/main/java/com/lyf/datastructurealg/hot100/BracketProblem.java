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

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liyunfei
 **/
public class BracketProblem {
    public int longestValidParentheses(String s) {
        // 当左括号数量大于等于右括号数量都是合法的
        // 长度为 2 * max(left);
        // 需要保证连续
        //    int left=0,right=0;
        //    int max = 0;
        //    for(int i=0;i<s.length();i++){
        //        if(s.charAt(i)=='('){
        //            left++;
        //        }else{
        //            right++;
        //        }
        //        if(left>=right){
        //            if(2*left>max){
        //                max = 2*right;
        //            }
        //        }else{ // 不合法了，需要重新计
        //            left = 0;
        //            right = 0;
        //        }
        //    }
        //    return max;


        // 利用栈的方法
        // 左括号直接压栈，右括号则退栈，进行计数，并设置标记位，判断是否连续
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int max = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){// 重新开始计算
                    stack.push(i);
                }else{
                    max = Math.max(max,i-stack.peek());
                }
            }
        }
        return max;



    }
}
