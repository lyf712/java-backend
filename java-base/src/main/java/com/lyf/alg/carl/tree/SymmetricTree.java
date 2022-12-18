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

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @authorliyunfei
 * @date2022/12/18
 **/
public class SymmetricTree {
    private class TreeNode{int val;TreeNode left,right;}
    // 递归办法
    private boolean isSymmetricHelper(TreeNode left,TreeNode right){
        // 判断 第一层和第二层，递归终止条件
        if(left==null && right==null) return true;
        if(left==null || right==null || left.val!=right.val) return false;

        // 递归 第三层
        return isSymmetricHelper(left.left,right.right) && isSymmetricHelper(left.right,right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return isSymmetricHelper(root.left,root.right);
    }

    // 迭代办法
    public boolean isSymmetric2(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        boolean flag = true;
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left==null&&right==null) continue;//return true;,此处只能说明该子树为对称，并不能代表全局
            if(left==null || right==null || left.val!=right.val){
                return false;
            }

            q.offer(left.left);
            q.offer(right.right);
            q.offer(left.right);
            q.offer(right.left);
        }
        return flag;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if(p!=null&&q!=null){
            if(p.val!=q.val) return false;
            boolean left = isSameTree(p.left,q.left);
            boolean right = isSameTree(p.right,q.right);
            return left&&right;
        }
        return false;
    }


    // TODO -- 三种解法 KMP、树哈希
    // https://leetcode.cn/problems/subtree-of-another-tree/solution/ling-yi-ge-shu-de-zi-shu-by-leetcode-solution/
    boolean flag = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 遍历 + 相同的树
        traverse(root,subRoot);
        return flag;

    }
    void traverse(TreeNode root,TreeNode sub){
        if(root!=null){
            if(root.val==sub.val){
                boolean cmp =  isSameTree(root,sub);
                if(cmp==true) {
                    flag = true;
                    return;
                }
            }
            traverse(root.left,sub);
            traverse(root.right,sub);
        }
    }

    @Test
    public void test(){
         TreeNode root = new TreeNode();
         root.val = 1;
         TreeNode left = new TreeNode();
         left.val = 1;
         root.left = left;

         TreeNode sub = new TreeNode();
         sub.val = 1;

         System.out.println(isSubtree(root,sub));
    }
}
