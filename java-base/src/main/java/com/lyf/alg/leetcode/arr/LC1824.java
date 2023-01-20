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

package com.lyf.alg.leetcode.arr;

/**
 * @author liyunfei
 **/
public class LC1824 {
    public int minSideJumps(int[] obstacles) {
        int count = 0;
        int s = 2;
        for(int i=0;i<obstacles.length-1;i++){
            if(obstacles[i+1]==s){
                count++;
                // 更换赛道
                int j = i;
                boolean flag = true;
                boolean changeFlag = false;
                while(j<obstacles.length){
                    if(obstacles[j]==0){
                        j++;
                        continue;
                    }
                    if(obstacles[j]!=s){
                        for(int k=1;k<=3;k++){
                            if(k!=obstacles[j]&&k!=s){
                                s=k;
                                //System.out.println(s);
                                flag = false;
                                changeFlag = true;
                                break;
                            }
                        }
                    }
                    j++;
                    if(flag==false) break;
                }
                if(!changeFlag){
                    for(int k=1;k<=3;k++){
                        if(k!=s){
                            s = k;
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }
}
