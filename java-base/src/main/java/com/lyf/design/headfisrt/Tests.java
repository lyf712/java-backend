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

package com.lyf.design.headfisrt;

import org.junit.Test;

/**
 * @authorliyunfei
 * @date2022/10/25
 **/
public class Tests {
    @Test
    public void testSubDuck1(){
        SubDuck1 subDuck1 = new SubDuck1();// 动态实现组合行为策略，与类绑定

    }

    @Test
    public void testSubDuck2(){
        SubDuck2 subDuck2 = new SubDuck2();
        subDuck2.setStrategy(new Strategy1());// 行为策略和实现的分离
    }
}
