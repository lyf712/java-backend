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

package com.lyf.java8;

import com.lyf.common.Person;

import java.util.Arrays;
import java.util.List;

/**
 * @author liyunfei
 **/
public class PersonStore {

    private final List<Person> personList = Arrays.asList(
            new Person("Tom", 18, 11L),
            new Person("Bill", 19, 21L),
            new Person("Mark", 21, 31L)
    );

    public List<Person> getPersonList() {
        return personList;
    }

    private PersonStore(){}

    private static final class Holder{private static final PersonStore INSTANCE = new PersonStore();}

    public static PersonStore getInstance(){return Holder.INSTANCE;}

}
