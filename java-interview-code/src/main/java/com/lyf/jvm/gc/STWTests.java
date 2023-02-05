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

package com.lyf.jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyunfei
 **/
public class STWTests {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            List<byte[]> list = new ArrayList<>();
            while (true){
                for(int i=0;i<100;i++){
                    list.add(new byte[1024]);
                }
                if(list.size()>1000){
                    list.clear();
                    System.gc();
                }
            }
        });
        long start = System.currentTimeMillis();
        Thread thread2 = new Thread(()->{
            while (true){
                System.out.println(System.currentTimeMillis() - start);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();
        thread2.start();

    }
}
