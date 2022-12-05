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

package com.lyf.alg.carl.link;

/**
 *
 * 问题点：
 * <li>
 * （1）问题描述 - size 和index的考虑 （index 题目描述为第几个节点，实际上为 下标
 * ---需要统一！！！
 * </li>
 * （2）考虑同size,index判断合法性--防御式编程，controller入口参数检查；练习动态语言动态时检查机制
 * （3）设计步骤，先考虑 addHead,addTail,addAtIndex,再考虑删除--，get
 *
 * 优化步骤：
 * （1）设计tail指针维护，提升尾部插入的效率
 * <li>
 *      问题记录:
 *      思路简易，实现容易出错
 * </li>
 *
 * // 双链表实现---
 *
 *
 *
 * @authorliyunfei
 * @date2022/12/5
 **/
class MyLinkedList2 {

    private class Node{
        private int val;
        private Node next;
        public Node(){}
        public Node(int val){this.val = val;}
    }

    private Node virtualHead;// 虚拟头结点
    private int size;// size大小

    public MyLinkedList2() {
        virtualHead = new Node(0);
        size = 0;
    }

    public int get(int index) {// i第几个节点
        if(index<0||index>=size)
            return -1;
        Node ptr = virtualHead;
        int ptrIndex = -1;//第0个节点
        while(ptrIndex<index) {
            ptr=ptr.next;
            ptrIndex++;
        }
        return ptr.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = virtualHead.next;
        virtualHead.next = newNode;
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node ptr = virtualHead;
        while(ptr!=null&&ptr.next!=null){
            ptr = ptr.next;
        }
        // ptr.next先为空，ptr.next为空，则ptr已指向尾结点
        ptr.next = newNode;// 则直接指向尾结点即可
        size++;//
    }

    public void addAtIndex(int index, int val) {
        // 先判断index合法性
        if(index>size)
            return;
        if(index<0)
            index = 0;//头部插入
        //    if(index==size)
        //         index = index-1;//尾部插入

        Node ptr = virtualHead;
        int ptrIndex = -1;//
        while(ptrIndex<index-1&&ptr!=null&&ptr.next!=null){ // ptrIndex = index-1时，即前一个节点跳出
            ptr = ptr.next;
            ptrIndex++;
        }
        Node newNode = new Node(val);
        newNode.next = ptr.next;
        ptr.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index<0||index>=size)
            return;
        Node ptr = virtualHead;
        int ptrIndex = -1;//
        while(ptrIndex<index-1) {
            ptr=ptr.next;
            ptrIndex++;
        }// ptr在index处
        ptr.next = ptr.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */