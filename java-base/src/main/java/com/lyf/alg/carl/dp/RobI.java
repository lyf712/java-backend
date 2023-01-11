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

/**
 * @author liyunfei
 **/
public class RobI {
    public int rob1(int[] nums) {
        // 1 , 2 , 3 , 4
        // i的最大为前面两个或者三个累加的最大值，不能为邻近的
        //
        int[] dp = new int[nums.length];
        if (nums.length == 1) return nums[0];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (i - 3 < 0) {
                dp[i] = dp[0] + nums[i];
            } else {
                dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
            }
        }
        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }
    // 另外一种思考方式：i最大为它前一个，到它前一个则结束了，要么为前两个+本身

}
