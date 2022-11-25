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

package com.lyf.base.oop;

/**
 * 内部类的作用
 * 解决多继承问题，提升灵活性，方便回调。
 * @authorliyunfei
 * @date2022/11/25
 **/
class OuterClass{
      private static int staticVar = 1;
      private int nonStaticVar = 1;
      // 成员内部类
      private class memberClass{
              void method(){
                  System.out.println(nonStaticVar);
                  System.out.println(staticVar);
              }
      }
      private static class staticInnerClass{
             void method(){
                 System.out.println(staticVar);
             }
      }
      void localMethod(){
           final int localVar = 1;
           int localVar2 = 1;
           class LocalClass{
                 void method(){
                     System.out.println(localVar);
                     System.out.println(localVar2);
                 }
           }
           LocalClass localClass = new LocalClass();
           localClass.method();
      }

      interface IPrivateService{
          void method();
      }
      void privateClass(){
           new IPrivateService(){
               @Override
               public void method() {
                   System.out.println("ok");
               }
           };
      }
}
public class ClassObjectTests {

}
