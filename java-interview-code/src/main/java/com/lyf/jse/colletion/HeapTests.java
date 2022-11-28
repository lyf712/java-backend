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

package com.lyf.jse.colletion;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

/**
 * TopK问题
 * 1、如果求前K个最大的元素，要建一个小根堆。
 *
 * 2、如果求前K个最小的元素，要建一个大根堆。
 *
 * @authorliyunfei
 * @date2022/11/28
 **/
public class HeapTests {
    public static void main(String[] args) {
        new HeapTests().test();
    }

    // @Test
    public void test() {
        final int k = 5;
        // 定义
        PriorityQueue<Integer> priorityQueueK = new PriorityQueue(k, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer) o2 - (Integer) o1;
            }
        });
        // 如何保存Heap的size为K
        // 读取数据--模拟外存加载

        for (; ; ) {
            // priorityQueueK.
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            // 理解该处
            if (priorityQueueK.size() >= k && priorityQueueK.peek() > input) {// 大顶堆，顶为最大值，小于该值 则该值可以去除，构建小K
                priorityQueueK.poll();
            }
            priorityQueueK.offer(input);//new Random().nextInt(100)
            printK(priorityQueueK);
        }
    }

    void printK(PriorityQueue priorityQueue) {
        System.out.println("topK:");
        priorityQueue.forEach(val->{
            System.out.println(val+",");
        });
        System.out.println(String.format("heap info size:%s", priorityQueue.size()));
    }

    public static int[] topK(int[] arr, int k) {
        // 创建一个大小为 k的大根堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                // 放入前 k 个元素
                maxHeap.offer(arr[i]);
            } else {
                // 从第 k+1个元素开始进行判断是否要入堆
                if (maxHeap.peek() > arr[i]) {//输入值小于最大值，
                    maxHeap.poll();
                    maxHeap.offer(arr[i]);
                }
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = maxHeap.poll();
        }
        return ret;
    }
}