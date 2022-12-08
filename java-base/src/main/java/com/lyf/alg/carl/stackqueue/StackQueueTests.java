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

package com.lyf.alg.carl.stackqueue;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @authorliyunfei
 * @date2022/12/8
 **/
public class StackQueueTests {
    @Test
    public void testApi(){
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> queue1 = new LinkedList<>();
        stack.peek();
        queue.peek();

        stack.pop();
        queue.poll();

        stack.push(1);
        queue.offer(1);
    }
    @Test
    public void testMyQueue(){
        MyQueue myQueue = new MyQueue();

    }
}
