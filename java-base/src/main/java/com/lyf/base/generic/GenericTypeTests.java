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

package com.lyf.base.generic;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author liyunfei
 **/
public class GenericTypeTests {
    /**
     * 理解擦除式泛型及背景原因.
     */
    @Test
    public void test_1(){
        PersonService<String> personService = new PersonService<>();
        personService.set(new Person());
    }

    @Test
    public void test_2(){
        // 测试
        String str = "hello";
        HashMap<String,String> map = new HashMap<>();
        map.put("你好","ok");
        System.out.println(map.get("你好"));
    }

    @Test
    public void test_3(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        for(int i:list){
            System.out.println(i);
        }
    }
}
