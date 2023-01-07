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
public class OfferVII59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int []res = new int[nums.length+1-k];
        int maxIndex = 0;
        for(int i=0;i<k;i++){
            if(nums[i]>nums[maxIndex]) maxIndex = i;
        }
        int index = 0;
        res[index++] = nums[maxIndex];
        for(int i=k;i<nums.length;i++){
            if(i-k>=maxIndex) {
                // 更新
                maxIndex = i-k+1;
                for(int j=i-k+1;j<=i;j++){
                    if(nums[j]>nums[maxIndex]) maxIndex = j;
                }
            }else if(nums[i]>nums[maxIndex]) maxIndex = i;

            res[index++] = nums[maxIndex];
        }
        return res;
    }
}
