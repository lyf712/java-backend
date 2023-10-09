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

package com.lyf.meituan;

import java.util.Scanner;

/**
 * @author liyunfei
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            // 1,2
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = in.nextInt();
            }
            int rs = 0;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    int num = arr[i] & arr[j];
                    rs  = Math.max(rs,handle(num));
                }
            }
            System.out.println(rs);
        }
    }

    static int handle(int val){
        int rs = 0;
        int cnt = 1;
        for(int i=0;i<32;i++){
            if((cnt & val) == cnt){
                return rs;
            }
            cnt*=2;
            rs++;
        }
        return 0;
    }
}
