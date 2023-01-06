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

import java.util.*;

/**
 * @authorliyunfei
 * @date2023/1/6
 **/
public class OfferVII41 {
    List<Integer> record = null;//new LinkedList<>();

    /** initialize your data structure here. */
    public OfferVII41() {//MedianFinder
        record = new ArrayList<>();// 查询过多则采用ArrayList,插入过多则LinkedList
        // 如何综合考量，测试用例一般查询过多，采用ArrayList可以过。

    }

    // 插入排序--的方式进行插入
    public void addNum(int num) {
        int index = record.size()-1;
        while(index>=0){
            if(num>record.get(index)) break;
            index--;
        }
        record.add(index+1,num);
    }
    // 超时，查询开销过大
    public double findMedian() {
        int len = record.size();
        if(len%2==1){
            return (double)record.get(len/2);
        }else{
            return (double)(record.get(len/2-1)+record.get(len/2))/2.0;
        }
    }

    private static class C{
        PriorityQueue<Integer> q1,q2;
        /** initialize your data structure here. */
        public C() {
            q1 = new PriorityQueue<>();// 存储较大的数，小顶堆，保证取得数为大的数里面最小
            q2 = new PriorityQueue<>((o1,o2)->{return o2-o1;});//存储较小的数，大顶堆，保证取得的数为小的里面最大，两者则连续起来
        }

        public void addNum(int num) {
            // 考虑保证两个队列保证平衡
            if(q1.size()==q2.size()){
                q2.offer(num);
                q1.offer(q2.poll());
            }else{
                q1.offer(num);
                q2.offer(q1.poll());
            }
        }

        public double findMedian() {

            return q1.size()==q2.size()?(double)(q1.peek()+q2.peek())/2.0:(double)q1.peek();
        }
    }


}
