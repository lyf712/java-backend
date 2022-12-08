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

import java.util.Stack;

/**
 * @authorliyunfei
 * @date2022/12/8
 **/
class MyQueueV2{
      Stack<Integer> stackIn;
      Stack<Integer> stackOut;

      public MyQueueV2() {
      }

      //---
    // pop,peek则去dumpstackIn一下，保证最新数据，有点刷新缓存的感觉
      //
    private void dumpstackIn(){
        if (!stackOut.isEmpty()) return;
        while (!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
    }
}
public class MyQueue {
    Stack<Integer> master;// = new Stack<>();
    Stack<Integer> wocker;// = new Stack<>();
    public MyQueue() {
        master = new Stack<>();
        wocker = new Stack<>();
    }

    // O(1)
    public void push(int x) {
        master.push(x);
    }

    // o(n)操作 ，若使用两个栈 -- O(2n)
    // FIXME 可直接一个负责入栈，一个负责出栈
    public int pop() {
        while(!master.isEmpty()){
            wocker.push(master.pop());
        }
        int val = wocker.isEmpty()?-1:wocker.pop();
        while(!wocker.isEmpty())
            master.push(wocker.pop());
        return val;
    }

    public int peek() {
        while(!master.isEmpty()){
            wocker.push(master.pop());
        }
        int val = wocker.isEmpty()?-1:wocker.peek();
        while(!wocker.isEmpty())
            master.push(wocker.pop());
        return val;
    }

    public boolean empty() {
        return master.size()==0;// isEmpty
    }
}
