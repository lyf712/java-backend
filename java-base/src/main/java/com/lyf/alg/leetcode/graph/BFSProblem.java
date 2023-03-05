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
public class BFSProblem {
    // 课程表
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 两种思路：（1）BFS，采用入度表的方式去剔除 （2）DFS判断有无环
        int[]indegrees = new int[numCourses];
        List<List<Integer>> out = new ArrayList<>();// map
        for(int i=0;i<numCourses;i++){
            out.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            indegrees[pre[0]]++;// 入度情况
            out.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            numCourses--;
            indegrees[queue.peek()]=-1;
            for(int neibor:out.get(queue.poll()) ){
                if(--indegrees[neibor]==0){
                    queue.offer(neibor);
                }
            }
        }
        return numCourses==0;
    }

    // 课程表II
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // BFS搜索记录
        int[]indegrees = new int[numCourses];
        Map<Integer, Set<Integer>> neibors  = new HashMap<>();
        for(int[] pre:prerequisites){
            indegrees[pre[0]]++;
            Set<Integer> set = neibors.getOrDefault(pre[1],new HashSet<>());
            set.add(pre[0]);
            neibors.put(pre[1],set);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                queue.offer(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            numCourses--;
            indegrees[queue.peek()]=-1;
            res.add(queue.peek());
            for(Integer neibor:neibors.getOrDefault(queue.poll(),new HashSet<Integer>())){
                if(--indegrees[neibor]==0){
                    queue.offer(neibor);
                }
            }
        }
        if(numCourses==0){
            int[]resArr = new int[res.size()];
            for(int i=0;i<res.size();i++){
                resArr[i] = res.get(i);
            }
            return resArr;
        }else{
            return new int[0];
        }
    }

}
