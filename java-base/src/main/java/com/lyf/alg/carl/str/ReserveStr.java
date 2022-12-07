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
public class ReserveStr {
    public String reverseStr(String s, int k) {
        int len = s.length();
        StringBuffer sb  = new StringBuffer();
        for(int i=0;i<len;i++){
            if(len-i>=2*k){// 大于2k
                int j = i+k-1;
                while(j>=i){
                    sb.append(s.charAt(j--));
                }

                j = i+k;
                i = i+(2*k);// 下次的i
                while(j<i){
                    sb.append(s.charAt(j++));
                }
                i--;
            }else if(len-i>=k&&len-i<2*k){
                int j = i+k-1;
                while(j>=i){
                    sb.append(s.charAt(j--));
                }

                j = i+k;
                i = len;//i+(2*k);// 下次的i
                while(j<i){
                    sb.append(s.charAt(j++));
                }
                break;
            }else{
                // 小于则全部反转
                int j = len-1;
                while(j>=i){
                    sb.append(s.charAt(j--));
                }
                break;
            }
        }
        return sb.toString();
    }
}
