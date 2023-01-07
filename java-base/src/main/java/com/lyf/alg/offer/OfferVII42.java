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

package com.lyf.alg.offer;

/**
 * @authorliyunfei
 * @date2023/1/7
 **/
public class OfferVII42 {
    // 暴力 N^2,分支，dp
    public int maxSubArray(int[] nums) {
        int[]dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1;i<nums.length;i++){
            dp[i] =  Math.max(dp[i-1]+nums[i],nums[i]);
            if(dp[i]>max) max = dp[i];
        }
        return max;
    }
}
