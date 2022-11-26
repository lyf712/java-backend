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

import java.util.ServiceLoader;

/**
 * @authorliyunfei
 * @date2022/11/26
 **/
public class ClassLoaderCompressor {
    interface IService{

    }
    class Service1 implements IService{}
    class Service2 implements IService{}
    /**
     * ClassLoader的分类、双亲委派模型的原因
     */
    @Test
    public void test() throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        //classLoader.loadClass("");
        //   return forName0(className, true, ClassLoader.getClassLoader(caller), caller);
        //Class.forName("");

        ServiceLoader<IService> services = ServiceLoader.load(IService.class);
        //     ClassLoader cl = Thread.currentThread().getContextClassLoader();
        //        return new ServiceLoader<>(Reflection.getCallerClass(), service, cl);

        System.out.println(services.stream().toArray().length);
        services.forEach(System.out::println);
    }

    public static void main(String[] args) {
        ServiceLoader<IService> services = ServiceLoader.load(IService.class);
        //     ClassLoader cl = Thread.currentThread().getContextClassLoader();
        //        return new ServiceLoader<>(Reflection.getCallerClass(), service, cl);

        System.out.println(services.stream().toArray().length);//0???
        services.forEach(System.out::println);
    }
}
