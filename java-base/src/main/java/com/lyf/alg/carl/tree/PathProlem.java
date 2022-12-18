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

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @authorliyunfei
 * @date2022/12/18
 **/
public class PathProlem {
    private class TreeNode{int val;
    TreeNode left,right;}
    List<List<Integer>> rs = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    // 回溯办法
    public List<String> binaryTreePaths(TreeNode root) {
        traverse(root);
        List<String> rs0 = new ArrayList<>();
        for(List<Integer> list:rs){
            String str = "";
            for(Integer o:list)
            {
                str = str + o +"->";
            }
            if(str!=""){
                rs0.add(str.substring(0,str.length()-2));
            }
        }
        return rs0;
    }
    void traverse(TreeNode root){
        if(root!=null){
            path.add(root.val);
            if(root.left==null&&root.right==null){
                // 子节点
                rs.add(new ArrayList<>(path));
            }
            traverse(root.left);
            traverse(root.right);
            path.removeLast();
        }
    }
}
