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

/**
 * 对象：  数据类型（int,引用）
 * 针对：主内存和工作内存交互：load\store
 * 针对基本数据类型： 运算指令
 * 针对引用对象：new，
 *
 * 其他：同步指令
 * 操作记录：操作栈
 *
 * @author Hang YU
 **/
public class ByteCodeTests {

    @Test
    public void test(){
        // new 对象
        RefTypeDo refTypeDo=new RefTypeDo(1,"name");

        // 方法调用
        refTypeDo.compute(1,2);

        // 同步 & 异常
        synchronized (this){
            refTypeDo.exception();
        }

    }




}
