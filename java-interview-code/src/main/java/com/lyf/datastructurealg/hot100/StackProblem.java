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
public class StackProblem {
    public String decodeString(String s) {
        // 采用stack进行保存字符，判断是否退栈、压栈；SB进行处理字符串的拼接，注意需要进行反转处理
        Deque<Character> stack = new LinkedList<>();
        StringBuilder rs =new StringBuilder();
        for(int i=0;i<s.length();i++){
            Character ch = s.charAt(i);
            if(ch!=']'){
                stack.push(ch);
                continue;
            }

            // 考虑出栈
            StringBuilder tmp0 = new StringBuilder();
            while(!stack.isEmpty() && stack.peek()!='['){
                tmp0.append(stack.pop());
            }
            stack.pop();//删除[

            // 需要循环的字符串
            String newStr = tmp0.reverse().toString();
            // 处理循环的次数
            tmp0.delete(0,tmp0.length());
            while(!stack.isEmpty() && '0'<= stack.peek() && stack.peek()<='9'){
                tmp0.append(stack.pop());
            }

            if(tmp0.isEmpty()){
                //rs.append(newStr);
                for(int k=0;k<newStr.length();k++){
                    stack.push(newStr.charAt(k));
                }
                continue;
            }
            Integer frequency = Integer.valueOf(tmp0.reverse().toString());
            tmp0.delete(0,tmp0.length());
            for(int j=0;j<frequency;j++){
                tmp0.append(newStr);
            }
            //rs.append(tmp0);
            for(int k=0;k<tmp0.toString().length();k++){
                stack.push(tmp0.toString().charAt(k));
            }
        }

        // 考虑栈内还有字符
        StringBuilder tmp = new StringBuilder();
        while(!stack.isEmpty()){
            tmp.append(stack.pop());
        }
        rs.append(tmp.reverse().toString());
        return rs.toString();
    }
}
