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

import java.util.HashMap;
import java.util.Map;

/**
 * @authorliyunfei
 * @date2022/12/15
 **/
public class FibciProblem {
    public int fib(int n) {
        return recursion2(n);
    }
    private int dpWay(int n){
        int[]dp = new int[31];
        dp[0]= 0;
        dp[1]= 1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];//dp公式
        }
        return dp[n];//若未知，可设置为list动态链表
    }


    private int recursion(int n){
        if(n==0||n==1)return n;
        else return recursion(n-1)+recursion(n-2);// 重叠子问题
    }

    // 打卡记录
    static Map<Integer,Integer> record = new HashMap<>();// 直接list也行
    // static{
    //     record.pu
    // }
    private int recursion2(int n){
        if(n==0||n==1)return n;
        else{
            Integer val1 = record.get(n-1);
            Integer val2 = record.get(n-2);
            if(val1==null){
                val1 = recursion2(n-1);
                record.put(n-1,val1);
            }
            if(val2==null){
                val2 = recursion2(n-2);
                record.put(n-2,val2);
            }
            return val1+val2;
        }
    }
}
