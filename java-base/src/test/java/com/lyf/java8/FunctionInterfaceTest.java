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

import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author liyunfei
 **/
public class FunctionInterfaceTest {
    @Test
    public void test(){
        FunctionInterfaceServiceImpl functionInterfaceService = new FunctionInterfaceServiceImpl();
        // 匿名内部
        functionInterfaceService.consume(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    // 四个核心的函数类

    @Test
    public void test2(){
        Consumer<Integer> consumer = age->{
            if(age>60){
                System.out.println("老年人");
            }else if(age<20){
                System.out.println("小孩儿");
            }
        };
        consumer.accept(1);
        Consumer<List<String>> consumer0 = list->{

        };

        Function<String,String> function = (param)->{
            return "";
        };

        Predicate<String> predicate = (param)-> true;

        Supplier<Integer> supplier = ()->new Random().nextInt();

    }


}
