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
import kilim.tools.P;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 流操作--
 * 关于并行流和串行流的选择问题：
 * 根据数量大小，一般数据大才采用并行流，，，数据量小没有必要，线程开销浪费
 *
 * 总的来说，使用并行流还是串行流取决于数据量大小、处理任务的复杂性以及系统的硬件资源等因素。在选择时需要根据具体情况进行评估，并进行性能测试以确定最优的选择。
 *
 * @author liyunfei
 **/
public class StreamTest {

    private final List<Person> personList = PersonStore.getInstance().getPersonList();


    /**
     * 1.针对的数据源：list、array（array的创建方式）
     * 流的创建方式：
     *
     * 2.中间件操作
     * -过滤、切片、排序、映射
     * 3.终止操作
     * -匹配、查找、收集、规约
     * 重点理解规约
     */
    @Test
    public void test() {
        personList
                .stream()
                // hashcode,equals
                // lombok 的  callSuper问题
                .distinct();

        // 规约，多个合成一个-
        BinaryOperator<Person> binaryOperator = (p1,p2)->new Person("",p1.getAge()+p2.getAge(),1L);

        Optional<Integer> integer = personList.stream()
                .map(Person::getAge)
                .reduce(Integer::sum);



        //.reduce()
        Son son = new Son();
        son.setName("Lyf");
        son.setSkill("ddd");
        Son son2 = new Son();
        son2.setName("1");
        son2.setSkill("ddd");

        /**
         * @EqualsAndHashCode(callSuper = true)
         *
         * false
         * true
         */
        System.out.println(son.equals(son2));
        System.out.println(son.canEqual(son2));


        /**
         * //@EqualsAndHashCode(callSuper = true)
         *
         * true
         * true
         */
        System.out.println(son.equals(son2));
        System.out.println(son.canEqual(son2));

        /**
         * @EqualsAndHashCode
         * true
         * true
         */
        System.out.println(son.equals(son2));
        System.out.println(son.canEqual(son2));
    }


    @Test
    public void testCreate(){
        personList.stream();
        personList.parallelStream();
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        Stream.generate(()->2).limit(10).forEach(System.out::println);
        Stream.generate(()->new Random().nextInt()).limit(10).forEach(System.out::println);
        Stream.iterate(0,a->a+2).limit(10).forEach(System.out::println);

        // sum下面调用的reduce
        // 右开区间【0,1】
        System.out.println(IntStream.range(0, 2).sum());
        // 右闭区间， 【0,1,2】
        System.out.println(IntStream.rangeClosed(0, 2).sum());

        IntStream.range(0,2).parallel()
               // .reduce((a,b)->a+b);
                // 方法引用函数  static Integer sum(a,b)
                .reduce(Integer::sum);
                //.reduce(0,Integer::sum);

    }

    @Test
    public void testCommonOpt(){
        // 分区
        personList.stream().collect(Collectors.groupingBy(Person::getName));
        // 平均，求和--
        //Collectors.


    }


    @Test
    public void testFlatMap(){
        List<String> strings = Arrays.asList("a,b,v","d,c","e,c");
        // 多个流合成一个流
        strings.stream().flatMap(str-> Arrays.stream(str.split(","))).forEach(System.out::println);
        strings.stream().map(str ->Arrays.stream(str.split(",")) ).forEach(stringStream -> {
            stringStream.forEach(System.out::println);
        });
    }

//
//    public static double calculateTotalAmount(List<Order> orders) {
//        return orders.parallelStream()
//                .mapToDouble(Order::getTotalAmount)
//                .sum();
//    }
//
//    public static long countHighValueOrders(List<Order> orders, double threshold) {
//        return orders.parallelStream()
//                .filter(order -> order.getTotalAmount() > threshold)
//                .count();
//    }
//
//    public static List<Order> filterOrdersByCustomer(List<Order> orders, String customerId) {
//        return orders.parallelStream()
//                .filter(order -> order.getCustomerId().equals(customerId))
//                .toList();
//    }


}
