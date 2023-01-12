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

package com.lyf.alg.carl.greed;

import org.junit.Test;

import java.util.*;

/**
 * @author liyunfei
 **/
public class LC452 {
    @Test
    public void test(){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(2147483647<-2147483648);
        System.out.println(2147483646<=-2147483645);//
       // [[-2147483646,-2147483645],[2147483646,2147483647]]
        int[][]points = new int[2][2];
        points[0][0]=-2147483646;
        points[0][1]=-2147483645;
        points[1][0]=2147483646;
        points[1][1]=2147483647;
//        points[0][0]=-21474836;
//        points[0][1]=-21474836;
//        points[1][0]=21474836;
//        points[1][1]=21474836;
        System.out.println(points[0][0]-points[1][0]);
        long e1 = (long)points[0][0];
        long e2 = (long) points[0][1];
        System.out.println(e1-e2);
        System.out.println((int) e1-e2);
        System.out.println(findMinArrowShots(points));
    }
    public int findMinArrowShots(int[][] points) {
        List<long[]> list = new ArrayList<>(points.length);
        for(int i=0;i<points.length;i++){
            long []tmp =new long[2];
            tmp[0]=points[i][0];
            tmp[1]=points[i][1];
            list.add(tmp);
        }
        //Collections.sort(list, Comparator.comparingLong((e1,e2)->{return e1[0]-e2[0];}));
        //Collections.sort(list,(e1, e2)-> (int) (e1[0]-e2[0]));
        //Collections.sort(list);
        list.sort((e1, e2)-> (int) (e1[0]-e2[0]));
        int rs = list.size();
        long start = list.get(0)[0];
        long end = list.get(0)[1];
        for(int i=1;i<list.size();i++){
            long[] tmp = list.get(i);
            if(tmp[0]<=end){
                rs--;
                end = Math.min(end,tmp[1]);
                start= Math.max(start,tmp[0]);// 必然新的tmp[0]大于start
            }else{
                start = tmp[0];
                end = tmp[1];
            }
        }
        return rs;
    }

    public int findMinArrowShots2(int[][] points) {
        // Arrays.sort(points,(e1,e2)->Integer.compare(e1[0],e2[0]));
        Arrays.sort(points, Comparator.comparingInt(e -> e[0]));
        int rs = 1;
        for(int i=1;i<points.length;i++){
            if(points[i][0]>points[i-1][1]){
                rs++;
            }else{
                points[i][1] = Math.min(points[i-1][1],points[i][1]);
            }
        }
        return rs;
    }
}
