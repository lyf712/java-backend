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

/**
 * 引用计数算法理解.
 * @author liyunfei
 **/
public class RefCountTests {
    private byte[] bytes = new byte[10*1024];
    private RefCountTests ref = null;

    public static void main(String[] args) {
        RefCountTests obj1 = new RefCountTests();
        RefCountTests obj2 = new RefCountTests();
        obj1.ref = obj2;
        obj2.ref = obj1;
        //
        //System.gc();
    }
}
