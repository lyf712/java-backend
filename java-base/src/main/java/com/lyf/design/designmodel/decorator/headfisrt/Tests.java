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

package com.lyf.design.designmodel.decorator.headfisrt;

import org.junit.Test;

/**
 * @authorliyunfei
 * @date2022/11/6
 **/
public class Tests {
    @Test
    public void test1(){
        Decorator decorator = new Decorator1(new Decorator2(new ConcreteComponent1()));
        decorator.method();// 递归过程--- 由外至内；；；对比直接采用List存储装饰的类
//        com.lyf.design.designmodel.decorator.headfisrt.Decorator1 decorator handle
//        com.lyf.design.designmodel.decorator.headfisrt.Decorator2 decorator handle
//        ConcreteComponent1 execute method


    }
}
