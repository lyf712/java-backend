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

package com.lyf.alg.carl.dp;

import org.junit.Test;

/**
 * @author liyunfei
 **/
public class RobII {
    @Test
    public void test() {
        rob(new int[]{1, 2, 1, 1});
    }

    public int rob(int[] nums) {
        // 在原有基础上打卡记录是否通往 0 号门
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        //dp[2]=nums[2];
        boolean[] record = new boolean[nums.length];//记录是否通往0
        record[0] = true;
        record[1] = false;
        for (int i = 2; i < nums.length; i++) {
            if (i != nums.length - 1) {
                if (i != 2) {
                    if (dp[i - 2] > dp[i - 3]) {
                        dp[i] = dp[i - 2] + nums[i];
                        record[i] = record[i - 2];
                    } else {
                        dp[i] = dp[i - 2] + nums[i];
                        record[i] = record[i - 3];
                    }
                } else {
                    record[i] = record[i - 2];
                    dp[i] = dp[i - 2] + nums[i];
                }
            } else {
                int ptr = i - 2, count = 0;
                int max = Integer.MIN_VALUE;

                while (ptr >= 0 && count < 2) {
                    if (!record[ptr]) {
                        count++;
                        if (max < dp[ptr]) max = dp[ptr];
                    }
                    ptr--;
                }
                dp[i] = max + nums[i];

            }
        }
        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }

    public int rob2(int[] nums) {
        if (nums.length == 1) return nums[0];
        int rs1 = rob0(nums, 0, nums.length - 2);
        int rs2 = rob0(nums, 1, nums.length - 1);
        return Math.max(rs1, rs2);
    }

    private int rob0(int[] nums, int start, int end) {
        if (end - start == 0) return nums[start];
        if (end - start == 1) return Math.max(nums[start], nums[start + 1]);
        int[] dp = new int[end + 1];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }
}
