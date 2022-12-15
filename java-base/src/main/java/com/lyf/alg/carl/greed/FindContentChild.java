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

import java.util.Arrays;

/**
 * @authorliyunfei
 * @date2022/12/14
 **/
public class FindContentChild {
    public int findContentChildren(int[] g, int[] s) {
        // 基本原则，最小的胃口分配最小的兵
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0,j=0;
        int sum = 0;
        while(j<s.length&&i<g.length){
            if(g[i]<=s[j]){
                i++;
                j++;
                sum++;
            }else{
                j++;//不能满足寻找更大的饼分配
            }
        }
        return sum;
    }
}
