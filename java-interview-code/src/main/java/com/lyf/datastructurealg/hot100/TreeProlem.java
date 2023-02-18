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

package com.lyf.datastructurealg.hot100;

/**
 * @author liyunfei
 **/
public class TreeProlem {
    class TreeNode{TreeNode left,right;}
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        //    if(root==null || root.left==null && root.right==null){
        //        return 0;
        //    }
        height(root);
        return max;//height(root.right)+height(root.left);
    }
    // private void traverse(TreeNode root){
    //        if(root!=null){
    //            traverse(root.left);
    //            int left = height(root.left);
    //            int right = height(root.right);
    //            if(left+right>max){
    //                 max = left+right;
    //            }
    //            traverse(root.right);
    //        }
    // }
    private int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if(left+right>max){
            max = left+right;
        }
        return Math.max(left+1,right+1);
    }
}
