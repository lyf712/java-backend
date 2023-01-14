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

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * fixme:想复杂了，单纯的入度问题
 *
 * @author liyunfei
 **/
public class LC1557 {


//    boolean[]hash = new boolean[n];//判断是否有入度
//           for(List<Integer> edge:edges){
//        hash[edge.get(1)]=true;
//    }
//    Set<Integer> ansSet = new HashSet<>();
//
//           for(List<Integer> edge:edges){
//        if(!hash[edge.get(0)] ){
//            ansSet.add(edge.get(0));
//        }
//    }
//           return ansSet.stream().toList();

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // 图的连通性，连通图的数量（岛屿的shul）
        // 找到没有前置的点进行dfs

        List<Integer> rs = new ArrayList<>(n);
        boolean[]record = new boolean[n];//默认未遍历
        for(int i=0;i<n;i++){//有序的编号
            if(isPreNode(i,edges)==false && record[i]==false){// 进行dfs
                record[i]=true;
                rs.add(i);
                //dfs()
                dfs(i,edges,record);

            }
        }

        return rs;
    }
    // 判断是否有前置节点
    boolean isPreNode(int no,List<List<Integer>> edges){
        for(List<Integer> edge:edges){
            if(edge.get(1)==no){return true;}
        }
        return false;
    }
    void dfs(int no,List<List<Integer>> edges,boolean[]record){

        //  HashSet<Integer> set = new HashSet<>();
        //  set.add(i);
        for(List<Integer> edge:edges){
            if(edge.get(0)==no && record[edge.get(1)] == false ){ //set.contains(edge.get(0))
                //set.add(edge.get(1));
                record[edge.get(1)]=true;
                dfs(edge.get(1),edges,record);
            }
        }

    }
    @Test
    public void testCollectionTraverse(){
        //new ArrayList<>()
        new HashSet<>(10).stream().toList();
    }

}
