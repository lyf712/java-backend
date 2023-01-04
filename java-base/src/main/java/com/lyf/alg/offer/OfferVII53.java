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
 * @date2023/1/4
 **/
public class OfferVII53 {
    public int search(int[] nums, int target) {
        //二分
        int low = 0,high = nums.length-1;
        int count=0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                // 开始双端遍历
                int i = mid,j=mid+1;
                while(i>=0&&nums[i]==target){
                    count++;
                    i--;
                }
                while(j<nums.length&&nums[j]==target){
                    count++;
                    j++;
                }
                break;
            }else if(nums[mid]<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return count;
    }
}
