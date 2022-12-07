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

package com.lyf.alg.carl.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 利用hash集合判断是否有重复（无重复特性），解决判断循环，终止条件
 *
 * @authorliyunfei
 * @date2022/12/7
 **/
public class IsHappy {
    public boolean isHappy(int n) {
        // 判断有无循环，有循环则false,无循环则--递进
        Set<Integer> set = new HashSet<>();
        //set.add(n);
        while(n!=1){
            set.add(n);
            n = compute(n);
            if(set.contains(n)){return false;}
        }
        return true;
    }
    int compute(int n){
        int sum = 0;
        while(n!=0){
            sum+=(n%10)*(n%10);
            n/=10;
        }
        return sum;
    }
}
