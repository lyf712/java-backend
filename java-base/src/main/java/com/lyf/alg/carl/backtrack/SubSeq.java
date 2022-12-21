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
 * @date2022/12/21
 **/
public class SubSeq {
    List<List<Integer>> rs = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int[]used=null;
    public List<List<Integer>> findSubsequences(int[] nums) {
        used=new int[nums.length];
        backTrack(0,nums);
        return rs;
    }
    private void backTrack(int startIndex,int[]nums){
        if(path.size()>=2)//&&!rs.contains(path),去重处理
            rs.add(new ArrayList<>(path));
        // if(startIndex>=nums.length){
        //     return;
        // }
        int[]used = new int[201];
        for(int i=startIndex;i<nums.length;i++){
            // boolean flag = false;
            // if(path.size()==0||path.getLast()<=nums[i]){
            //         path.add(nums[i]);
            //         flag = true;
            // }
            // 不满足的则不考虑，直接continue
            if (!path.isEmpty() && nums[i] < path.getLast() ||
                    (used[nums[i] + 100] == 1)) continue;

            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            backTrack(i+1,nums);
            path.removeLast();
            //path.remove(path.size()-1);
            // if(path.size()!=0&&flag == true) {
            //         path.removeLast();
            //         flag = false;
            // }

        }

    }
}
