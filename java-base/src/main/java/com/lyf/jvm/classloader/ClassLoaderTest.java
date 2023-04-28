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

package com.lyf.jvm.classloader;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author liyunfei
 **/
public class ClassLoaderTest {
    final static String CLASS_PATH = "com.lyf.jvm.classloader.TestClass";

    static {
        System.out.println("ClassLoaderTest init~");
    }

    @Test
    public void test() throws ClassNotFoundException {
          ClassLoader classLoader = ClassLoader.getSystemClassLoader();
          Class<?> clazz = classLoader.loadClass("com.lyf.jvm.classloader.TestClass");
          //clazz.newInstance();
          for(Field field:clazz.getFields()){
              System.out.println(field);
          }
    }

    /**
     * @TCDESC:测试加载触发的时机（六种情况
     * @TSTEP:
     * @ES
     */
    @Test
    public void testLoad() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
           //System.out.println(SubClass.CONSTANT_VAL); -- 编译期加载至常量池
           // SubClass.method();
           //  new SubClass();

            SubClass[] subClasses = new SubClass[10];// 数组是JVM虚拟机直接，而非类加载器~

          // Class.forName("com.lyf.jvm.classloader.SubClass");


        // ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        // classLoader加载进来，未初始化，需要newIn..才~~
        /// Class<?> clazz = classLoader.loadClass("com.lyf.jvm.classloader.SubClass");
        //clazz.newInstance();
        //clazz.getFields();
       // Class
    }

    /**
     * @TCDESC:测试不同加载器加载类
     */
    @Test
    public void testDifClassLoader() throws ClassNotFoundException {
        MyClassLoader myClassLoader = new MyClassLoader();
        MyClassLoader2 myClassLoader2 = new MyClassLoader2();
        Class<?> clazz1 = myClassLoader.loadClass(CLASS_PATH);
        Class<?> clazz2 = myClassLoader2.loadClass(CLASS_PATH);
        // 都是父类加载器加载的？
        System.out.println(clazz1.equals(clazz2));

     }


}
