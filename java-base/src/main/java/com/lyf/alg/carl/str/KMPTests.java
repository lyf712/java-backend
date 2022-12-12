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

package com.lyf.alg.carl.str;

import org.junit.Test;

import java.util.Arrays;

/**
 * 关键理解：最长公共前后缀；前缀表原理及
 * next数组的构造
 *
 * https://leetcode.cn/problems/repeated-substring-pattern/submissions/
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/submissions/
 *
 * @authorliyunfei
 * @date2022/12/12
 **/
public class KMPTests {
       // 模式串，next数组 (-1)
       private void createNextArr(String str,int[]next){ //int[]subStr
               int j = 0;
               next[0] = j;
               for(int i=1;i<str.length();i++){
                   while(j>0 &&str.charAt(i)!=str.charAt(j)){
                       j = next[j-1];//不匹配时的回退
                   }
                   if(str.charAt(i) == str.charAt(j)){
                       j++;// 匹配时继续
                   }
                   next[i] = j;
               }
       }
       @Test
       public void testNext(){
              String str = "aba";
              int[] next = new int[str.length()];
              createNextArr(str,next);
              System.out.println(Arrays.toString(next));
       }

    //
    private void getNext(String s,int[]next){
        int j=0;
        next[0] = j;
        for(int i=1;i<s.length();i++){
            while(j>0 && s.charAt(i)!=s.charAt(j)){
                j = next[j-1];
            }
            if(s.charAt(i)==s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
    }
    public boolean repeatedSubstringPattern(String s) {
        int[]next = new int[s.length()];
        getNext(s,next);
        if(next[s.length()-1]!=0 && s.length() % (s.length()-next[s.length()-1]) == 0 ) return true;
        return false;
    }

}
