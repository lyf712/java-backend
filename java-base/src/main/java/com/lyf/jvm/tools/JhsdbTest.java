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

package com.lyf.jvm.tools;

/**
 * <h3>jhsdb可视化工具测试</h3>
 * @author liyunfei
 **/
public class JhsdbTest {
       static class Test{
           // 静态实例，位于方法区
           static TestInstanceHolder testInstanceHolder = new TestInstanceHolder();
           // 普通实例，位于堆
           TestInstanceHolder instanceHolder = new TestInstanceHolder();
           void foo(){
               // 局部（位于栈帧
               TestInstanceHolder localInstance = new TestInstanceHolder();
               System.out.println("done");
           }
       }
       private static class TestInstanceHolder{

       }

       public static void main(String[] args) {
           Test test = new Test();
           test.foo();
       }
}
