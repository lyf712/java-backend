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

package com.lyf.alg.offer;

/**
 * @authorliyunfei
 * @date2023/1/5
 **/
public class OfferVII39 {
    public int majorityElement(int[] nums) {
        // 投票计数
        int x = 0,votes=0;
        for(int num:nums){
            if(votes==0) x = num;// 投票为0了，则可重新开始投票，后面的数任保持--

            if(x==num){//是过半数则投票，否则--
                votes++;
            }else{
                votes--;
            }
        }
        // ---若不说一定存在，需要去验证
        return x;
    }
}
