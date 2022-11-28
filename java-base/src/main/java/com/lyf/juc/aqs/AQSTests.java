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

package com.lyf.juc.aqs;

import org.junit.Test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 注意结合JMM理解
 * volatile,synchronized,lock,cas,aqs,atomic等概念及实现原理
 * 1.volatile (1)保证可见性（2）原子性   ： 禁止重排序，需要结合CPU指令执行，JMM模型，从寄存器，缓存一致性，Java的内存模型思考
 * 2.synchronized 阻塞重量级锁，编译汇编指令处 加 Monitor监控，阻塞
 * 3.Lock 不同的锁实现方式不同，基于 aqs,cas等基础实现 --保证一致性，也是保证线程的原子性操作
 * 4.cas 对比交互算法，硬件CPU实现，Java Unsafe类调用,实现原子性 atomic，基础 ，保证原子性更新
 * 5.atomic Java基础类型原子性操作更新
 * 6.aqs 抽象队列同步器，抽象类 理解为实现lock等的接口，封装--
 * =======基本目标=======
 * 1.都是多线程 去 竞争 资源 需要保证同步、一致性（基本手段就是加锁，控制并发，有序访问公共资源）
 * 可结合MySQL的锁机制，以及MVCC（版本控制，对比CAS，理解ABA问题）
 * 本质问题：资源的合理调度问题、管理学、运筹学
 * 基本的研究对象：内存（主存，JVM的内存（单独抽象了中间层，介于编译器与OS间）），Cache,CPU,抽象的线程（OS层面，语言层面）
 *
 * @authorliyunfei
 * @date2022/11/28
 **/
public class AQSTests {
    /**
     * 1.理解关键：
     * （1）独占资源（ReentrantLock)
     * （2）共享资源 （Semaphore,C..)
     * CLH队列
     *   * To enqueue into a CLH lock, you atomically splice it in as new
     *      * tail. To dequeue, you set the head field, so the next eligible
     *      * waiter becomes first.
     *      *
     *      *  +------+  prev +-------+       +------+
     *      *  | head | <---- | first | <---- | tail |
     *      *  +------+       +-------+       +------+
     *
     */
    @Test
    public void test(){
       // AbstractQueuedSynchronizer;
        //ReentrantLock reentrantLock = new ReentrantLock(); 关注一下 Sync的实现逻辑
//        Thread current = Thread.currentThread();
//        int c = getState();
//        if (c == 0) {
//            if (compareAndSetState(0, 1)) {
//                setExclusiveOwnerThread(current);
//                return true;
//            }
//        } else if (getExclusiveOwnerThread() == current) {
//            if (++c < 0) // overflow
//                throw new Error("Maximum lock count exceeded");
//            setState(c);
//            return true;
//        }
//        return false;
//
        //Semaphore semaphore = new Semaphore(5);

//        for (;;) {
//            if (hasQueuedPredecessors())
//                return -1;
//            int available = getState();
//            int remaining = available - acquires;
//            if (remaining < 0 ||
//                    compareAndSetState(available, remaining))
//                return remaining;
//        }
    }
}
