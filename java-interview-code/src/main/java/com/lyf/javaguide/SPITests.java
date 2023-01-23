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

package com.lyf.javaguide;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @author liyunfei
 **/
public class SPITests {
    // 调用方设计标准，具体实现交给具体厂商去实现
    interface SelfProctal{
        void work();
    }

    //
    class HuaweiSelfProctalImpl implements SelfProctal{
        @Override
        public void work() {
            System.out.println("hello,i am huawei..");
        }
    }
    @Test
    public void test(){
        ServiceLoader<SelfProctal> serviceLoader = ServiceLoader.load(SelfProctal.class);
        System.out.println(serviceLoader.stream().count());
        serviceLoader.forEach(each->{
            System.out.println(each);
            each.work();
        });
    }
}
