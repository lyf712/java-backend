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

/**
 * @author liyunfei
 **/
public class LC2299 {
    public boolean strongPasswordCheckerII(String password) {
        if(password.length()<8) return false;
        boolean[]flag = new boolean[4];// 小写、大写、数字、特殊字符
        for(int i=0;i<password.length();i++){
            char char0 = password.charAt(i);
            if(i+1<password.length() && char0==password.charAt(i+1)){
                return false;
            }
            if(char0<='z'&&char0>='a'){
                flag[0]=true;
            }else if(char0<='Z'&&char0>='A'){
                flag[1]=true;
            }else if(char0>='0'&&char0<='9'){
                flag[2]=true;
            }else if("!@#$%^&*()-+".contains(char0+"")){
                flag[3]=true;
            }
        }
        return flag[0] && flag[1] && flag[2] && flag[3];
    }
}
