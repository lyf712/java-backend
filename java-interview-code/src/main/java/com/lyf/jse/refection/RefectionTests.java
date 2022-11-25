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

package com.lyf.jse.refection;

/**
 * @authorliyunfei
 * @date2022/11/25
 **/
public class RefectionTests {
    // 获取 class的三种方式
    public void testGetClass() throws ClassNotFoundException{
           Class sampleClass1 = Class.forName("com.lyf.jse.refection.SampleClass");
           Class sampleClass2 = SampleClass.class;
           SampleClass sampleClassObj = new SampleClass();
           Class<? extends SampleClass> sampleClass3 = sampleClassObj.getClass();

           // 获取了class，则可进行获取有关类的属性以及调用操作（class类型，annotion,class,interface,  filed,method,...)
    }
}
