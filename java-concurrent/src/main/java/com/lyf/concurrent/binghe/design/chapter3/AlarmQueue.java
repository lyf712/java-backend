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

package com.lyf.concurrent.binghe.design.chapter3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author liyunfei
 **/
public class AlarmQueue {

    private BlockingQueue<AlarmInfo> blockingQueue = new ArrayBlockingQueue<>(1024);

    private static class Holder {
        private final static AlarmQueue INSTANCE = new AlarmQueue();
    }

    public static AlarmQueue getInstance() {
        return Holder.INSTANCE;
    }

    public void put(AlarmInfo alarmInfo) throws InterruptedException {
        blockingQueue.put(alarmInfo);
    }

    public AlarmInfo take() throws InterruptedException {
        return blockingQueue.take();
    }

    public int size(){return blockingQueue.size();}
}
