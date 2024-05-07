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


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * @author liyunfei
 **/
public class AlarmReporter {

    private AlarmQueue alarmQueue = AlarmQueue.getInstance();

    private final Logger logger = LoggerFactory.getLogger(AlarmReporter.class);

    /**
     * 错误实现一.
     * 处理：线程停止问题（需要考虑的问题如下
     * 1、线程是否阻塞、等待其他线程
     * 2、线程是否在执行任务
     * 如何优雅退出！
     * @param alarmInfoList
     */
    public void reportWrongImpl1(List<AlarmInfo> alarmInfoList) {

        alarmInfoList.forEach(alarmInfo -> {
            try {
                alarmQueue.put(alarmInfo);
            } catch (InterruptedException e) {
                logger.error("添加任务失败中断 {}", alarmInfo);
                throw new RuntimeException(e);
            }
        });

        System.out.printf("该次处理告警信息数量为：%s \n", alarmQueue.size());
        logger.info("该次处理告警信息数量为：{}", alarmQueue.size());

        Thread thread = new Thread(() -> {
            while (true) {
                Thread curThread = Thread.currentThread();
                if (curThread.isInterrupted()) {
                    System.out.printf("处理中断，中断时任务数量为：%s \n", alarmQueue.size());
                    logger.info("处理中断，中断时任务数量为：{}", alarmQueue.size());
                    break;
                }

                // 改进：加在这里，放在自己的线程--可控--，，，也方便，外部线程的快速响应---
                // 那么外部如何知道真的结束了，发个消息过去，或者轮询接口（状态
//                if(alarmQueue.size()<=0){
//                    curThread.interrupt();
//                }

                try {
                    AlarmInfo take = alarmQueue.take();
                    TimeUnit.MILLISECONDS.sleep(40);
                    System.out.printf("上报信息：%s \n", take.getId());
                } catch (InterruptedException e) {
                    logger.error("获取任务中断..");
                    throw new RuntimeException(e);
                }
            }
        });

        thread.start();

        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //冰河举例：： 该处处理逻辑也不对？？ 应该 阻塞住---？
//        if (alarmQueue.size() <= 0) {
//            thread.interrupt();
//        }
        // thread.interrupt();

        // 该种实现，若出现某个中断，， alarmQueue 还是这么多 则空转---
//        while (alarmQueue.size() > 0){
//
//        }
//        thread.interrupt();

        System.out.printf("处理完毕，任务数量为：%s \n", alarmQueue.size());
        logger.info("处理完毕，任务数量为：{}", alarmQueue.size());
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void twoPhaseHandle(){

    }
}
