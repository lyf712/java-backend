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

package com.lyf.sample;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import org.junit.Test;

/**
 * @author liyunfei
 **/
public class CatTests {
    @Test
    public void test() throws Exception {
        Transaction t = Cat.newTransaction("Check1", "name");
        Transaction t3 = Cat.newTransaction("Check2", "name");
        for (int i = 0; i < 2080; i++) {
            Transaction t4 = Cat.newTransaction("Check3", "name");
            t4.complete();
        }
        t3.complete();
        t.complete();

        Thread.sleep(1000); // 此处 sleep 一会, 就能保证 CAT 异步消息发送
    }
}
