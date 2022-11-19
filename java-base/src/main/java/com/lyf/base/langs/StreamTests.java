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

package com.lyf.base.langs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * @authorliyunfei
 * @date2022/11/19
 **/
class Person{
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
public class StreamTests {
    @Test
    public void test(){
           List<Person> list = new ArrayList<>();

           //list.stream().map().reduce();
//        Function<String,String> function = new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return null;
//            }
//        };


        //Consumer、Supplier、Predicate、Function
        List<Integer> list1 = list.stream().map(person -> {return person.getAge();}).toList();
                //.reduce();
        Optional<Integer> integer = list1.stream().reduce(Integer::max);
    }
}
