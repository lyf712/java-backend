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

import java.util.*;

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




    /**
     * 回溯算法：dfs深度搜索，符号则，加入，不符合进行dfs
     */
    List<List<String>> rs = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public String[][] partition(String s) {
        dfs(0,s);
        String[][]rs0 = new String[rs.size()][];
        for(int i=0;i<rs.size();i++){
            rs0[i] = new String[rs.get(i).size()];
            for(int j=0;j<rs.get(i).size();j++){
                rs0[i][j]=rs.get(i).get(j);
            }
        }
        return rs0;//rs0;
    }
    void dfs(int index,String s){
        if(index>=s.length()){
            rs.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();i++){
            // 选择从哪里切
            if(!validate(s.substring(index,i+1))){
                //path.addLast()
                continue;
            }
            path.addLast(s.substring(index,i+1));
            dfs(i+1,s);
            path.removeLast();
        }
    }

    boolean validate(String s){
        int left = 0,right = s.length()-1;
        while(left<=right){
            if(s.charAt(left++)!=s.charAt(right--)){
                return false;
            }
        }
        return true;
    }

    // 二分图
    int[]record;// -1,0,1标记染色
    boolean valid=true;
    public boolean isBipartite(int[][] graph) {
        // DFS + 染色处理
        record = new int[graph.length];
        for(int i=0;i<graph.length && valid;i++){
            if(record[i]==0){// 未标记
                record[i] = 1;
                dfs(i,graph);
            }
        }
        return valid;
    }
    void dfs(int indexNo,int[][]graph){
        for(int neibor:graph[indexNo]){
            if(record[neibor]==0){// 临边未染色则继续dfs
                record[neibor] = (-1)*record[indexNo];
                dfs(neibor,graph);
            }else if(record[neibor]==record[indexNo]){//染色则判断是否冲突
                valid=false;
                return ;
            }
        }
    }


}
