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

package com.lyf.jvm.classloader;

/**
 * @author liyunfei
 **/
public class ComprehensiveInit {
    static class InitCDemo{
        static {
            if(true){
                System.out.println(Thread.currentThread().getName()+" init the InitDemo Class!");
                for(;;){
                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " init before");
                InitCDemo initCDemo = new InitCDemo();
                System.out.println(Thread.currentThread().getName() + " init after");
            }
        };
        // 竞争创建 <clinit>
        new Thread(r).start();
        new Thread(r).start();
        // new Thread().join();
        // 另外一个阻塞线程进行主动释放呢~~，
    }
}
