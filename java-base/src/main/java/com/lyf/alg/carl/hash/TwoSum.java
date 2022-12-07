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
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // <= n^2
        // sort排序（快排）， 二分法，hash
        //    HashMap<Integer,Integer> record = new HashMap<>();
        //    for(int i=0;i<nums.length;i++)
        //        record.put(nums[i],i);// 重复情况，后续相同值覆盖前面的值


        //    // 该种方式解决不了 重复元素的问题
        //    Arrays.sort(nums);

        //    int low =0,high = nums.length-1;
        //    int mid = nums[low]+nums[high];
        //    while(mid!=target){// 只会存在一个有效答案
        //         if(mid<target)
        //            low++;
        //         else
        //            high--;
        //         mid = nums[low]+nums[high];
        //    }
        //    int val1 = record.get((Integer)nums[low]);
        //    int val2 = record.get((Integer)nums[high]);
        //    if(val1==val2){val1 = val2-1;}
        //    int[]rs = {val1,val2};
        //    return rs;
        int[]rs = new int[2];
        if(nums.length==0||nums.length==1)
            return rs;
        // 逆向思路，record记录之前 的
        Map<Integer,Integer> record = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int other = target - nums[i];
            if(record.containsKey((Integer)other)){
                rs[0]=i;
                rs[1]=record.get((Integer)other);
                return rs;//{(int)record.get((Integer)other),i};
            } //new int[]
            else record.put(nums[i],i);
        }
        return rs;
    }
}
