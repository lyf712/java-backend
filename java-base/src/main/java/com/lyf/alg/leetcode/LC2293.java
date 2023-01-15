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

package com.lyf.alg.leetcode;

/**
 * @author liyunfei
 **/
public class LC2293 {
    public int minMaxGame(int[] nums) {
        compute(nums,nums.length);

        return nums[0];
    }
    private void compute(int[]nums,int size){
        if(size==1){
            return ;//nums[0];
        }
        int index=0;
        for(int i=0;i<size;i=i+2){
            if(index%2==0)
                nums[index] = Math.min(nums[i],nums[i+1]);
            else
                nums[index] = Math.max(nums[i],nums[i+1]);
            index++;
        }
        compute(nums,size/2);
    }
}
