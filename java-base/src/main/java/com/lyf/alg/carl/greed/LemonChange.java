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
public class LemonChange {
    public boolean lemonadeChange(int[] bills) {
        // 10 则 1个5；20 则3个5，或一个10,2个5
        // 对于20的尽可能找零10，再用5，因为10可以两个5来凑

        int n5 = 0,n10=0;//,n20=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5) n5++;
            else if(bills[i]==10){
                if(n5<=0) return false;
                n10++;
                n5--;
            }else if(bills[i]==20){
                if(n5>=1 && n10>=1){
                    //n20++;
                    n10--;
                    n5--;
                }else if(n5>=3){
                    n5-=3;
                    //n20++;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
