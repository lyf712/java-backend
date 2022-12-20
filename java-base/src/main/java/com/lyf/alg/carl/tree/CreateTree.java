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

import org.junit.Test;

import java.util.Arrays;

/**
 * @authorliyunfei
 * @date2022/12/18
 **/
public class CreateTree {
    private class TreeNode{int val;TreeNode left,right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    @Test
    public void testArrSplit(){
        //int[]nums = new int[10];
        //native void arraycopy
        //Arrays.copyOfRange()
        int a = 1,b=2;
        System.out.println(System.currentTimeMillis());
        for(int i=0;i<1000;i++)
            a +=b;
        System.out.println(System.currentTimeMillis()+":"+a);
    }

    @Test
    public void testCache(){
        int[][]arr0= new int[100000][16];
        int[][]arr1= new int[100000][31];
        long star0 = System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            for(int j=0;j<=15;j++){
                arr0[i][j] = 0;
            }
        }
        long end0 = System.currentTimeMillis();
        long star1 = System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            for(int j=0;j<=30;j++){
                arr1[i][j] = 0;
            }
        }
        long end1 = System.currentTimeMillis();

        System.out.println("arr0:"+(end0-star0)+";arr1:"+(end1-star1));
        //Arrays.copyOfRange()
        int [] arr = {1,2,4,3};
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr,0,0)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr,0,1)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr,3,arr.length)));


    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recursionCreate(nums);
    }
    TreeNode recursionCreate(int[]nums){
        if(nums.length==0){
            return null;
        }
        int maxIndex = findMaxIndex(nums);
        TreeNode root = new TreeNode(nums[maxIndex]);
        //if(maxIndex-1>=0)
        // 注意使用 Arrays.copyOfRange时的下标问题，to!这个下标
        root.left = recursionCreate(Arrays.copyOfRange(nums,0,maxIndex));
        //if(maxIndex+1<=nums.length-1)
        root.right = recursionCreate(Arrays.copyOfRange(nums,maxIndex+1,nums.length));
        return root;
    }
    int findMaxIndex(int[]nums){
        if(nums.length==0) return -1;
        int maxIndex = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[maxIndex]) maxIndex = i;
        }
        return maxIndex;
    }


//    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        TreeNode rs = solve(nums,0,nums.length-1);
//        return rs;
//    }

    int findMax(int[]nums,int low,int high){// 返回最大值的位置
        int max = low;
        for(int i=low;i<=high;i++){
            if(nums[i]>nums[max])
                max = i;
        }
        return max;
    }

    public TreeNode solve(int[]nums,int low,int high){
        int max = findMax(nums,low,high);// 找到最大值的位置
        TreeNode root = new TreeNode(nums[max]);
        if(max>low){
            root.left = solve(nums,low,max-1);
        }
        if(max<high){
            root.right = solve(nums,max+1,high);
        }
        return root;
    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return createHelper(postorder.length-1,0,postorder.length-1,postorder,inorder);
    }

    /**
     * rootIndex:先序的root下标
     * low,high 去划分 中序的范围->构建左右子树
     *
     */
    TreeNode createHelper(int rootIndex,int low,int high,int[]postorder,int[]inorder){
        if(low>high) return null;
        int index = findIndex(inorder,postorder,rootIndex,low,high);
        TreeNode root = new TreeNode(inorder[index]);
        if(index>low)
            root.left = createHelper(rootIndex-1,low,index-1,postorder,inorder);
        if(index<high)
            root.right = createHelper(rootIndex-1,index+1,high,postorder,inorder);
        return root;
    }

    // 前后序 则可通过此处修改--
    int findIndex(int[]inorder,int[]postorder,int rootIndex,int low,int high){
        //for(int i=postorder.length-1;i>=0;i--){
        for(int i=rootIndex;i>=0;i--){
            for(int j=low;j<=high;j++){
                if(inorder[j]==postorder[i]) return j;//在中序中选出先序最先出现的数据下标
            }
        }
        return -1;
    }

    // 合并二叉树
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 合并到root1
        if(root1==null)return root2;
        mergeHelper(root1,root2);
        return root1;
    }
    void mergeHelper(TreeNode root1, TreeNode root2){
        if(root1!=null||root2!=null){
            if(root1==null) root1 = new TreeNode(0);
            if(root2==null) root2 = new TreeNode(0);
            root1.val = root1.val+root2.val;
            if(root1.left==null&&root2.left!=null) root1.left = new TreeNode(0);
            if(root1.right==null&&root2.right!=null) root1.right = new TreeNode(0);

            mergeHelper(root1.left,root2.left);
            mergeHelper(root1.right,root2.right);
        }
        //  if(root1==null&&root2==null){return;}
        //  int newVal = 0;
        //  if(root1==null){
        //      root1 = new TreeNode(0);
        //  }
        //  if(root2==null){ // 改变了树二的结构，若不想改变，则可复制一个临时树
        //      root2 = new TreeNode(0);
        //  }
        //  newVal = root1.val + root2.val;
        //  root1.val = newVal;
        //  mergeHelper(root1.left,root2.left);
        //  mergeHelper(root1.right,root2.right);
    }

}
