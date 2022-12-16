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
 * @authorliyunfei
 * @date2022/12/16
 **/
public class ClimbStairs {

    //花最小代价爬楼梯，同钢铁--问题 https://leetcode.cn/problems/min-cost-climbing-stairs/
    // 考虑路径记录问题，--
    public int minCostClimbingStairs(int[] cost) {
        //只用考虑最小花费，未记录路径，考虑打卡记录呢？，在选择时记录
        int[]dp = new int[cost.length];
        dp[0]=cost[0];
        dp[1]=cost[1];
        //    if(cost.length==2)return Math.min(dp[0],dp[1]);
        for(int i=2;i<cost.length;i++){
            dp[i] = Math.min(dp[i-1]+cost[i],dp[i-2]+cost[i]);//打卡记录路径
        }
        // 不一定在最后一个，也可能前一个已经可以走完
        return Math.min(dp[cost.length-2],dp[cost.length-1]);
    }
}
