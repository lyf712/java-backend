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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @authorliyunfei
 * @date2022/12/14
 **/
public class PhoneNumerCompine {
    // 映射 数字 - 字母
    Map<Character,String> hash = new HashMap<>();
    List<String> rs = new ArrayList<>();
    String path = "";
    void backTrack(String digits,int index){
        if(path.length()==digits.length()){
            rs.add(path);
            return;
        }
        if(index>digits.length()-1){return;}
        String chooseSet = (String)hash.get(digits.charAt(index));
        for(int i=0;i<chooseSet.length();i++){
            path+=chooseSet.charAt(i);
            backTrack(digits,index+1);
            path=path.substring(0,path.length()-1);// 退一步；；思考常量池的情况，
        }

    }
    public List<String> letterCombinations(String digits) {
        // ?暴力遍历?-
        if(digits.isEmpty()){return rs;}
        String numbers = "23456789";
        String[]strs = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for(int i=0;i<8;i++){
            hash.put(numbers.charAt(i),strs[i]);
        }
        backTrack(digits,0);
        return rs;

    }
}
