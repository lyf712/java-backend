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
 * @date2022/12/14
 **/
public class Combine3 {
    List<List<Integer>> rs = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;
    void backTrack(int k,int n,int startIndex){
        if(path.size()==k&&sum==n){
            rs.add(new ArrayList<>(path));
            return;
        }
        // 范围剪裁 , n-sum 去
        for(int i=startIndex;i<=(n-sum<9?n-sum:9);i++){
            path.add(i);
            sum+=i;
            backTrack(k,n,i+1);
            path.removeLast();
            sum-=i;
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(k,n,1);
        return rs;
    }
}
