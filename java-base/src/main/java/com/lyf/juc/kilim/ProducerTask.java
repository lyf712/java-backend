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

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author liyunfei
 **/
public class ProducerTask extends Task<Object> {

    private final static AtomicLong count = new AtomicLong(0);

    private Integer indexNo = null;

    // 用户态进行通信（MQ的 ，对比工作内存和主内存的切换 的效率
    private Mailbox<Object> mailbox=null;

    public ProducerTask(Integer indexNo, Mailbox<Object> mailbox) {
        this.indexNo = indexNo;
        this.mailbox = mailbox;
    }

    @Override
    public void execute() throws Pausable, Exception {
        for(int i=0;i<10;i++){
            String uuid = UUID.randomUUID().toString();
            // 若满了，则阻塞住
            mailbox.put(uuid);
            count.incrementAndGet();
            System.out.println(Thread.currentThread().getName()+":生产者-"+indexNo + ":生成产品编号-"+uuid+" 共 "+count.get());
        }
    }


}
