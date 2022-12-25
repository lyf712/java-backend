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

package com.lyf.design.cache;

import java.util.LinkedList;

/**
 * @authorliyunfei
 * @date2022/12/25
 **/
public class LRUAlg {
       private static class Page{

       }
       public static class LRUCache<T>{
               private int size = 5;
               private LinkedList<T> cache;

               public LRUCache(int size) {
                      this.size = size;
                      cache = new LinkedList<>();
               }

               void read(T data){
                      if(cache.contains(data)){
                          // 移除--
                          cache.remove(data);
                      }else {
                          // 淘汰末尾
                          if(cache.size()==size){
                              cache.removeLast();
                          }
                      }
                      cache.addFirst(data);
               }
       }



}
