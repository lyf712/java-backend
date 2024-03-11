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

package com.lyf.juc;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 练习回顾
 * @author liyunfei
 **/
public class PracticeReviewTests {
    ReentrantLock lock=new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    @Test
    public void test1(){
        new Thread(new Worker(condition2,condition3,"printer-2")).start();
        new Thread(new Worker(condition3,condition1,"printer-3")).start();
        new Thread(new Worker(condition1,condition2,"printer-1")).start();


        ;//.run();
//        new Worker(condition2,condition3,"printer-2").run();
//        new Worker(condition3,condition1,"printer-3").run();
        System.out.println("notify start work");
        lock.lock();
        // 需要通知所有线程-
        condition1.signalAll();
        lock.unlock();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private class Worker implements Runnable{
        private Condition condition;
        private Condition nextCondition;
        private String name;

        public Worker(Condition condition, Condition nextCondition, String name) {
            this.condition = condition;
            this.nextCondition = nextCondition;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("waiting - " + name);
                condition.await();
                System.out.printf("print - name - %s",name);
                nextCondition.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                //对应只有一个线程，signal也行？

                lock.unlock();
            }

        }
    }
}
