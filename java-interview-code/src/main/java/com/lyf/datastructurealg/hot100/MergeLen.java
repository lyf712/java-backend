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

package com.lyf.datastructurealg.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liyunfei
 **/
public class MergeLen {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals.length<1){
                return new int[0][0];
            }
            Arrays.sort(intervals,(a, b)->{return a[0]-b[0];});
            int left=intervals[0][0],right = intervals[0][1];
            List<int[]> rs = new ArrayList<>();
            for(int i=1;i<intervals.length;i++){
                if(intervals[i][0]<=right){
                    // left = intervals[i][0];
                    if(intervals[i][1]>right){
                        right = intervals[i][1];
                    }
                    //right =
                }else{
                    int[]newTriple = new int[2];
                    newTriple[0]=left;
                    newTriple[1]=right;
                    rs.add(newTriple);
                    left = intervals[i][0];
                    right = intervals[i][1];
                }
            }
            // 可归并至循环中去
            int[]newTriple = new int[2];
            newTriple[0]=left;
            newTriple[1]=right;
            rs.add(newTriple);
            return rs.toArray(new int[rs.size()][]);//rsArr;
        }
    }


    //  if (intervals.length == 0) {
    //         return new int[0][2];
    //     }
    //     Arrays.sort(intervals, new Comparator<int[]>() {
    //         public int compare(int[] interval1, int[] interval2) {
    //             return interval1[0] - interval2[0];
    //         }
    //     });
    //     List<int[]> merged = new ArrayList<int[]>();
    //     for (int i = 0; i < intervals.length; ++i) {
    //         int L = intervals[i][0], R = intervals[i][1];
    //         if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
    //             merged.add(new int[]{L, R});
    //         } else {
    //             merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
    //         }
    //     }
    //     return merged.toArray(new int[merged.size()][]);



}
