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

package com.lyf.huawei.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyunfei
 **/
public class Main2 {
    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        //input.add()
        //输入:
        //[[1,2,2,1],[3,1,2],[1,3,2], [2,4],[3,1,2], [1,3,1,1]]
        //输出: 2
        List<Integer> row = new ArrayList<>();
        row.add(1);
        row.add(2);
        row.add(2);
        row.add(1);
        input.add(row);
        row = new ArrayList<>();
        row.add(3);
        row.add(1);
        row.add(2);
        input.add(row);
        row = new ArrayList<>();
        row.add(1);
        row.add(3);
        row.add(2);
        input.add(row);
        row = new ArrayList<>();
        row.add(2);
        row.add(4);
        input.add(row);
        row = new ArrayList<>();
        row.add(3);
        row.add(1);
        row.add(2);
        input.add(row);
        row = new ArrayList<>();
        row.add(1);
        row.add(3);
        row.add(1);
        row.add(1);
        input.add(row);
        leastVal(input);
    }

    //  //[[1,2,2,1],[3,1,2],[1,3,2], [2,4],[3,1,2], [1,3,1,1]]
    static void leastVal(List<List<Integer>> wall){
        List<List<Boolean>> record = new ArrayList<>();

        for(List<Integer> row:wall){
            List<Boolean> list = new ArrayList<>();

            for(int i=0;i<row.size();i++){
                int curVal = row.get(i);
                for(int j=1;j<curVal;j++){
                    //穿墙，不是空位
                    list.add(false);
                }
                // 末尾窗墙
                list.add(true);
            }
            record.add(list);
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<record.get(0).size()-1;i++){
            int val = 0;
            for(int j=0;j<record.size();j++){
               // val + = record.get(j)
                if(!record.get(j).get(i)){
                    val ++;
                }
            }
            min = Math.min(min,val);
        }
        System.out.println(min);

    }
}
