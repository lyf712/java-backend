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

package com.lyf.alg.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @authorliyunfei
 * @date2023/1/5
 **/
public class OfferVII34 {
    List<List<Integer>> rs = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int pathSum = 0;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        // 回溯
        traverse(root,target);
        return rs;
    }
    void traverse(TreeNode root,int target){
        if(root!=null){
            path.add(root.val);
            pathSum+=root.val;
            if(pathSum==target&&root.left==null&&root.right==null){rs.add(new ArrayList<>(path));}
            if(root.left!=null) traverse(root.left,target);
            if(root.right!=null) traverse(root.right,target);
            path.removeLast();
            pathSum-=root.val;
        }
    }
}
