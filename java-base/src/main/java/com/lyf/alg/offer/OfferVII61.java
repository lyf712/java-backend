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

import java.util.Arrays;

/**
 * @authorliyunfei
 * @date2023/1/8
 **/
public class OfferVII61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count0=0;
        for(int i=0;i<4;i++){
            if(nums[i]==0){
                count0++;
                continue;
            }
            if(nums[i+1]-nums[i]-1>count0||nums[i+1]-nums[i]==0){
                return false;
            }else{
                count0-=(nums[i+1]-nums[i]-1);
            }
        }
        return true;
    }
}
