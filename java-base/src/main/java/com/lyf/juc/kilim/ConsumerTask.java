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

package com.lyf.juc.kilim;

import kilim.Mailbox;
import kilim.Pausable;
import kilim.Task;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author liyunfei
 **/
public class ConsumerTask extends Task<Object> {

    private static final AtomicLong count = new AtomicLong(0);

    private Mailbox<Object> mailbox  = null;

    public ConsumerTask(Mailbox<Object> mailbox) {
        this.mailbox = mailbox;
    }

    @Override
    public void execute() throws Pausable, Exception {
        for(int i=0;i<10;i++){
            // 做协议
            Object o = mailbox.get();
            System.out.println("消费：" + o);
            count.incrementAndGet();
            System.out.printf("第 %d 消费%n",count.get());
        }
    }
}
