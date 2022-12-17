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
 * @date2022/12/17
 **/
public class IntegerBreak {
    public int integerBreak(int n) {
        /**
         分析：
         1 ： 0
         2 ： 1 + 1 = 1
         3 ： 1 + 2 = 2
         4 ： 4
         // 4之后由 dp[i]决定更大 之前有 本身决定
         5 ： 6
         6 ： 9
         7 ： 12
         max( i * (n-i) , dp[i] * dp[n-i] ,i * dp[n-i] )
         */
        if(n<=3)return n-1;
        int[]dp = new int[n+1];//方便下标对应
        //dp[1]=0;
        dp[2]=1;
        dp[3]=2;
        int max = 0;
        for(int i=4;i<=n;i++){
            // 可简化---  dp[i] = max(dp[i], max((i - j) * j, dp[i - j] * j));
            for(int j=2;j<i/2+1;j++){////避免重复计算
                int other = i-j;
                if(j<=4){
                    // 本身决定
                    if(other<=4){
                        if(j*other>max) max = j*other;
                    }else{
                        if(j*dp[other]>max) max = j*dp[other];
                    }
                }else{
                    if(other<=4){
                        if(dp[j]*other>max) max = dp[j]*other;
                    }else{
                        if(dp[j]*dp[other]>max) max = dp[j]*dp[other];
                    }
                }
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
