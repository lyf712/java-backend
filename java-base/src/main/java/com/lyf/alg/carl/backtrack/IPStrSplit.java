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

package com.lyf.alg.carl.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * IP地址合法分割：https://leetcode.cn/problems/restore-ip-addresses/submissions/
 * 分割回文串：https://leetcode.cn/problems/palindrome-partitioning/
 * ——>组合问题的变式
 * ——>优化：考虑如何去缩小范围剪裁
 * @authorliyunfei
 * @date2022/12/15
 **/
public class IPStrSplit {
    List<String> rs = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();// -> String for--
    void backTrack(String s,int startIndex){
        if(startIndex>=s.length()&&path.size()==4){
            //
            rs.add(path.get(0)+"."+path.get(1)+"."+path.get(2)+"."+path.get(3));
            return;
        }
        for(int i=startIndex;i<s.length();i++){
            if(isValid(s.substring(startIndex,i+1))){path.add(s.substring(startIndex,i+1));}
            else continue;
            backTrack(s,i+1);
            path.removeLast();
        }
    }
    boolean isValid(String s){
        if(s.length()>1&&s.startsWith("0")) return false;
        if(s.length()>4)return false;
        Integer val = Integer.valueOf(s);
        return 0<=val&&val<=255;
    }
    public List<String> restoreIpAddresses(String s) {
        backTrack(s,0);
        return rs;
    }
}
