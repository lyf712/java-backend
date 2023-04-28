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

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author liyunfei
 **/
public class Test2 {
    final static int N = 5000*1000;
    static boolean[]prime = new boolean[N];
    static void init(){
        //Arrays.fill(prime,false);
        for(int i=2;i*i<N;i++){
            if(!prime[i]){
                for(int j=2*i;j<N;j+=i){
                    prime[j] = true;
                }
            }
            //System.out.println(i+":"+prime[i]);
        }
        //System.out.print("ok");
    }
    public static void main(String[] args) {
        init();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int n = in.nextInt(),k = in.nextInt();
            int[]arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = in.nextInt();
            }
            dfs(arr,0,k);
        }
    }
    static int sum = 0;
    static LinkedList list = new LinkedList();
    static void dfs(int[]arr,int index,int k){
        if(list.size()==k){
            System.out.println(list);
            System.out.println(sum);
            if (!prime[sum]){
                System.out.println("yes:"+sum);
            }
            return;
        }
        for(int i=index;i<arr.length;i++){
            list.add(arr[i]);
            sum+=arr[i];
            dfs(arr,i+1,k);
            sum-=arr[i];
            list.removeLast();
        }
    }

}
