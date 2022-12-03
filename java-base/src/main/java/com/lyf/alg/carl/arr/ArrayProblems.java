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

import java.util.HashMap;
import java.util.Map;

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
     * 3.双指针（平方数组）
     * 4.滑动窗口
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

    // 双指针--https://leetcode.cn/problems/squares-of-a-sorted-array/
    public int[] sortedSquares(int[] nums) {
        // 基本思路
        // left ,right 双指针： right位置放大的值，小的值无法确定（在中间）
        // left,right两端其中必然有一个最大值
        int left = 0,right = nums.length-1;
        // 内存没有最优，思考如何在同一数组操作
        int[] rs = new int[nums.length];
        int k = right;
        while(left <= right){
            if(nums[left]*nums[left]>nums[right]*nums[right]){
                rs[k--] = nums[left]*nums[left++];
            }else{
                rs[k--] = nums[right]*nums[right--];
            }
        }
        return rs;
    }

    public int minSubArrayLen(int target, int[] nums) {
        // left,right;sum(nums[left],..,nums[right]) 不够则 right++,够则left--;
        // 结合滑动窗口——网络请求控制网络拥塞思考（控制的是接收端，发送端）
        // 并将达标的进行 更新 len （初始值为0）

        // carl
        int left=0,right=0;
        int rs = Integer.MAX_VALUE;
        int sum=0;
        while(right<nums.length){
            sum+=nums[right];// 吸收值
            while(sum>=target){// 只需要处理溢出情况，即减少窗口来满足下次吸收
                if(right-left+1<rs)
                    rs = right-left+1;
                sum-=nums[left++];// 窗口减少，
            }
            right++;
        }
        return rs==Integer.MAX_VALUE?0:rs;


        // int left=0,right=0;
        // int rs = Integer.MAX_VALUE;
        // int sum=0;
        // while(right<nums.length){
        //      sum+=nums[right];// 积累该窗口右边的值[先加一个值]
        //      if(sum<target){
        //          // 一次只考虑 加一个窗口OR减一个窗口即可，无需像以下那样考虑--

        //          right++;// 不满足，则增大窗口即可
        //      }else{// 满足，考虑是否存在更新
        //          int size = right-left+1;
        //          if(size<rs)
        //              rs = size;
        //          //left++;// 减少窗口，因为已经达标，需要移除最早的，容纳新的值进来
        //          sum -= nums[left++];
        //          sum -= nums[right];
        //      }
        // }
        // return rs==Integer.MAX_VALUE?0:rs;


        //    int left=0,right=0;
        //    int rs = Integer.MAX_VALUE;
        //    int sum = 0;
        //    while(right<nums.length){
        //        if(sum<target){
        //            while(right<nums.length &&  (sum+=nums[right])<target)
        //                right++;// 移动右边指针
        //        }else{
        //            while(left<=right && (sum-=nums[left]) >= target)
        //                left++;
        //            if(right<left)
        //                right = left;
        //        }

        //         if(right-left+1<rs)
        //             rs = right-left+1;
        //    }
        //    return rs==Integer.MAX_VALUE?0:rs;
    }


    public int totalFruit(int[] fruits) {
        // 滑动窗口变式-- sum → 种类数（引起发生改变）
        // 已知只有两个篮子，，设置一个 flag[] = new int[2];记录已有的即可，未记录的-1 （种类 0+）
        int left = 0,right = 0;
        int rs = 0;// 最大数目,最少也可以 Min(fruits.length,2)
        //    int[] record = new int[2];// 考虑集合代替
        //    Arrays.fill(record,-1);// 未记录
        // 无法保证窗口减少--
        Map<Integer,Integer> record = new HashMap<>(2);

        while(right<fruits.length){
            // 处理 record情况
            // 消费 new fruit
            Integer newFruit = fruits[right];
            // 若包含该类水果，直接加入；不包含，则考虑 缩小窗口或者 占用未-1的篮子
            Integer num = record.get(newFruit);
            if(num!=null){//包括该水果,
                record.put(newFruit,num+1);// 多一个
                if(right-left+1>rs)
                    rs = right-left+1;// 增大考虑比较更新
            }else{//
                // Integer leftNum = record.get(fruits[left]);
                // 先判断篮子种类数是否够用
                if(record.size()==2){
                    // 此种情况，加入会影响，溢出，则考虑缩小窗口
                    while(record.size()==2)
                    {
                        Integer leftVal = fruits[left];
                        Integer leftNum = record.get(leftVal);
                        if(leftNum-1==0){
                            record.remove(leftVal);
                        }else{
                            record.put(leftVal,leftNum-1);
                        }
                        left++;
                    }
                    record.put(newFruit,1);
                }else{// 该种情况，考虑和num!=null合并，该种情况则是num==0的特殊情况
                    record.put(newFruit,1);
                    if(right-left+1>rs)
                        rs = right-left+1;// 增大考虑比较更新
                }
            }
            right++;
        }
        return rs;
    }
}
