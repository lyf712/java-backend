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

package com.lyf.alg.carl.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @authorliyunfei
 * @date2022/12/7
 **/
public class FourNumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 暴力法 n^4
        // hash降维 n^3; other = target - sum(1..3)
        // nums1,nums2合并 为一个数组，nums3，nums4合并为一个数组 在利用hash -> n^2
        // -1,0,0,-1; -1,1,2,4
        // n^2 * 2 × ---> 可利用hash降低重复数的计算
        // 4*n^2 == 6n^2
        //    int n = nums1.length;
        //    int []arr1 = new int[n*n];
        //    int []arr2 = new int[n*n];
        //    for(int i=0;i<n;i++){
        //        for(int j=0;j<n;j++){
        //            arr1[i*n+j] = nums1[i]+nums2[j];
        //            arr2[i*n+j] = nums3[i]+nums4[j];
        //        }
        //    }
        //    int sum = 0;
        //    for(int i=0;i<n*n;i++){
        //        for(int j=0;j<n*n;j++){
        //            if(arr1[i]+arr2[j]==0) sum++;
        //        }
        //    }
        //    return sum;
        // val,num
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        int n = nums1.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int val1 = nums1[i]+nums2[j];
                int val2 = nums3[i]+nums4[j];

                if(map1.containsKey(val1)){// 对比getOrDefault
                    map1.put(val1,map1.get(val1)+1);
                }else{
                    map1.put(val1,1);
                }

                if(map2.containsKey(val2)){// 对比getOrDefault
                    map2.put(val2,map2.get(val2)+1);
                }else{
                    map2.put(val2,1);
                }
            }
        }

        //    map1.forEach((k,v)->{
        //        int other = 0-k;


        //    })
        // -2,0,-2,0 ->
        //0,-2,2,0
        int sum = 0;
        for(Map.Entry<Integer,Integer> entry:map1.entrySet()){
            int other = 0-entry.getKey();
            if(map2.containsKey(other)){sum+=(entry.getValue()*map2.get(other));}
        }
        return sum;

    }
}
