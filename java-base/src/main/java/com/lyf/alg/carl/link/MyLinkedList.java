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
 * @authorliyunfei
 * @date2022/12/5
 **/
class MyLinkedList {
    // 结合LinkedList源码分析
    // 个人策略：
    // pre , tail

    private class Node{
        private int val;
        private Node next;
        public Node(){}
        public Node(int val){this.val = val;}
    }
    // 头结点，尾节点，方便头插入和尾插入，
    private Node head;//虚拟头结点，在实际头结点前面一个
    private Node tailPtr; // 真实指针，指向尾节点
    int size;
    /*
     * /-----/-----/
     * /----/-----/
     * head-> link  ->tail
     *
     */

    public MyLinkedList() {
        head=new Node(-1);
        size = 0;
        //   tail = new Node(-1);
        //   head.next=tail;
    }

    public int get(int index) {
        int ptrIndex = -1;
        Node ptr = head;
        while(ptr!=null && ptr.next!=null){// ptr.next==null 则说明ptr已指向尾结点（tailPtr需要始终保持指向尾节点）
            if(ptrIndex==index)
                break;
            ptr = ptr.next;
            ptrIndex++;
        }
        if(ptrIndex==-1)
            return -1;
        else
            return ptr.val;
        //return ptrIndex;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head.next;
        head.next = newNode;
        if(size==0){
            // 需要调整tailPtr指向
            tailPtr = newNode;
        }
        size++;
    }

    public void addAtTail(int val) {
        tailPtr.next = new Node(val);
        tailPtr = tailPtr.next;
        size++;
    }

    // index 需要遍历进行插入
    public void addAtIndex(int index, int val) {
        // 判断index合理性
        if(index<0||index>=size)
            return;// 不合法数据


        Node ptr = head;
        int ptrIndex = -1;

        if(index==size)
        {
            tailPtr.next=new Node(val);
            tailPtr = tailPtr.next;
        }

        // 寻找在index前的位置
        while(ptrIndex<index-1){
            ptrIndex++;
            ptr = ptr.next;
        }

        Node newNode = new Node(val);
        newNode.next = ptr.next;
        ptr.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index<0||index>=size)
            return;// 不合法数据

        Node ptr = head;
        int ptrIndex = -1;
        // 寻找在index前的位置
        while(ptrIndex<index-1){
            ptrIndex++;
            ptr = ptr.next;
        }
        if(index==size-1){
            tailPtr = ptr;
        }
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