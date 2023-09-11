package com.lyf.alg.newcoder;/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
import com.lyf.alg.newcoder.TreeNode;

import java.util.Objects;
import java.util.Queue;
import java.util.LinkedList;
public class SerialTree {

    String Serialize(TreeNode root) {
        // 层次序列化：单向链表的极端情况，浪费存储
        // {1,2,3}
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            // TreeNode node = queue.poll();
            int size = 0;// 记录实际的数量
            int tmpSize = queue.size();
            for(int i=0;i<tmpSize;i++){
                TreeNode node = queue.poll();
                if(node==null){
                    sb.append("#");
                    sb.append(",");
                    queue.offer(null);
                    queue.offer(null);
                }else{
                    sb.append(node.val);
                    sb.append(",");
                    if(node.left!=null){size++;}
                    if(node.right!=null){size++;}
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if(size==0){
                break;
            }
        }
        if(sb.length()>1){
            sb = sb.deleteCharAt(sb.length()-1);
        }
        sb.append("}");
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        ///
        if("{}".equals(str) || str.length() == 0){return null;}
        str = str.substring(1,str.length()-1);
        String[]strs = str.split("\\,");
        // int[] arr = new int[strs.length];
        // for(int i=0;i<strs.length;i++){
        //     arr[i] = Integer.valueOf(strs[i]);
        // }
        return buildNode(strs,0);
    }
    TreeNode buildNode(String[]arr,int index){

        if(index>=arr.length || Objects.equals(arr[index], "#")){return null;}
        TreeNode root = new TreeNode(Integer.valueOf(arr[index]));
        root.left = buildNode(arr,2*index+1);
        root.right = buildNode(arr,2*index+2);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new SerialTree().Deserialize(
                "{}");//{1,2,3,#,#,6,7}

        String str = new SerialTree().Serialize(root);
        System.out.println(str);
    }
}