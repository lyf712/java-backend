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

package com.lyf.alg.oi.dp;

import java.util.Scanner;

/**
 * @author liyunfei
 **/
public class LCS {
    static int[][]dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            dp = new int[str1.length()+1][str2.length()+1];
            lcs(str1,str2);
            printDp(str1,str2);
            System.out.println(getStr2(str1,str2));
            printDp(str1,str2);
        }
    }
    static void printDp(String s1,String s2){
        System.out.print("    ");
        for(int j=0;j<dp[0].length-1;j++){
            System.out.print(s2.charAt(j)+ " ");
        }
        System.out.println();
        for(int i=0;i<dp.length;i++){
            if(i>0){
                System.out.print(s1.charAt(i-1)+" ");
            }
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }
    }
    static void lcs(String s1,String s2){
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                   if(s1.charAt(i-1)==s2.charAt(j-1)){
                       dp[i][j] = dp[i-1][j-1]+1;
                   }else{
                       dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                   }
            }
        }

        // 获取String
    }
    static String getStr(String s1,String s2){
        StringBuffer stringBuffer = new StringBuffer();
        int i=s1.length(),j=s2.length();
        while(i>0){
            //dp[i][j] = -1;
            if(dp[i][j] - dp[i-1][j] == 0){
                //stringBuffer.append(s1.charAt(i));
                //dp[i][j] = -1;
                i--;
            }else{
                //dp[i][j] = -1;
                stringBuffer.append(s1.charAt(i-1));
                i--;
                j--;
            }
        }
        return stringBuffer.reverse().toString();
    }


    static String getStr2(String s1,String s2){
        StringBuffer stringBuffer = new StringBuffer();
        int i=s1.length(),j=s2.length();
        while(i>0){
            //dp[i][j] = -1;
            if(dp[i][j] - dp[i-1][j-1] == 1){
                stringBuffer.append(s1.charAt(i-1));
                //dp[i][j] = -1;
                i--;
                j--;
            }else{
                //dp[i][j] = -1;
                ///stringBuffer.append(s1.charAt(i-1));
                i--;
                //j--;
            }
        }
        return stringBuffer.reverse().toString();
    }

}
