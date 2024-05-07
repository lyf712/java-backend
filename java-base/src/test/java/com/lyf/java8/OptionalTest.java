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
import org.junit.Test;

import java.util.Optional;

/**
 * @author liyunfei
 **/
public class OptionalTest {
    @Test
    public void test(){
        Optional<String> stringOptional = Optional.of("");
        stringOptional = Optional.empty();//Optional.ofNullable(null);
        //stringOptional.ifPresent();
        //stringOptional.orElseThrow(new IllegalArgumentException(""))
        stringOptional.orElseThrow(()->{throw new IllegalArgumentException("");});

        String text = null;
        String aDefault = Optional.ofNullable(text).orElse("default");
        System.out.println("1::"+aDefault);

        aDefault = Optional.ofNullable(text).orElseGet(()->"default");
        System.out.println("2::"+aDefault);


    }

    @Test
    public void test2(){
        handle(null);
        handle(new Person(null,1,12L));
        handle(new Person("xiaoming",1,12L));
    }

//    public Optional<Address> getAddressByOrderId(String orderId) {
//        return getOrderById(orderId)
//                .flatMap(order -> getCustomerById(order.getCustomerId()))
//                .flatMap(customer -> getAddressByCustomerId(customer.getId()));
//    }

    private void handle(Person person){
        String defaultName = Optional.ofNullable(person)
                .map(Person::getName)
                .orElse("defaultName");
        System.out.println(defaultName);
    }
}
