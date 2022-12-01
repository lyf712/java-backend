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

package com.lyf.alg.carl.arr;

/**
 * @authorliyunfei
 * @date2022/12/1
 **/
public class ArrayProblems {
    /**
     * 题目列表
     * 1.二分查找 https://leetcode.cn/problems/binary-search/
     * 2.移除元素
     * 直接覆盖删除元素，无需关注顺序性（若考虑关注顺序性呢？）
     */
    public int search(int[] nums, int target) {
        int low =0,high=nums.length-1;
        while(low<=high){ // 注意 [,] ;[,)  情况 若是 [,)则 <
            int mid = (low+high) >> 1; // 为防止溢出 最好使用 low + ( (low+high) >> 1)
            if(target==nums[mid])
                return mid;
            else if (target < nums[mid])
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }



    // FIXME 理解思考，
    public int searchInsert(int[] nums, int target) {
        // 思路一：遍历判断是否适合
        // 思路二：二分的方法去判断 × 思考复杂了--
        //  nums[index-1]  < target <= nums[index]
        // 若等于直接返回下标
        // 若大于先判断 mid+1的值 是否在该区间，mid+1时需要去判断是否越界，若越界则直接返回mid+1 ，同理可得 小于的情况

        int left = 0 ,right = nums.length-1;
        while(left<=right){
            int mid = left +((right-left)>>1);
            if(nums[mid]==target)
                return mid;
            else if(target<nums[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return right+1;
    }


    public int removeElement(int[] nums, int val) {
        // 注意这五个元素可为任意顺序
        int index = nums.length-1;
        while(index>=0&&nums[index]==val)
            index--;

        for(int i=0;i<index;i++){
            if(nums[i]==val){
                //
                int tmp = nums[index];
                nums[index--] = val;// 删除的元素
                nums[i] = tmp;
                // 更新指标
                while(index>=0&&nums[index]==val)
                    index--;
            }
        }
        return index+1;
    }

}
