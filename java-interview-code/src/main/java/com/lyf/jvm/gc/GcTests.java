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

package com.lyf.jvm.gc;

/**
 * @author liyunfei
 **/
public class GcTests {
    public void test1(){
        byte[] bytes = new byte[1024*10];
        System.gc();
    }
    public void test2(){
        byte[] bytes = new byte[1024*10];
        bytes = null;
        System.gc();
    }
    public void test3() {
        {
            byte[] bytes = new byte[1024*10];
        }
        System.gc();
    }
    public void test4(){
        {
            byte[] bytes = new byte[1024*10];
        }
        int value = 1;
        System.gc();
    }
    public void test5(){
        test1();
        System.gc();
    }
}
