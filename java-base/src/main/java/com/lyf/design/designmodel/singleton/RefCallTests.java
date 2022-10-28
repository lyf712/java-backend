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

package com.lyf.design.designmodel.singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @authorliyunfei
 * @date2022/10/26
 **/
public class RefCallTests {
    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //MySingleton mySingleton = new MySingleton();
        Class<MySingleton> clazz = MySingleton.class;
        //Constructor<MySingleton> constructor = clazz.getConstructor(MySingleton.class);
        //Constructor<MySingleton> constructor1 = clazz.getDeclaredConstructor();// 不关权限 MySingleton.class

        //MySingleton mySingleton = constructor.newInstance();
        //mySingleton.exec();
        //MySingleton mySingleton = constructor1.newInstance(new Object[]{}); IllegalAccessException
        //mySingleton.exec();


        Constructor<MySingleton>[] constructors = (Constructor<MySingleton>[]) clazz.getDeclaredConstructors();
        for(Constructor<MySingleton> constructor:constructors){
            System.out.println(constructor.getName()+":"+constructor.getParameterCount());
            constructor.setAccessible(true);// 设置可见性
            constructor.newInstance(null).exec();
        }
    }
}
