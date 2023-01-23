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

package com.lyf.javaguide;

import java.util.Random;

/**
 * @author liyunfei
 **/
public class GenericsTests {
    // 泛型类
    class GenricsClass<T> {
        T key;

    }
    interface GenricsI<T>{

    }
    public /*static*/  <E> E method(E[]input){
        return input[new Random().nextInt(input.length)];
    }
}
