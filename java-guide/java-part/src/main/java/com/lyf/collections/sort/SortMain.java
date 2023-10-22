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

package com.lyf.collections.sort;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * @author liyunfei
 **/
public class SortMain {
    public static void main(String[] args) {
        List<Person> arrayList = Lists.newArrayList(new Person("p1",1),
                new Person("p0",0), new Person("p3",3)); //new ArrayList<>();
        arrayList.sort(new Comparator<Person>() {
            // compare(o1,o2) > 0 , swap(,)
            // o1:j-1,o2:j
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        arrayList.forEach(System.out::println);

        Collections.sort(arrayList);

        TreeMap<String,Person> personTreeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        personTreeMap.put("h1",new Person("p0",0));
        personTreeMap.put("h2",new Person("p2",2));
        personTreeMap.put("h3",new Person("p1",1));
        personTreeMap.put("h4",new Person("p3",3));

        personTreeMap.forEach((key, value) -> System.out.println(value));

    }
}
