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

package com.lyf.alg.carl.greed;

import java.util.Arrays;

/**
 * @authorliyunfei
 * @date2022/12/22
 **/
public class JumpGame {
    public boolean canJump(int[] nums) {
        // 2,4,3,4,8 //判断你是否能够到达最后一个下标，其实无需考虑最后一个了
        // 3,3,3,3,8
        // O(N),遍历，看每个数最大能到的地方，再进行滑动调整，最大可达
        for(int i=0;i<nums.length;i++){
            nums[i]+=i;
        }
        int start = 0,max=nums[0];//最大可达的地方
        while(start<=max){
            if(max>=nums.length-1)return true;
            if(nums[start]>max)max = nums[start];//更新最大可达的地方
            start++;
        }
        return max>=nums.length-1;
    }

    public boolean canJump2(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        //在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }


    public int jumpII(int[] nums) {
        //record [MAX,MAX,MAX,MAX,MAX]
        //0 - - - -
        //0 1 1 - -
        //0 1 1 1 2
        int[]record = new int[nums.length];
        Arrays.fill(record,Integer.MAX_VALUE);
        record[0] = 0;
        for(int i=0;i<nums.length-1;i++){
            int step = nums[i];
            for(int j=1;j<=step;j++){
                int nextIndex = i+j;
                if(nextIndex>nums.length-1) break;
                record[nextIndex] = Math.min(record[i]+1,record[nextIndex]);
            }
        }
        return record[nums.length-1];
    }
    public int jumpII2(int[] nums) {
        int rs = 0;
        int end = 0,nextEnd = 0;
        for(int i=0;i<=end && end<nums.length-1;i++){
            nextEnd = Math.max(nextEnd,i+nums[i]);// 保证最远的可达距离
            if(i==end){
                // 已走完该次最大可达的距离，需要继续更新下次可达；在该范围内只需跳跃一次，更新至下一次可达则需要加步数
                end = nextEnd;
                rs++;
            }
        }
        return rs;
    }
}
