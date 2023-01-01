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

package com.lyf.alg.leetcode.str;

import java.util.HashSet;
import java.util.Set;

/**
 * @authorliyunfei
 * @date2023/1/1
 **/
public class RepeatedCh {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            //
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
            }else{
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
