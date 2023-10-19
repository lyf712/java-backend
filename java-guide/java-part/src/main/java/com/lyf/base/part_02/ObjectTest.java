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

package com.lyf.base.part_02;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * @author liyunfei
 **/
class Person{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        ///return super.hashCode();
        //Objects.hash()
        return name.hashCode() | age.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.name, ((Person) obj).name) ;
    }
}
public class ObjectTest {
    public static void main(String[] args) {
        HashSet<Person> hashSet = new LinkedHashSet<>();
        Person person1= new Person("ok",1);
        Person person2= new Person("ok",1);
        System.out.println(hashSet.add(person1));
        System.out.println(hashSet.add(person2));
        System.out.println(hashSet.size());


        System.out.println(person1==person2);
        System.out.println(person1.equals(person2));
        System.out.println(person1.hashCode() + ":" + person2.hashCode());

    }
}
