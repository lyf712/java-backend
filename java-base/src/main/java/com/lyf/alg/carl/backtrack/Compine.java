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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @authorliyunfei
 * @date2022/12/11
 **/
public class Compine {


    List<List<Integer>> rs = new ArrayList<>();
    LinkedList<Integer> tmp = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        track(1,k,n);
        return rs;
    }
    private void track(int start,int k,int n){
        if(tmp.size()==k){rs.add(new ArrayList<>(tmp));return;}
        for(int i=start;i<=n+1-(k-tmp.size());i++){
            tmp.add(i);
            track(i+1,k,n);//00
            tmp.removeLast();
        }
    }

//     List<List<Integer>> rs = new ArrayList<>();
//     LinkedList<Integer> tmp = new LinkedList<>();
     public List<List<Integer>> combine2(int n, int k) {
            // 暴力的办法遍历--指数级别
            // 回溯--暴力的思想

         //    for(int i=1;i<=n-k+1;i++){
         //       List<Integer> tmp = new ArrayList<>();
         //       backtrack(n,i,k,tmp);
         //    }

            //LinkedList<Integer> tmp = new LinkedList<>();
            backtrack(n,1,k);//tmp
            return rs;
     }
     void backtrack(int n,int cur,int k){//,LinkedList<Integer> tmp
            if(tmp.size()==k){rs.add(new LinkedList<>(tmp));return;}
            for(int i=cur;i<=n+1-(k-tmp.size());i++){
               //if(!tmp.contains(i))
               tmp.add(i);
               backtrack(n,cur+1,k);//tmp FIXME 思考为什么是i+1而非 cur+1;若cur+1则回退过多，有重复数等，选择范围更大
               tmp.removeLast();//回退
            }
         //  if(cur<=n){
         //      tmp.add(cur);
         //      if(tmp.size()==k){
         //          if(!rs.contains(tmp))
         //              rs.add(new ArrayList<>(tmp));
         //          tmp.remove(tmp.size()-1);
         //      }
         //      backtrack(n,cur+1,k,tmp);
         //  }

         // for(int i=cur;i<=n;i++){
             //  tmp.add(cur);
             //  if(tmp.size()==k){
             //      rs.add(new ArrayList<>(tmp));
             //      // 回退
             //      tmp.remove(tmp.size()-1);
             //  }
             //  backtrack(n,cur+1,k,tmp);
          //}
     }


}
