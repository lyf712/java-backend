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

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 双端队列--单调栈
 * @authorliyunfei
 * @date2023/1/4
 **/
public class OfferVII52 {
    Queue<Integer> queue = null;
    Deque<Integer> deque = null;

    public OfferVII52() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty()?-1:deque.getFirst();//peekFirst();
    }
    //重点理解该处，为什么小于value的值就可以不维护了。
    public void push_back(int value) {
        while(!deque.isEmpty()&&deque.getLast()<value){
            deque.removeLast();
        }
        deque.addLast(value);
        queue.offer(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) return -1;
        int val = queue.poll();
        if(val==deque.getFirst()){deque.removeFirst();}
        return val;
    }
}
