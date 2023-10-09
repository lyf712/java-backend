//import java.util.*;
//
///*
// * public class TreeNode {
// *   int val = 0;
// *   TreeNode left = null;
// *   TreeNode right = null;
// *   public TreeNode(int val) {
// *     this.val = val;
// *   }
// * }
// */
//
//public class Solution {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     *
//     * @param root TreeNode类
//     * @return TreeNode类ArrayList
//     */
//    public ArrayList<TreeNode> balanceSubTree (TreeNode root) {
//        // write code here
//        // 后序遍历，判断左右的高度平衡情况，若不平衡则进行删除 ，高那个子树
//        System.out.println("start");
//        handle(root);
//        rs.add(root);
//        System.out.println("hello");
//        rs.sort((node1,node2)->{
//            cnt=0;
//            countNum(node1);
//            int n1 = cnt;
//            cnt = 0;
//            countNum(node2);
//            int n2 = cnt;
//            if(n1<n2){
//                return -1;
//            }else if((n2>n1)){ //(n2>n1)
//                return 1;
//            }else {
//                if(node1.val < node2.val){
//                    return -1;
//                }else{
//                    return 1;
//                }
//            }
//        });
//        return rs;
//    }
//    ArrayList<TreeNode> rs = new ArrayList<TreeNode>();
//    void handle(TreeNode root){
//        if(root!=null){
//            handle(root.left);
//            handle(root.right);
//
//            // 回退处理,如何在遍历的时候记录维护高度（），先尝试暴力计算
//            int leftH = height(root.left);
//            int rightH = height(root.right);
//            if(leftH-rightH==2){
//                // 删除左节点
//
//                rs.add(root.left);
//                root.left = null;
//            }else if(rightH-leftH==2){
//                // 删除右节点
//
//                rs.add(root.right);
//                root.right = null;
//            }
//
//        }
//    }
//
//    int height(TreeNode root){
//        if(root==null){
//            return 0;
//        }
//        return Math.max(height(root.left)+1,height(root.right)+1);
//    }
//
//    int cnt = 0;
//    void countNum(TreeNode root){
//        if(root!=null){
//            handle(root.left);
//            handle(root.right);
//            cnt++;
//        }
//    }
//
//    private class TreeNode {
//    }
//}