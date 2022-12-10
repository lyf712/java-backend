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

package com.lyf.alg.carl.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @authorliyunfei
 * @date2022/12/10
 **/
public class NodeAnalysis {

    boolean flag = false;
    //https://leetcode.cn/problems/path-sum/submissions/ [1,2]用例
    public boolean hasPathSum(TreeLevelTraverse.TreeNode root, int targetSum) {
        recurstion(root,0,targetSum);
        return flag;
    }
    void recurstion(TreeLevelTraverse.TreeNode root, int cur, int target){
        if(root!=null){
            cur+=root.val;
            //if(cur==target){flag=true;return;}
            if(root.left!=null) recurstion(root.left,cur,target);
            //cur-=root.val;//回退
            if(root.right!=null) recurstion(root.right,cur,target);
            // 需要到叶子结点
            // 理解递归回退过程，理论无需加后面的判断？？ 到该步骤 left,right必然为null?
            // FIXME  有回退过程，应该在回退过程中--
            if(cur==target && root.left==null && root.right==null){flag=true;return;}
            cur-=root.val;//回退到上一层
        }
    }


    List<List<Integer>>  rs= new ArrayList<>();
    public List<List<Integer>> pathSum(TreeLevelTraverse.TreeNode root, int targetSum) {
        List<Integer> record = new LinkedList<>();
        recursion(root,record,0,targetSum);
        return rs;
    }
    // sum 减少record list的计算复杂度
    void recursion(TreeLevelTraverse.TreeNode root, List<Integer> record, int sum, int targetSum){
        if(root!=null){
            sum+=root.val;
            record.add(root.val);
            if(root.left!=null)recursion(root.left,record,sum,targetSum);
            if(root.right!=null)recursion(root.right,record,sum,targetSum);
            if(sum==targetSum && root.left==null && root.right == null){
                rs.add(new LinkedList<>(record));//注意此处的处理
                //  this();
                //        addAll(c);
            }
            //回退
            record.remove(record.size()-1);
            sum-=root.val;
        }
    }
}
