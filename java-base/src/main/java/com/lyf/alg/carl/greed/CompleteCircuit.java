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

/**
 * @authorliyunfei
 * @date2023/1/2
 **/
public class CompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //局部贪心
        int totalSum =0,curSum =0;
        int start = 0;// 最开始标记从0开始
        for(int i=0;i<gas.length;i++){
            int rest = gas[i] - cost[i];
            curSum+=rest;
            totalSum+=rest;
            if(curSum<0){//则说明不能从该处开始，只能试探下一个下标
                curSum=0;
                start = i+1;
            }
        }
        if(totalSum<0)return -1;
        // 总计数大于0，说明会有剩余油量
        return start;
    }
}
