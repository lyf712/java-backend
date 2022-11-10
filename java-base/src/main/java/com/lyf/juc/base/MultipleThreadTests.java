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

package com.lyf.juc.base;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @authorliyunfei
 * @date2022/11/10
 **/
public class MultipleThreadTests {

    void printTheadInfo() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        int counter = 0;
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(counter++ + "" + threadInfo.getThreadName());
        }
    }

    @Test
    public void testTestProcess() {
        printTheadInfo();
        /**
         0main
         1Reference Handler
         2Finalizer
         3Signal Dispatcher
         4Attach Listener
         5Common-Cleaner
         6Monitor Ctrl-Break
         7Notification Thread
         */
    }

    // 主程序入口
    /*
    0main
1Reference Handler
2Finalizer
3Signal Dispatcher
4Attach Listener
5Common-Cleaner
6Monitor Ctrl-Break
7Notification Thread
     */
    public static void main(String[] args) {
        new MultipleThreadTests().printTheadInfo();
    }
}
