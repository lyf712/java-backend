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

package com.lyf.alg.leetcode.arr;

import java.util.Arrays;

/**
 * @author liyunfei
 **/
public class BinarySearch {
    public int[] searchRange(int[] nums, int target) {
        // 二分查找，找到之后，进行双指针寻找起始位置
        int []res = new int[2];
        Arrays.fill(res,-1);
        int low = 0,high = nums.length-1;
        while(low<=high){
            int mid = (high+low) / 2;
            if(nums[mid] == target) {
                res[0]=mid;
                res[1]=mid;
                for(int i=mid;i>=0;i--){
                    if(nums[i]!=target){
                        //res[0]=i+1;
                        break;
                    }else{
                        res[0]=i;
                    }
                }
                for(int i=mid;i<nums.length;i++){
                    if(nums[i]!=target){
                        //res[1]=i-1;
                        break;
                    }else{
                        res[1] = i;
                    }
                }
                break;
            }else if(nums[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return res;
    }
}
