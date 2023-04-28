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

package com.lyf.alg.newcoder;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] xianxu = {1,2,4,5,3};//[1,2,4,5,3],[4,2,5,1,3]
        int[] zhognxu = {4,2,5,1,3};
        System.out.println(Arrays.toString(new Solution().solve(xianxu,zhognxu)));
    }
    class Node {
        int val;
        Node left, right;
        public Node(int val) {
            this.val = val;
        }
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     * @param xianxu int整型一维数组 先序遍历
     * @param zhongxu int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public int[] solve (int[] xianxu, int[] zhongxu) {
        // write code here
        // 层序遍历
        if (xianxu.length == 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < zhongxu.length; i++) {
            //注意不适合具有重复的值
            map.put(zhongxu[i], i);
        }
        Node root = mergeTree(xianxu, zhongxu, 0, xianxu.length - 1);
        System.out.println(root);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int count = 0;
            while (count++ < size) {
                Node node = queue.poll();
                if (count == size) {
                    // 最后一层加入
                    list.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        int[]rs = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            rs[i] = list.get(i);
        }
        return rs;
    }

    Map<Integer, Integer> map = new HashMap<>();
    int index =0;
    Node mergeTree(int[] xianxu, int[] zhongxu, int left, int right) {
        if (left > right) {
            return null;
        }
        if(index>= zhongxu.length){
            return null;
        }
        Node root = new Node(xianxu[index++]);
        // 确定划分
        int mid =   map.get(xianxu[left]);// 中序的位置
        //System.out.println(mid);
        root.left = mergeTree(xianxu, zhongxu, left, mid-1 );
        root.right = mergeTree(xianxu, zhongxu, mid + 1, right);
        return root;
    }

}