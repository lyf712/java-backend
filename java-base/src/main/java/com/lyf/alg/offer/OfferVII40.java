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

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 同统计Top频率
 * @authorliyunfei
 * @date2023/1/5
 **/
public class OfferVII40 {
    @Test
    public void testTopK(){
        final int k = 5;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);//, (o1, o2) -> o2-o1
        //priorityQueue.
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        priorityQueue.offer(0);
        priorityQueue.offer(3);
        System.out.println(priorityQueue.peek());

        //Arrays.copyOf()
        //priorityQueue.toArray()
        //priorityQueue.
    }
    public int[] getLeastNumbers(int[] arr, int k) {
        //    if(k==0) return new int[0];
        //    PriorityQueue<Integer> q = new PriorityQueue<>(k);
        //    int[]rs = new int[k];
        //    for(int val:arr){
        //        q.offer(val);
        //    }
        //    for(int i=0;i<k;i++){
        //        rs[i]= q.poll();
        //    }
        //    return rs;

        // 若想只保存前k最小的，则建立大顶堆，删除时则删除大的值

        if(k==0) return new int[0];
        PriorityQueue<Integer> q = new PriorityQueue<>(k,(o1,o2)->{return o2-o1;});
        int[]rs = new int[k];
        for(int val:arr){
            q.offer(val);
            if(q.size()>k) q.poll();
        }
        for(int i=0;i<k;i++){
            rs[i]= q.poll();
        }
        return rs;
    }
}
