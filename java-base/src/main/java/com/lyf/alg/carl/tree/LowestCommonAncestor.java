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
 * @date2022/12/23
 **/
public class LowestCommonAncestor {
    private class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 回溯思想；后序遍历-天然回溯
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件，寻找q,p（q,p非重复）
        if (root == q || root == p || root == null) return root;
        // 递归
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 处理操作
        // p,q整好在--左右子节点
        if (left != null & right != null) return root;
        // 最小父子节点在右边 （是一定存在的）
        if (left == null) return right;
        return left;
    }

    //BST类型
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestorBST(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestorBST(root.right, p, q);
        return root;
    }

}