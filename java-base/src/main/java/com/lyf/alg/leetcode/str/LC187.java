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

import org.junit.Test;

import java.util.*;

/**
 * @author liyunfei
 **/
public class LC187 {
    @Test
    public void test1(){
        List<List<String>> k = new ArrayList<>();
        k.add(Arrays.asList("name","ok"));
        System.out.println(evaluate("(name)hello",k));
    }

    public static void main(String[] args) {

    }
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map = new HashMap<>(knowledge.size());
        for(List<String> list:knowledge){
            map.put(list.get(0),list.get(1));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='('){
                sb.append(s.charAt(i));
            }else{
                StringBuilder tmp = new StringBuilder();
                i++;
                while(s.charAt(i)!=')'){
                    tmp.append(s.charAt(i));
                    i++;
                }
                sb.append(map.getOrDefault(tmp.toString(),"?"));
            }
        }
        return sb.toString();
    }
}
