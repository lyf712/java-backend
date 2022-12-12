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

package com.lyf.alg.carl.stackqueue;

import org.junit.Test;

import java.util.*;

/**
 * @authorliyunfei
 * @date2022/12/12
 **/
public class TopK {
    // 对元素的频率排序 (PrioryQueue)
    public int[] topKFrequent(int[] nums, int k) {
        // 直接hashMap, sort排序
        // element,radio
        Map<Integer,Integer> record = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            record.put(nums[i],record.getOrDefault(nums[i],0)+1);
        }
        // 按频率排序
        int[]rs = new int[k];

        record.forEach((k0,v0)->{
            Arrays.sort(rs);//保证从小到大比较   nlog*n
            for(int i=0;i<k;i++){
                if(rs[i]==0){rs[i]=k0;break;}// 更新了一个则需要退出
                else if(v0>record.get(rs[i])){rs[i]=k0;break;}
                //else continue;
            }
        });

//        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2)->pair2[1]-pair1[1]);
//        for(Map.Entry<Integer,Integer> entry:record.entrySet()){//大顶堆需要对所有元素进行排序
//            pq.add(new int[]{entry.getKey(),entry.getValue()});
//        }
//        int[] ans = new int[k];
//        for(int i=0;i<k;i++){
//            ans[i] = pq.poll()[0];
//        }
//        return ans;

        return rs;

    }

    @Test
    public void testPrioryQueue(){
           PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
           Map<Integer,Integer> map = new HashMap<>();
           // 封装类---呀----

    }


    //--
    public int beautySum(String s) {
        // hash（常数级别 26字母以内，采用map,内存开销增大，但可动态--）+双重循环
        int sum = 0;
        for(int i=0;i<s.length();i++){
            int[] hash = new int[26];
            for(int j=i;j<s.length();j++){
                hash[s.charAt(j)-'a']++;
                //if(j-i<3) continue;// 小于三的情况下，只能为0
                // 维护查看hash的情况，若存在美丽值可取则
                int min = Integer.MAX_VALUE;
                int max = 0;
                for(int k=0;k<26;k++){
                    if(hash[k]!=0){
                        // 更新最大、最小频率
                        if(hash[k]>max) max = hash[k];
                        if(hash[k]<min) min = hash[k];
                    }
                }

                if(min!=Integer.MAX_VALUE)
                    sum+=(max-min);
            }
        }
        return sum;
    }

}
