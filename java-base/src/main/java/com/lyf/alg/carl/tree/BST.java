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
 * @date2022/12/20
 **/
public class BST {
    private class TreeNode{int val;
        TreeNode left,right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    List<Integer> inorderRs = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        // traverse(root);
        //    int minVal = inorderRs.get(1)-inorderRs.get(0);//Math.abs()
        //    for(int i=2;i<inorderRs.size();i++){
        //        int val =inorderRs.get(i)-inorderRs.get(i-1);// Math.abs()
        //        if(val<minVal){minVal=val;}
        //    }

        //return minVal;

        traverse2(root);
        return rs;
    }

    private void traverse(TreeNode root){
        if(root!=null){
            traverse(root.left);
            inorderRs.add(root.val);
            traverse(root.right);
        }
    }

    int rs = Integer.MAX_VALUE;
    TreeNode pre=null;
    private void traverse2(TreeNode root){
        if(root!=null){
            traverse2(root.left);
            if(pre!=null && root.val-pre.val<rs){rs = root.val-pre.val;}
            //inorderRs.add(root.val);
            pre = root;
            traverse2(root.right);
        }

    }

    public int[] findMode(TreeNode root) {
        traverse(root);
        int[]rs = new int[record.size()];
        for(int i=0;i<record.size();i++){
            rs[i]=record.get(i);
        }
        return rs;
    }
    int max = 0;
    int count =0;//统计计数
    List<Integer> record = new LinkedList<>();
    TreeNode pre0=null;
    void traverse3(TreeNode root){
        if(root!=null){
            traverse(root.left);
            if(pre==null || pre.val!=root.val){
                // 前面为空 或者 前面不等于现有的（即重新开始计数），则第一次计数
                count = 1;
            }else {//
                count++;
            }
            // 处理最大值更替
            if(count>max){
                // 需要更新最大值
                max = count;
                record.clear();
                record.add(root.val);//记录
            }else if(count==max){
                record.add(root.val);
            }
            pre0 = root;
            traverse(root.right);
        }
    }


    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 边界处理
        if(root==null){
            root = new TreeNode(val);
            return root;
        }

        // 保证插入到叶子节点
        if(root!=null && root.val>val){
            // 操作
            if(root.left==null)
                root.left = new TreeNode(val);
            // 左递归 （递归左子树
            insertIntoBST(root.left,val);
        }
        if(root!=null && root.val<val){
            if(root.right==null)
                root.right = new TreeNode(val);
            // 右递归
            insertIntoBST(root.right,val);
        }

        return root;
    }

    // 另外一种递归思路
    public TreeNode insertIntoBSTSimply(TreeNode root, int val) {
        if(root==null){
            root = new TreeNode(val);// 表示待插入的地方
            return root;
        }
        //
        if(root.val<val){
            // 递归右子树-- 已包含指向操作
            root.right = insertIntoBST(root.right,val);
        }else{
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        // 定义基本原则：
        // 让右子树 最小值节点去顶‘
        // 考虑右子树root的左子树情况（右子树root的右子树无需理会）

        if(root!=null){
            if(root.val == key){
                // 找到该删除的节点
                // 去右子树寻找
                //root = //--
                //  TreeNode deleteNodeRight = root.right;
                //  if(deleteNodeRight==null){
                //      root = root.left;// 直接将该节点改为左子节点
                //  }else{
                // 寻找 右边子树的 最左边节点顶替
                //      TreeNode tmpNode = deleteNodeRight;

                //      while(tmpNode.left!=null){
                //          tmpNode = tmpNode.left;
                //      }

                //      TreeNode tmpNodeRight = tmpNode;// 最左代替的最右边
                //      while(tmpNode!=deleteNodeRight&&tmpNodeRight.right!=null){
                //          tmpNodeRight = tmpNodeRight.right;
                //      }

                //      //root.right = null;//要断掉，否则出现环
                //      tmpNode.left = root.left;//最左边的left一定为空，可直接指向
                //     // 对于最左边的right还需要考虑调整
                //      if(tmpNodeRight!=deleteNodeRight){
                //          deleteNodeRight.left = null;//置空
                //          tmpNodeRight.right = deleteNodeRight;
                //      }

                //      root = tmpNode;

                //  }

                //  return root;


                if (root.left == null) return root.right;
                if (root.right == null) return root.left;
                TreeNode tmp = root.right;
                while (tmp.left != null) {
                    tmp = tmp.left;
                }
                root.val = tmp.val;
                root.right = deleteNode(root.right,tmp.val);

                return root;
            }else if(root.val>key){
                root.left = deleteNode(root.left,key);
            }else{
                root.right = deleteNode(root.right,key);
            }
        }

        return root;
    }



}
