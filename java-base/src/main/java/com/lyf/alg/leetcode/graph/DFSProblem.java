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

package com.lyf.alg.leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liyunfei
 **/
public class DFSProblem {


    // 岛屿数量
    public int solve (char[][] grid) {
        // write code here
        int res = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    void dfs(char[][]grid,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
    }

    // 省份数量
    int[]visited;
    Map<Integer, Set<Integer>> neibors;
    public int findCircleNum(int[][] isConnected) {
        // map记录临边，dfs/bfs遍历 记录标记
        visited = new int[isConnected.length];
        neibors = new HashMap<>();
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(j!=i && isConnected[i][j]==1){
                    Set<Integer> set = neibors.getOrDefault(i,new HashSet<>());
                    set.add(j);
                    neibors.put(i,set);
                }
            }
        }
        int res = 0;
        for(int i=0;i<isConnected.length;i++){
            if(visited[i]==0){
                res++;
                dfs(i);
            }
        }
        return res;
    }
    void dfs(int i){
        if(i<0||i>=visited.length||visited[i]==1){
            return;
        }
        visited[i]=1;
        for(Integer neibor:neibors.getOrDefault(i,new HashSet<>())){
            dfs(neibor);
        }
    }





}
