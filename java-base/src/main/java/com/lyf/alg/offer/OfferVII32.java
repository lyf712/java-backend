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


import com.lyf.alg.carl.tree.CreateTree;

import java.util.*;

/**
 * @authorliyunfei
 * @date2023/1/4
 **/
public class OfferVII32 {
    private class TreeNode{int val;
        TreeNode left,right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 层次遍历
        // 双端队列去放
        // 奇数层 左往右，偶数层从左往右，根部为第一层
        // 想复杂了，直接层次遍历，在插入该处节点时进行反转即可。
        // 但时间复杂度 加大。能否利用 双端去调节呢
        // 见卡神---
        //利用双端队列的两端皆可添加元素的特性，设打印列表（双端队列） tmp ，并规定：
        //奇数层 则添加至 tmp 尾部 ，
        //偶数层 则添加至 tmp 头部 。

        //if(root==null) return null;
        int level = 1;
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> rs = new ArrayList<>();
        if(root==null) return rs;
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            int count = 0;
            List<Integer> levelList = new LinkedList<>();
            while(count<levelNum){
                //FIXME 处理次序问题，学会定量思考，不要将加入和取出同时思考复杂化
                TreeNode node = queue.pop();
                //    if(level%2==1){// 上一层是
                //          node =  queue.getLast();
                //          if(node.right!=null) queue.addFisrt(node.right);
                //          if(node.left!=null) queue.addFisrt(node.left);
                //    }else{
                //          node =  queue.getLast();

                //    }
                //--
                levelList.add(node.val);


                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);

                count++;
            }
            if(level%2==0){
                Collections.reverse(levelList);
            }
            rs.add(new ArrayList<>(levelList));
            level++;
        }
        return rs;
    }
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);

        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();

            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();

                if(res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部

                // 该次序保持不变
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            res.add(tmp);
        }

        return res;
    }

}
