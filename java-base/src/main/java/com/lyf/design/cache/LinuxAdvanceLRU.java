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

/**
 * @authorliyunfei
 * @date2022/12/25
 **/
public class LinuxAdvanceLRU<T> {
       final int size = 5;
       LRUAlg.LRUCache<T> activeList = new LRUAlg.LRUCache<>(size);
       LRUAlg.LRUCache<T> inActiveList = new LRUAlg.LRUCache<>(size);

     /**
      * 预读的值放置inActiveList(极可能被访问--预测，但是预测失效也不影响activeList,直接在此区间淘汰）
      * 活跃最近被访问的放置activeList,activeList末尾失效放置inActiveList
      * 其实inActiveList类似做了activeList的缓存--还是理解局部性原理--，开辟了多的内存空间，以空间换时间！
      */

}
