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

package com.lyf.alg.carl.graph;
import java.util.Scanner;

/**
 * @author liyunfei
 **/

public class Main{

    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            int m = in.nextInt();
            String[][] chairs= new String[n][m];
            in.nextLine();
            for(int i=0;i<n;i++){
                String str = in.nextLine();
                chairs[i] = str.split("\\ ");
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    int cnt = 0;
                    visited = new boolean[n][m];
                    String tmp = chairs[i][j];
                    chairs[i][j] = "W";

                    for(int k=0;k<n;k++){
                        for(int l=0;l<m;l++){
                            if(chairs[k][l].equals("W") || visited[k][l]){
                            }else{
                                dfs(chairs, k, l);
                                cnt++;
                            }
                        }
                    }
                    chairs[i][j] = tmp;

                    System.out.print(cnt+" ");
                }
                System.out.println();
            }

        }

    }
    static boolean[][]visited;
    static void dfs(String[][]chairs,int i,int j){
        if(i<0||i>=chairs.length||j<0||j>=chairs[0].length || chairs[i][j].equals("W") || visited[i][j]==true){
            return;
        }
        visited[i][j] = true;
        dfs(chairs,i+1,j);
        dfs(chairs,i-1,j);
        dfs(chairs,i,j+1);
        dfs(chairs,i,j-1);
    }
}
