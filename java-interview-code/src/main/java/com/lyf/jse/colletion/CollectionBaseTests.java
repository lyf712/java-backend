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
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @authorliyunfei
 * @date2022/11/25
 **/
public class CollectionBaseTests {
    class Student{

    }
    @Test
    public void test(){
           List<Object> list = new ArrayList<>();
           list.add(new Integer(1));
           list.add(new Student());
           for (Object o:list){
               if(o instanceof Integer){

               }
           }

           // fail-fast
           List list1 = new ArrayList();
           //https://blog.csdn.net/u012723673/article/details/80699029  transient的理解
           //  synchronized (lock) {} final transient Object lock = new Object();
           List list2 = new CopyOnWriteArrayList();

           // 对比加final?
           Collection<Object> collection = Collections.unmodifiableCollection(new ArrayList<>());
           final ArrayList arrayList = new ArrayList();
           arrayList.add(1);
           Collection<Object> collection1 = Collections.unmodifiableList(arrayList);
           arrayList.add(2);
           collection1.forEach(u->{
               System.out.println(u);
           });//1,2
           //collection1.add(3);//java.lang.UnsupportedOperationException
           arrayList.add(3);
           /*
         static class UnmodifiableList<E> extends UnmodifiableCollection<E>
                                  implements List<E> {
        @java.io.Serial
        private static final long serialVersionUID = -283967356065247728L;

        @SuppressWarnings("serial") // Conditionally serializable
        final List<? extends E> list;
            */
           collection1.forEach(u->{
            System.out.println(u);
           });//1,2,3


        // Random Access 支持 O(1)获取，建议 for遍历，否则 iterator遍历

    }
}
