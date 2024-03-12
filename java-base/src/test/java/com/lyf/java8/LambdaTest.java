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

import com.google.common.collect.Lists;
import com.lyf.common.Person;
import com.lyf.java8.cases.MyPredicate;
import com.lyf.java8.cases.PersonUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author liyunfei
 **/
public class LambdaTest {
    // 注：学习之前，理解Lombok,annotation的设计（需要对 SOURCE，CLASS，RUNTIME 运行周期熟悉）

    // 目标：对Person实现条件 过滤，排序 等功能
    //

    private final List<Person> personList = Arrays.asList(
            new Person("Tom", 18, 11L),
            new Person("Bill", 19, 21L),
            new Person("Mark", 21, 31L)
    );


    /**
     * 工具类实现
     */
    @Test
    public void test1() {
        //Arrays.deepEquals()
        List<Person> people = PersonUtil.filterByAge(personList);
        // ByOtherCondition--
    }

    /**
     * 策略模式优化 ---> 匿名内部类（传入对象） 将逻辑代码交于 对象类处理--
     */
    @Test
    public void test2() {
        // 各种策略类----，可采用Enum维护，SpringBoot中 ，List<> lists 注解--
        // 审核台中的策略处理机制---
        //
        PersonUtil.filter(personList, new MyPredicate<Person>() {
            @Override
            public boolean filter(Person person) {
                return false;
            }
        });
        Comparator<Person> personComparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return 0;
            }
        };

        // lambda 函数表达式：--- 方法参数 ->
        PersonUtil.filter(personList, person -> person.getAge() > 100);

    }

    /**
     * lambda --- 简化匿名内部类
     */

    //--------------
    @Test
    public void test3() {
        // 如何封装Stream的源码？
        personList
                // 封装并行流--
                .stream()
                // Consumer--Lambda
                .filter(person -> person.getAge() > 10)
                // Function
                .map(Person::getName)
                .collect(Collectors.toList());
    }

    /**
     * 基本使用：
     * 本质是匿名内部类的简化：
     * 左侧参数列表，右侧具体实现
     * 无需指定类型，javac会进行类型推断
     */
    @Test
    public void test4() {
        Runnable r = () -> System.out.println("");
        // new Thread(r).start();
        Consumer<String> c = s -> System.out.println("");
        Function<String, String> function = (i) -> "ok";
        System.out.println(function.apply("1"));
        //System.out.println(c.accept("1"));

        // 函数接口：只能一个抽象方法接口，为了做推断？【lambda 只能表示一个 函数--- （参数列表)-具体实现
        // 对比回调函数
        // 所以说 策略、回调这些可以实现更丰富的，但会带来类爆炸的，，若抽象的 同纬度的条件太多，，则采用--，但维度多，条件少，侧策略？

        personList.sort((p1,p2)-> p2.getAge()-p1.getAge());
        personList.stream().forEach(System.out::println);
    }

}
