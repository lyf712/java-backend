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

import java.util.Arrays;

/**
 * @authorliyunfei
 * @date2022/12/28
 **/
public class PackagePb {
    class Good{
        String name;
        int weight;
        int value;

        public Good(String name, int weight, int value) {
            this.name = name;
            this.weight = weight;
            this.value = value;
        }
    }
    final Good[]goods = {
            new Good("物品0",1,15),
            new Good("物品1",3,20),
            new Good("物品2",4,30)
    };
    final int MAX_CAPACITY = 4;
    /**
     * 01背包问题
     * dp[i][j] = max{dp[i-1][j],dp[i][j-weight[i]] + value[i]}
     */
    @Test
    public void test2Arr(){
           // 定义数组
           int [][]dp = new int[goods.length][MAX_CAPACITY+1];
           // 初始化
           for(int i=0;i<goods.length;i++){
               dp[i][0] = 0;// 容量为0
           }
           for(int j=1;j<=MAX_CAPACITY;j++){
               if(j>=goods[0].weight)
                   dp[0][j] = goods[0].value;
               else
                   dp[0][j] = 0;
           }

           // 遍历
           for(int i=1;i<goods.length;i++){
               for(int j = 1;j<=MAX_CAPACITY;j++){
                       if(j-goods[i].weight<0)
                           dp[i][j] = dp[i-1][j];//装不下物品i
                       else
                           dp[i][j] = Math.max(dp[i-1][j],dp[i][j-goods[i].weight]+goods[i].value);
               }
           }

           //System.out.println(dp);
          for(int i=0;i<goods.length;i++){
              System.out.println(Arrays.toString(dp[i]));
          }
    }

    /**
     * 01背包问题
     *
     * dp[j] = max{dp[j], dp[j-weight[i]] + value[i]}
     */
    @Test
    public void test1Arr(){
        // 定义数组
        int[]dp = new int[MAX_CAPACITY+1];
        //Arrays.fill(dp,0);
        for (int i = 0;i<goods.length;i++){
            // 注意是倒序，防止重复选择！！
            for (int j=MAX_CAPACITY;j>=goods[i].weight;j--){
                dp[j] = Math.max(dp[j],dp[j-goods[i].weight]+goods[i].value);
            }
        }
        System.out.println(Arrays.toString(dp));
    }

        public boolean canPartition(int[] nums) {

            int sum = 0;
            for (int num : nums) sum += num;
            if (sum % 2 != 0) return false;
            int target = sum / 2;

            int[] dp = new int[target + 1];

            for (int i = 0; i < nums.length; i++) {
                for (int j = target; j >= nums[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
            return dp[target] == target;
        }
}
