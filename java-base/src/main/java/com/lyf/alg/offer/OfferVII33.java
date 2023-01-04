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

/**
 * @authorliyunfei
 * @date2023/1/4
 **/
public class OfferVII33 {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length==0) return true;
        return helper(postorder,0,postorder.length-1);
    }
    boolean helper(int[] postorder,int i,int j){
        // int rootVal = postorder[index];
        // if(index-1>=0&&index-2>=0){// 可讨论三种情况
        //     if(postorder[index-2]<rootVal&&postorder[index-1]>rootVal){

        //     }
        // }else if(index-1>=0){// 可讨论左右子节点

        // }
        // 小于root的则为左子树、大于则为右子树，需要合理利用BST的特性方向验证

        if(i>=j) return true;
        int p=i;
        // postoder[j]则为根  左右根，去划分符合BST的左子树
        while(postorder[p]<postorder[j]){p++;}
        int m = p;
        while(postorder[p]>postorder[j]){p++;}
        // p==j若能跑到底则能正确划分该次
        return p==j && helper(postorder,i,m-1) && helper(postorder,m,j-1);
    }
}
