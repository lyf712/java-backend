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
import java.util.LinkedList;
import java.util.List;

/**
 * @authorliyunfei
 * @date2022/12/20
 **/
public class SubSet {
    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums,0);
        return rs;
    }
    List<List<Integer>> rs = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    void backTrack(int[]nums,int index){
        rs.add(new ArrayList<>(path));//记录下所有的节点
        //  if(index>=nums.length) { // --记录叶子节点

        //      return;
        //  }
        for(int i=index;i<nums.length;i++){// i的开始位置决定是否重复选择
            path.add(nums[i]);
            backTrack(nums,i+1);// --
            path.removeLast();
        }
    }





}
