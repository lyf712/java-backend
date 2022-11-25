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

package com.lyf.jse.lang;

import org.junit.Test;

/**
 * @authorliyunfei
 * @date2022/11/25
 **/
public class IntergerTests {
    @Test
    public void test(){
           Integer a = new Integer(1);
           Integer b = 1;
           int c = 1;
           // -128 - 127之间自动拆箱不new新对象
           System.out.println(a==b);//false
           System.out.println(c==b);//true
           System.out.println(a==c);//true 自动拆箱

           Integer d = 128;
           Integer e = 128;
           int m = 128;
           Integer f = 127;
           Integer g = 127;
           System.out.println(d==e);//false
           System.out.println(d==m);//true
           System.out.println(f==g);//true
    }
}
