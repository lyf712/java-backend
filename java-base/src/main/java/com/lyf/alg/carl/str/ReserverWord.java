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

package com.lyf.alg.carl.str;

/**
 * @authorliyunfei
 * @date2022/12/7
 **/
public class ReserverWord {
    public String reverseWords(String s) {

        //String[]str = s.split("\\ ");
        //String rs = "";
        //for(int i=str.length-1;i>=0;i--){
        //     rs = str[i]+" ";
        //}
        //return rs.substring(0,rs.length()-2);
        String rs ="";
        String tmp = "";
        boolean flag = false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                if(flag){
                    rs = tmp + " " + rs ;
                    tmp = "";
                    flag = false;
                }
            }else{
                tmp = tmp + s.charAt(i);
                flag = true;
            }
        }
        if(flag)
            rs = tmp + " " + rs ;
        return rs.substring(0,rs.length()-1);
    }
}
