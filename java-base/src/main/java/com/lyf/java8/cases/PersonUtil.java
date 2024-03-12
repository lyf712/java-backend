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

package com.lyf.java8.cases;

import com.lyf.common.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyunfei
 **/
public class PersonUtil {

    public static List<Person> filterByAge(List<Person> personList) {
        final List<Person> newPersonList = new ArrayList<>();
        for (Person person : personList) {
            if (person.getAge() > 20) {
                newPersonList.add(person);
            }
        }
        return newPersonList;
    }

    public static List<Person> filter(List<Person> personList, MyPredicate<Person> myPredicate) {
        final List<Person> newPersonList = new ArrayList<>();
        for (Person person : personList) {
            if (myPredicate.filter(person)) {
                newPersonList.add(person);
            }
        }
        return newPersonList;
    }
}
