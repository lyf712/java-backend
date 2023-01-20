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

package com.lyf.alg.leetcode.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author liyunfei
 **/
public class LC1817 {
    @Test
    public void test(){
        Map<Integer,Set<Integer>> map = new HashMap<>();

        map.computeIfAbsent(1, new Function<Integer, Set<Integer>>() {
            @Override
            public Set<Integer> apply(Integer integer) {
                System.out.println(integer);
                return null;
            }
        });

        map.computeIfPresent(2, new BiFunction<Integer, Set<Integer>, Set<Integer>>() {
            @Override
            public Set<Integer> apply(Integer integer, Set<Integer> integers) {
                integers.add(integer);
                return integers;
            }
        });

    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        // hash，用户，活跃数set
        Map<Integer, Set<Integer>> hash = new HashMap<>();
        for(int i=0;i<logs.length;i++){
//            Set<Integer> set = hash.getOrDefault(logs[i][0],new HashSet<Integer>());
//            set.add(logs[i][1]);
//            hash.put(logs[i][0],set);
            // 熟悉该API
            hash.computeIfAbsent(logs[i][0], k1 -> new HashSet<Integer>()).add(logs[i][1]);
            //hash.putIfAbsent()
            //hash.computeIfAbsent()
//            hash.computeIfPresent(1, (integer, integers) -> {
//                integers.add(integer);
//                return integers;
//            });


        }
        int []res = new int[k];
        for(Map.Entry<Integer,Set<Integer>> entry:hash.entrySet()){
            int val = entry.getValue().size();
            if(val!=0)
                res[val-1]++;
        }
        return res;
    }
}
