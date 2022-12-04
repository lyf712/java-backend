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

package com.lyf.alg.carl.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/minimum-window-substring/submissions/
 *
 * @authorliyunfei
 * @date2022/12/4
 **/
public class SwipeWin {
    public static void main(String[] args) {
        //"ADOBECODEBANC"
        //"ABC"
        minWindow("ADOBECODEBANC","ABC");
    }
    public static String minWindow(String s, String t) {
        // 窗口一直增大，窗口缩小的条件：覆盖所有（如何判断，index计数判断，map记录各个字符的情况，方便
        // 窗口移动时的处理（处理时，需要考虑 字符是否在set内，再判断index的情况是否改变））
        int left=0,right=0;
        int rsLeft=0,rsRight=Integer.MAX_VALUE;//要考虑数量
        Map<Character,Integer> recordT = new HashMap<>();
        for(int i=0;i<t.length();i++){
            Character ch = t.charAt(i);
            Integer num = recordT.getOrDefault(ch,0)+1;
            recordT.put(ch,num);// putOr.?
        }

        int coverSize = 0;// 覆盖数，当覆盖数==t.length()则需要缩小窗口；当新增的char 包含在 t中 && 已有的该char数少于--
        Map<Character,Integer> recordS = new HashMap<>();
        while(right<s.length()){
            // 滑动
            Character ch = s.charAt(right);
            // 查看子串的数量
            Integer tNum = recordT.getOrDefault(ch,0);
            // 窗口内该char已有的数量
            Integer sNum = recordS.getOrDefault(ch,0);
            if(sNum<tNum){
                coverSize++;// 覆盖数加一
            }
            recordS.put(ch,sNum+1);

            while(coverSize==t.length()){// 缩小窗口
                if(right-left<rsRight-rsLeft){
                    rsLeft = left;
                    rsRight = right;// 更新值
                }
                Character ch0 = s.charAt(left);
                // 查看子串的数量
                Integer tNum0 = recordT.getOrDefault(ch0,0);
                // 窗口内该char已有的数量
                Integer sNum0 = recordS.getOrDefault(ch0,0);  // 必然存在！
                if(tNum!=0&&sNum0<=tNum0){
                    coverSize--;

                }
                recordS.put(ch0,sNum0-1);
                left++;
            }
            right++;
        }

        if(rsRight==Integer.MAX_VALUE)
            return "";
        else
            return s.substring(rsLeft,rsRight+1);
    }
}
