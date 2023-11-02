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

package com.lyf.huawei.practice;

import java.util.*;

/**
 * @author liyunfei
 **/
public class MapProblem {

    public static void main(String[] args) {
        // 统计词频 top K
         List<String> words = new ArrayList<>();
         words.add("hello");
         words.add("hello");
        words.add("hello");
        words.add("ok");
        words.add("hllo");
        words.add("hllo");

         // ---
        Map<String,Integer> countMap = new HashMap<>();
        for (String word:words) {
            countMap.compute(word,(k,v)->{
                if(v==null){
                    return 1;
                }
                return v+1;
            });
        }
        List<Map.Entry<String,Integer>> entries= new ArrayList<>(countMap.entrySet().stream().toList());
        entries.sort(Comparator.comparingInt(Map.Entry::getValue));
        entries.forEach(System.out::println);

    }


}
