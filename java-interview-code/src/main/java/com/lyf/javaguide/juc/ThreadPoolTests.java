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

package com.lyf.javaguide.juc;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author liyunfei
 **/
public class ThreadPoolTests {
    @Test
    public void test(){
        //new ThreadPoolExecutor()
        //new Semaphore()
        //new CountDownLatch(5);
        //AbstractQueuedSynchronizer
        /*
         class BooleanLatch {
         private static class Sync extends AbstractQueuedSynchronizer {
             boolean isSignalled() { return getState() != 0; }
              protected int tryAcquireShared(int ignore) {
                return isSignalled() ? 1 : -1;      }
                protected boolean tryReleaseShared(int ignore) {
                     setState(1);        return true;      }    }
               private final Sync sync = new Sync();
               public boolean isSignalled() { return sync.isSignalled(); }
                public void signal()         { sync.releaseShared(1); }
                public void await() throws InterruptedException {      sync.acquireSharedInterruptibly(1);    }  }
         */
    }
}
