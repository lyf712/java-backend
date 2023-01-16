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

package com.lyf.alg.leetcode.stack;

import java.util.Stack;

/**
 * 单调栈.
 * @author liyunfei
 **/
public class SingleStack {
    public int[] dailyTemperatures(int[] temperatures) {
        //    int[] res = new int[temperatures.length];
        //    for(int i=0;i<temperatures.length;i++){
        //        res[i] = 0;
        //        for(int j=i+1;j<temperatures.length;j++){
        //            if(temperatures[j]>temperatures[i]) {
        //                res[i]  = j-i;
        //                break;
        //            }
        //        }
        //    }
        //    return res;

        int []res = new int[temperatures.length];
        Stack<Integer> stack  = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int pre = stack.pop();
                res[pre] = i-pre;
            }
            stack.push(i);
        }
        return res;
    }
}
