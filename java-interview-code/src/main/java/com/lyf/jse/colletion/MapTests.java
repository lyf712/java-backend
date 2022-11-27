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

package com.lyf.jse.colletion;

import org.junit.Test;

import java.util.HashMap;

/**
 * @authorliyunfei
 * @date2022/11/25
 **/
public class MapTests {
    @Test
    public void testHashMap(){
        /**
         1.基本概述：基于hash的Map接口实现，。。。
         2.特性：kek-value键值对，非线程安全，null值。。
         3.底层数据结构：数组+链表
         4.操作特性：putVal
         5.hash冲突解决的理解
         6.ConcrrentHashMap如何保证线程安全

         // 异或减少碰撞几率
         return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
         public final int hashCode() {
         return Objects.hashCode(key) ^ Objects.hashCode(value);
         }

         */

        HashMap hashMap = new HashMap();
    }

}
