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

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @authorliyunfei
 * @date2022/11/26
 **/
public class NewObjectProcess {
    /**
     * 1.方法区常量池查看类信息（是否加载过
     * 2.Loader加载类信息
     * 3.分配内存空间（注意并发考虑（CAS），垃圾回收线程池的准备工作）
     * 4.解析class的信息
     * 5.初始化，<init>
     */
    @Test
    public void test() throws IOException, ClassNotFoundException {
           Object o = new Object();
           Class clazz = o.getClass();
           try {
               Object o2 = clazz.newInstance();
           } catch (InstantiationException | IllegalAccessException e) {
               throw new RuntimeException(e);
           }
           // 序列化读入
           ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(""));
           objectInputStream.readObject();
    }

}
