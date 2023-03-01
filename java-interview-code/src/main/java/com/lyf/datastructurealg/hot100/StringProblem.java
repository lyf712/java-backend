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

import java.util.*;

/**
 * @author liyunfei
 **/
public class StringProblem {
    public List<Integer> findAnagrams(String s, String p) {
        // 统计词频，遍历计数即可， O(n * m)
        if(s.length()<p.length()){
            return new ArrayList<>();
        }
        List<Integer> rs = new ArrayList<>();
        Map<Character,Integer> target = new HashMap<>();
        Map<Character,Integer> counter = new HashMap<>();
        for(int i=0;i<p.length();i++){
            Character chp = p.charAt(i);
            Character chs = s.charAt(i);
            target.put(chp,target.getOrDefault(chp,0)+1);
            counter.put(chs,counter.getOrDefault(chs,0)+1);
        }
        for(int i=p.length();i<=s.length();i++){
            boolean flag = true;
            for(Map.Entry<Character,Integer> entry:target.entrySet()){
                // 需要用equals,不能直接采用！= ，不然通过不了；
                // reason:Object的比较--而非值的比较
                if(!entry.getValue().equals(counter.get(entry.getKey()))){
                    flag = false;
                    break;
                }
            }
            if(flag){
                rs.add(i-p.length());
            }
            // 到最后无需滑动处理了
            if(i==s.length()){
                break;
            }
            // 滑动处理
            char key = s.charAt(i - p.length());
            counter.put(key,counter.get(key)-1);
            counter.put(s.charAt(i),counter.getOrDefault(s.charAt(i),0)+1);
        }
        return rs;
    }
    // 官方
    private void offial(){
       // Arrays.equals()
        int[]nums = new int[3];
        //new ArrayList<>().remove(1)
        List list = Collections.singletonList(nums);
        
        //new ArrayList<>(Collections.singleton(nums));
    }
}
