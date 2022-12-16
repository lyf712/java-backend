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

package com.lyf.alg.carl.math;

/**
 * @authorliyunfei
 * @date2022/12/16
 **/
public class EveryDay {
    // 注意Int，long的取值范围；类型转换
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for(int val:nums) sum+=val;
        long distance =Math.abs(goal - sum);//统一整数方便处理
        return (int)Math.ceil((double)distance/limit);
    }
}
