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
import java.util.Queue;
import java.util.Collections;

/**
 * @authorliyunfei
 * @date2022/12/9
 **/
public class TreeLevelTraverse {
    static class TreeNode{int val;TreeNode left,right;}

    // 双队列捣鼓
    public List<List<Integer>> levelOrder(TreeNode root) {
        //1.两个队列，先进先出
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        List<List<Integer>> rs = new ArrayList<>();
        if(root==null)
            return rs;
        q1.offer(root);
        while(!q1.isEmpty()||!q2.isEmpty()){
            // BFS
            List<Integer> tmp = new ArrayList<>();
            if(!q1.isEmpty()){// 该层
                handle(q1,q2,tmp);
            }else if(!q2.isEmpty()){
                handle(q2,q1,tmp);
            }
            rs.add(tmp);
        }
        return rs;
    }
    void handle(Queue<TreeNode> q1,Queue<TreeNode> q2,List<Integer> tmp){
        while(!q1.isEmpty()){
            TreeNode node = q1.poll();
            tmp.add(node.val);
            if(node.left!=null)
                q2.offer(node.left);
            if(node.right!=null)
                q2.offer(node.right);
        }
    }
    // 单队列 + 计数，记录该层数量
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        if(root==null) return rs;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int levelNum = 1;// 第一层为一
        while(!q.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int index = 0;
            int nextLevelNum = 0;//下一层的数量 FIXME 可利用q.size()去记录，无需这么麻烦
            while(index<levelNum){
                TreeNode node = q.poll();
                tmp.add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                    nextLevelNum++;
                }
                if(node.right!=null){
                    q.offer(node.right);
                    nextLevelNum++;
                }
                index++;
            }
            rs.add(tmp);
            levelNum = nextLevelNum;
        }
        return rs;
    }
    // 单队列 + 计数，记录该层数量（化简）
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        if(root==null) return rs;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        //int levelNum = 1;// 第一层为一
        while(!q.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            //int index = 0;
            //int nextLevelNum = 0;//下一层的数量
            int len = q.size();
            while(len>0){
                TreeNode node = q.poll();
                tmp.add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                    //nextLevelNum++;
                }
                if(node.right!=null){
                    q.offer(node.right);
                    //nextLevelNum++;
                }
                len--;
                //index++;
            }
            rs.add(tmp);
            //levelNum = nextLevelNum;
        }
        return rs;
    }

    List<List<Integer>> rs = new ArrayList<>();
    // 递归
    public List<List<Integer>> levelOrder4(TreeNode root) {
        recursion(root,1);
        return rs;
    }
    void recursion(TreeNode root,int deep){

        if(root==null) return;
        //deep++;
        if(rs.size()<deep){
            rs.add(new ArrayList<>());// 记录的层数不够则新增---，动态添加，若知道高度，则提前--
        }
        rs.get(deep-1).add(root.val);//
        recursion(root.left,deep+1);// 往左右子节点走 deep则加深一层
        recursion(root.right,deep+1);
    }
}
