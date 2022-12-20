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





}
