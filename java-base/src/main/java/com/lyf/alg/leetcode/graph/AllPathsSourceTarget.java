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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @authorliyunfei
 * @date2022/12/31
 **/
public class AllPathsSourceTarget {
    List<List<Integer>> rs = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 深搜 回溯（基于二维数组的图DFS）
        path.add(0);
        dfs(graph,0);
        return rs;
    }

    // index节点的位置

    private void dfs(int[][]graph,int index){
        // if(index>=graph.length){
        // index 肯定是合法的
        if(path.size()>0&&path.getLast()==graph.length-1){
            rs.add(new ArrayList<>(path));
            return;
        }
        // }
        for(int i=0;i<graph[index].length;i++){
            path.add(graph[index][i]);
            dfs(graph,graph[index][i]);
            path.removeLast();
        }
    }
}
