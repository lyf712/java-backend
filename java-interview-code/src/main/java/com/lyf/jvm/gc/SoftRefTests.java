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

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author liyunfei
 **/
public class SoftRefTests {
    static class User{
        String name;
        public User(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        SoftReference<User> userSoftReference = new SoftReference<>(new User("lyf"));

        System.gc();
        System.out.println("GC:");
        System.out.println(userSoftReference.get());

        try {
            byte[]bytes = new byte[1024 * 1024 *2 + (10240-5035)*1024];
        }catch (Throwable throwable){
            //java.lang.OutOfMemoryError: Java heap space
            //	at com.lyf.jvm.gc.SoftRefTests.main(SoftRefTests.java:47)
            throwable.printStackTrace();
        }finally {
            System.out.println(userSoftReference.get());
        }


        WeakReference<User> userWeakReference = new WeakReference<>(new User("ok"));

        System.gc();
        //
    }
}
