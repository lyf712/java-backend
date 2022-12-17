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
 * @date2022/12/17
 **/
public class SwingSeq {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length==1) return 1;
        int curDif =0,preDif=0;
        int count=1;// 计数 波峰、波谷 ，结合波形图
        for(int i=1;i<nums.length;i++){
            curDif=nums[i]-nums[i-1];// 当前值-前一个值
            if(curDif>0&&preDif<=0 || curDif<0&&preDif>=0){
                count++;
                preDif = curDif;//产生变化才用去更换，记录变更
            }
        }
        return count;
    }
}
