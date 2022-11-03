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

package com.lyf.demo.storage;

import java.util.LinkedList;
import java.util.List;

/**
 * @authorliyunfei
 * @date2022/11/3
 **/
public class DB {

    public static List<String> bufferPool = new LinkedList<>();
    public static synchronized boolean putData(List<String> content,int executeId){
        System.out.println("id:"+executeId+"::存储");
           for(String c:content){
               bufferPool.add(c);
           }
           return true;
    }

    static {
       for(;;){
           bufferPool.forEach(content->{

           });
           // JSON\序列化至文件存储
           if(bufferPool.size()==0){
               break;
           }
       }
    }
}
