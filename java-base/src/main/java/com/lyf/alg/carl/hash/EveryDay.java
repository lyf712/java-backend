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

package com.lyf.alg.carl.hash;

/**
 * every day
 * @authorliyunfei
 * @date2022/12/13
 **/
public class EveryDay {
    //1832. 判断句子是否为全字母句
    public boolean checkIfPangram(String sentence) {
        if(sentence.length()<26)return false;
        int[] record =new int[26];
        for(int i=0;i<sentence.length();i++){
            record[sentence.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(record[i]==0) return false;
        }
        return true;
    }
}
