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

package org.example.base;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liyunfei
 **/
public class StreamTest {
    private class Apple{
        double weight;

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }
    }
    private class inventory{
        private List<Apple> store = new ArrayList<>(8);
        private static double threshold = 15.0;
        public static boolean filterWeihtApple(Apple apple){return apple.getWeight()>threshold;}
        public List<Apple> getWeihtAppleList(){
//            return store.stream().filter(new Predicate<Apple>() {
//                @Override
//                public boolean test(Apple apple) {
//                    return apple.weight>threshold;
//                }
//            }).collect(Collectors.toList());
            return store.stream()
                    .filter(inventory::filterWeihtApple)
                    .collect(Collectors.toList());
        }
    }

    @Test
    public void test(){
        int x = 1;
        final int y = 2;
        List<Integer> list = new ArrayList<>(3);
        list.forEach(e->{
            System.out.println(y*2);
            //x = 1;
        });
        list.stream().filter(integer -> integer>2).toArray();

//        new File(":").listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return false;
//            }
//        })
//        File[]files = new File("")
//                .listFiles(new FileFilter() {
//                    @Override
//                    public boolean accept(File pathname) {
//                        return pathname.isHidden();
//                    }
//                })
                //.listFiles(pathname -> pathname.isHidden());
                //.listFiles(File::isHidden)

    }

    @Test
    public void testFilterApple(){
          // ingore
    }

    @Test
    public void testCollection(){
        class Person {
            String name;
            String group;
            int age;

            public Person(String name, String group, int age) {
                this.name = name;
                this.group = group;
                this.age = age;
            }
        }
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("","",12));
//        Map<String,List<Person>> groups = personList.stream()
//                .filter((person -> person.age>15))
                //.collect();

    }
}
