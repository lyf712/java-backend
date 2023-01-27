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

package com.lyf.jvm;

/**
 * @author liyunfei
 **/
public class MathDemo {
    private static int a = 1;
    public int compute(){// 一个栈帧对应一个方法
        int a = 1;
        int b = 2;
        int c = (a+b) * 10;
        return c;
    }
    /*
    1.加载类，将类的相关信息、静态变量加载至方法区
    2.压入main栈帧至虚拟机栈（静态方法和非静态方法在JVM的区别表现？
    3.MathDemo 创建对象（五个步骤：加载、分配空间、初始化值、设置对象头、init
    4.MathDemo的符号引用
    5.压入compute栈帧 -> 进行操作栈临时计算、返回结果
    6.00
     */
    public static void main(String[] args) {
        MathDemo mathDemo = new MathDemo();
        int rs = mathDemo.compute();
        System.out.println(rs);
    }
}
