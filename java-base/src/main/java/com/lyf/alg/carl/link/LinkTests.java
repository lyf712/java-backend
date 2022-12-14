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

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
/**
 * @authorliyunfei
 * @date2022/12/5
 **/
public class LinkTests {

    @Test
    public void test(){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3

        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        //return (List<T>) Collections.unmodifiableList(new ArrayList<>(Arrays.asList(this.toArray())));
        list.stream().toList();
        Collections.synchronizedList(list);//unmodifiableList(list);

        List<Integer> list1 = new LinkedList<>(list);

        //new LinkedList<>().addFirst();
        //LinkedList
        //ArrayList
        //List
    }

    @Test
    public void testCopy(){
        //Collections.unmodifiableList()
        //Collections.sort();
       // Collections.synchronizedList()

    }
}
