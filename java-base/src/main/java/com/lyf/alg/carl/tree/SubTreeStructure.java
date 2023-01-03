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

/**
 * @authorliyunfei
 * @date2023/1/3
 **/
public class SubTreeStructure {
    private class TreeNode{int val;
        TreeNode left,right;}
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 寻找到开始比较的根节点
        // 然后进行B为主的遍历比较
        if(B==null) return false;
        //TreeNode sameRoot = findRoot(A,B);
        //if(sameRoot==null) return false;
        return traverseA(A,B);//compare(sameRoot,B);
    }

    boolean traverseA(TreeNode A,TreeNode B){
        if(A!=null){
            if(A.val==B.val&&compare(A,B))
                return true;
            boolean left = traverseA(A.left,B);
            boolean right = traverseA(A.right,B);
            return left||right;
        }
        return false;
    }

    boolean compare(TreeNode A,TreeNode B){
        if(B!=null){
            if(A==null||A.val!=B.val) return false;
            boolean left = compare(A.left,B.left);
            boolean right = compare(A.right,B.right);
            return left&&right;
        }
        return true;
    }
    // 节点可能存在多个相同的
    // TreeNode findRoot(TreeNode A,TreeNode B){
    //        if(A!=null){
    //           if(A.val==B.val){
    //               return A;
    //           }
    //           TreeNode left = findRoot(A.left,B);
    //           TreeNode right = findRoot(A.right,B);
    //           if(left!=null) return left;
    //           if(right!=null) return right;
    //        }
    //        return null;
    // }
}
