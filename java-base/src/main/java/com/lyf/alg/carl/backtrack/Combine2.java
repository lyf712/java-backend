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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @authorliyunfei
 * @date2022/12/14
 **/
//FIXME -去重处理，剪裁的理解
class Solution {

    List<List<Integer>> rs = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    // 单独开一个去重的

    // List<Set<Integer>> record = new ArrayList<>();
    // Set<Integer> recordSet = new HashSet<>();

    int sum = 0;
    // 无深度控制
    void backTrack(int[]candidates,int target,int startIndex,boolean[]used){
        // 此处进行剪裁
        if(sum>target){return;}
        if(sum==target){
            // 处理加入
            // List<Integer> path0 = Collections.synchronizedList(path);
            // Collections.sort(path0);
            //int sum0=0;
            //for(Integer i:path0) sum0+=i;

            if(!rs.contains(path)){//)&&sum0==target
                //record.add(new HashSet<>(recordSet));
                rs.add(new ArrayList<>(path));//new ArrayList<>(path)
            }
            return;
        }
        // 通过大小剪裁范围

        // 此处
        for(int i=startIndex;i<candidates.length && sum+candidates[i]<=target;i++){

            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
                continue;
            }

            path.add(candidates[i]);
            //recordSet.add(candidates[i]);
            sum+=candidates[i];
            // 递归深度，继续选择
            // 可重复，则继续从该处递归,若不重复，+1
            backTrack(candidates,target,i+1,used);

            //recordSet.remove((Integer)candidates[i]);
            path.removeLast();
            sum-=candidates[i];
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[]used = new boolean[candidates.length];
        Arrays.fill(used,false);
        backTrack(candidates,target,0,used);
        return rs;
    }

    // public List<List<Integer>> combinationSum2(int[] candidates, int target) {

    // }
}

public class Combine2 {
    List<List<Integer>> rs = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;
    // 无深度控制
    void backTrack(int[]candidates,int target,int startIndex){
        // 此处进行剪裁
        if(sum>target){return;}
        if(sum==target){
            rs.add(new ArrayList<>(path));
            return;
        }
        // 通过大小剪裁范围

        for(int i=startIndex;i<candidates.length;i++){
            path.add(candidates[i]);
            sum+=candidates[i];
            // 递归深度，继续选择
            // 可重复，则继续从该处递归,若不重复，+1
            backTrack(candidates,target,i);

            path.removeLast();
            sum-=candidates[i];
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates,target,0);
        return rs;
    }
}
