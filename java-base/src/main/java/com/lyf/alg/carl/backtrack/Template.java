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

package com.lyf.alg.carl.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @authorliyunfei
 * @date2022/12/24
 **/
public class Template {
       private List<List<Integer>> rs = new ArrayList<>();
       private LinkedList<Integer> path = new LinkedList<>();
       @Test
       public void test(){
           int[] nums = {1,2,3,4};
           backTrack(0,nums,0);
           System.out.println(rs.size()+":"+rs);// 2^n 全部集合

       }
       private void backTrack(int start,int[]nums,int flag){

           // if(path.size()>=nums.length){
                //终止条件   也可通过path.size()反应 到达的层数？
                // path.size()== nums.length 则说明到达 叶子节点
                rs.add(new ArrayList<>(path));
             //   return;
           // }

            // start,0,决定 是否重复选择
            for(int i=start;i<nums.length;i++){
               // if(isValid()){continue;}
                // 可通过 横向选择、非法检查略过 等方式进行剪裁，降低时间复杂度
                path.add(nums[i]);
                backTrack(i+1,nums,flag);//纵向递归，纵深、深度
                path.removeLast();
                // 回溯，回退：退出该层，回到上层，重新选择
            }
       }
       // 判断条件
       boolean isValid(){return false;}



}
