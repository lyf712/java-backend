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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @authorliyunfei
 * @date2022/11/25
 **/
public class ListTests {
       @Test
       public void test(){
           // 扩容的时机和大小
           /*
             private void writeObject(java.io.ObjectOutputStream s)
        throws java.io.IOException {
        // Write out element count, and any hidden stuff
        int expectedModCount = modCount;
        s.defaultWriteObject();

        // Write out size as capacity for behavioral compatibility with clone()
        s.writeInt(size);

        // Write out all elements in the proper order.
        for (int i=0; i<size; i++) {
            s.writeObject(elementData[i]);
        }

        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }
            */
           ArrayList arrayList = new ArrayList();
           LinkedList linkedList = new LinkedList();

           // 默认分配 {}
           //arrayList.add(2,"i");//java.lang.IndexOutOfBoundsException: Index: 2, Size: 0

           linkedList.addLast("1");

           //final List<E> list;
           //synchronized (mutex){}
           Collections.synchronizedList(arrayList);

       }
}
