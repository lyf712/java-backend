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
 * @author liyunfei
 **/
public class LC738 {
    public int monotoneIncreasingDigits(int n) {
        //    for(int i=n;i>=0;i--){
        //       if(check(i)) return i;
        //    }
        //    return -1;

        //    String num = n+"";
        //    for(int i=0;i<num.length()-1;i++){
        //           if(charAt(i+1)>=charAt(i)) {
        //                continue;//符合单调递增
        //           } else {
        //                // 开始调整
        //                num.replace()
        //           }
        //    }

        //  char[]chars = String.valueOf(n).toCharArray();
        //  boolean flag = false;
        //  for(int i=0;i<chars.length-1;i++){
        //        if(chars[i+1]>=chars[i]) {
        //            continue;
        //        }else{
        //            chars[i+1] = '9';
        //            // 调整 0-i间的情况
        //            // i之前不可能为0，首字母不能为 0，因此都是 至少>=1的数
        //            int j = i;
        //            chars[j]--;//char类型--可以吗？？
        //            while(j>0){
        //                 if(chars[j-1]<=chars[j]) break;
        //                 else{
        //                    chars[j]='9';
        //                    chars[j-1]--;//=chars[j];
        //                 }
        //                 j--;
        //            }
        //        }
        //  }

        //  int rs = 0;
        //  int bit = 1;
        //  for(int i=chars.length-1;i>=0;i--){
        //      rs+=((chars[i]-'0')*bit);
        //      bit*=10;
        //  }

        //  return rs;


        char[]chars = String.valueOf(n).toCharArray();
        int start = chars.length;
        for(int i=chars.length-2;i>=0;i--){
            if(chars[i]>chars[i+1]){
                chars[i]--;
                start = i+1;
            }
        }
        for(int i=start;i<chars.length;i++){
            chars[i]='9';
        }
        return Integer.parseInt(String.valueOf(chars));


        // n^2 - n=位数
    }
    // ///777616726 超时
    // boolean check(int n){
    //        String num = n+"";
    //        for(int i=0;i<num.length()-1;i++){
    //            if(num.charAt(i)>num.charAt(i+1)) return false;
    //        }
    //        return true;
    // }
}
