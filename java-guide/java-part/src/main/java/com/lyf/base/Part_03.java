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

package com.lyf.base;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @author liyunfei
 **/
@TestAnnoation
public class Part_03 {

    @TestAnnoation
    private String filed;

    //private final Logger

//    private static void printListEventListeners(List<? extends Event> listeners){
//
//    }
//
//    private static void printListEventListeners2(List<? super Event> listeners){
//
//    }

    public static void main(String[] args) {

        EventListener<?> listener = new ConfigChangeEventListener();

        //EventListener<? super Event> listener1 = new ConfigChangeEventListener();

       // EventListener<? extends Event> listener2 = new ConfigChangeEventListener();

        listener = new EventListener<Event>() {
            @Override
            public void onReceive(Event event) {

            }
        };

        try {
            int i =1/0;

        }catch (ArithmeticException e){
            System.out.println(JSON.toJSONString(e));
            e.printStackTrace();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            //e.getMessage()

        }finally {

        }
    }

    private static void reflection( @TestAnnoation String param){

        //EventCenter.class.cast()
          Class<?> clazz = EventCenter.class;




    }
}

