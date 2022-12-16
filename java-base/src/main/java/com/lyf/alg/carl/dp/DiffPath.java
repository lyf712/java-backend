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
 * @date2022/12/16
 **/
public class DiffPath {
    @Test
    public void test(){
        uniquePaths(3,7);
    }
    private int uniquePaths(int m, int n) {
        if(m<=1||n<=1) return 1;
        int[][]dp = new int[m][n];
        dp[0][0]=0;
//        dp[0][1]=1;
//        dp[1][0]=1; FIXME 注意赋值完全
        Arrays.fill(dp[0],1);
        //Arrays.fill(dp[][0],1);
        for(int i=0;i<m;i++){dp[i][0]=1;}
        //dp[1][1]=2;
        //DP方程： dp[x][y] = dp[x-1][y] + dp[x][y-1];
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];// 做选择，只有两种选择，考虑多种选择呢，对比回溯的选择，贪心的选择
                // 全局最优
            }
        }
        //dp[1][1]=2;
        //DP方程： dp[x][y] = dp[x-1][y] + dp[x][y-1];
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];// 做选择，只有两种选择，考虑多种选择呢，对比回溯的选择，贪心的选择
                // 全局最优
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 处理DP时考虑一下障碍物
        int m = obstacleGrid.length,n=obstacleGrid[0].length;
        int[][]dp = new int[m][n];
        // 处理边界
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]==0){
                dp[0][i] = 1;
            }else{
                //int j=i;
                while(i<n)dp[0][i++]=0;
                //break;
            }
        }
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==0){
                dp[i][0] = 1;
            }else{
                while(i<m)dp[i++][0]=0;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                //判断左右边的情况
                if(obstacleGrid[i][j]==0){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];//有障碍的已经设置为0，无需再判断考虑？
                }else{
                    dp[i][j]=0;
                }
            }
        }
        return dp[m-1][n-1];

    }
}
