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

package com.lyf.juc;

/**
 * @author liyunfei
 **/
public class VolatileTest {
    //DCL的半初始化问题理解->指令重排序；保证可见性和有序性（指令重排）
    // 重排的原则：as-if-serial happen-before
    // 需要结合对象的初始化过程
    private static VolatileTest instance = null;
    private VolatileTest(){

    }
    public static VolatileTest getInstance(){
        instance = new VolatileTest();
        return instance;
    }

    static class Singleton{
        private static int val = 10;//初值零值
        private static volatile Singleton instance = null;//volatile在底层通过lock前缀指令【汇编级别】进行了内存屏障、指令禁止重排序
        private Singleton(){

        }
        public static Singleton getSingleton(){
            if(instance==null){
                synchronized (Singleton.class){
                    if(instance==null){
                        //'com.lyf.juc.VolatileTest.this' cannot be referenced from a static context
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }

}
