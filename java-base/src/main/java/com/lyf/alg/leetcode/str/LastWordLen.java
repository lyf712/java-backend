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

package com.lyf.alg.leetcode.str;

/**
 * @author liyunfei
 **/
public class LastWordLen {
    public int lengthOfLastWord(String s) {
        boolean flag = false;// 可能会开启新的单词
        int count = 0;
        int i=0;
        while(s.charAt(i)==' ') i++;
        int j = s.length()-1;
        while(s.charAt(j)==' ') j--;

        for(;i<=j;i++){
            if(s.charAt(i) != ' ') {
                if(!flag){
                    count++;
                }else {
                    flag = false;
                    count = 1;//开启了新的
                }
            }else {
                flag = true;
            }
        }
        return count;
    }
}
