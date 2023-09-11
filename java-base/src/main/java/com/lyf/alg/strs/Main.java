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

package com.lyf.alg.strs;

/**
 * @author liyunfei
 **/
// 排序 + 判断？
// 1. 对于每个袋子，其中的球颜色两两不同。 // 排序自检，hash
// 2. 每个袋子都装着相同数量的球。// 输入的时候即可？
// 3. 对于每一种颜色，其要么仅出现在一个袋子中要么出现在所有袋子中。 // hash计数？
// 怎么存储输出？T组数据
// string(yes,no)  + list<> 共有
import java.util.*;
public class Main{
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            //t组数据
            int t = in.nextInt();
            String[]rs = new String[t];
            ArrayList[] commonNo = new ArrayList[t];
            int i=0;
            while(i<t){
                // 袋子的数量
                int n = in.nextInt();
                // 每个袋子的球的数量注意赋值可否？
                int[][]cnt = new int[n][100];
                boolean flag = true;
                int tmp = 0;
                //int total = 0;
                Map<Integer,ArrayList<Integer>> hash = new HashMap<>();

                for(int j=0;j<n;j++){
                    // 该次袋子的球的数量
                    int numTotal = in.nextInt();
                    if(j==0){
                        tmp = numTotal;
                    }else if(numTotal!=tmp){
                        flag = false;
                    }
                    HashSet<Integer> set = new HashSet<>();

                    for(int k=0;k<numTotal;k++){
                        cnt[j][k] = in.nextInt();
                        set.add(cnt[j][k]);
                    }
                    if(set.size()!=numTotal){
                        flag = false;
                    }else{
                        // List<Integer> list = new ArrayList<>();
                        for(int k=0;k<numTotal;k++){
                            ArrayList<Integer> tmpL = hash.getOrDefault(cnt[j][k],new ArrayList<>());
                            tmpL.add(j);
                            hash.put(cnt[j][k],tmpL);
                        }
                    }
                    //Arrays.sort(cnt[j]);
                }


                if(!flag){
                    rs[i] = "No";
                }else{
                    rs[i] = "Yes";
                    // 查重复
                    for(Map.Entry<Integer,ArrayList<Integer>> entry:hash.entrySet()){
                        ArrayList<Integer> val = entry.getValue();
                        // 没有在所有袋子或者一个袋子
                        if(val.size()!=1 && val.size()!=tmp ){
                            rs[i] = "No";
                            break;
                        }
                    }
                    if("Yes".equals(rs[i])){
                        for(Map.Entry<Integer,ArrayList<Integer>> entry:hash.entrySet()){
                            ArrayList<Integer> val = entry.getValue();
                            // 没有在所有袋子或者一个袋子
                            if( val.size()==tmp ){
                                commonNo[i].add(entry.getKey());
                                break;
                            }
                        }
                    }
                    // 查是否都不同，或者在不同袋子
                }
                i++;
            }

            for(int m=0;m<t;m++){
                if(rs[m].equals("No")){
                    System.out.println(rs[m]);
                }else{
                    System.out.print("Yes ");
                    for(int l=0;l<commonNo[m].size();l++){
                        System.out.print(commonNo[m].get(l)+" ");
                    }
                }
            }

        }
    }
}