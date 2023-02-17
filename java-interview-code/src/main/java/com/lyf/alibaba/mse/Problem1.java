///*
// *    Copyright 1999-2022  lyf712
// *
// *    Licensed under the Apache License, Version 2.0 (the "License");
// *    you may not use this file except in compliance with the License.
// *    You may obtain a copy of the License at
// *
// *        http://www.apache.org/licenses/LICENSE-2.0
// *
// *    Unless required by applicable law or agreed to in writing, software
// *    distributed under the License is distributed on an "AS IS" BASIS,
// *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// *    See the License for the specific language governing permissions and
// *    limitations under the License.
// */
//
//package com.lyf.alibaba.mse;
//
///**
// * @author liyunfei
// **/
//public class Problem1 {
//    1.给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
//    例如：
//    输入：[3,35,5,8]
//    输出：85353
//
//    /**
//     * 思路：
//     * 采用贪心算法，将前面的数大的放在前面，再进行排序
//     */
//    public Integer sovle(int[]nums){ // 返回的值边界考虑？
//        String[]strs = new String[nums.length];// 转换为strs方便进行排序操作
//        for(int i=0;i<nums.length;i++){
//            strs[i] = nums[i]+"";
//        }
//        Arrays.sort(strs,(str1,str2)->{ // 注意比较的考虑
//            int len1 = str1.length();
//            int len2 = str2.length();
//            for(int i=0;i<Math.min(len1,len2);i++){
//                if(str1.charAt(i) > str2.charAt(i)){
//                    return true;
//                }else(str1.charAt(i) < str2.charAt(i)){
//                    return false;
//                }
//            }
//            // 不一样长的情况考虑，需要判断长的那位后面一位的情况
//            if(len1>len2){
//                char tmp = str1.charAt(len2);
//                if(tmp>str2.charAt(0)){
//                    return true;
//                }
//            }else if(len1<len2){
//                char tmp = str2.charAt(len1);
//                if(tmp>str1.charAt(0)){
//                    return true;
//                }
//            }
//            return false;
//        });
//        StringBuffer rs=new StringBuffer();
//        for(String str:strs){
//            rs.append(str);
//        }
//        return Integer.valueOf(rs.toString());
//    }
//
//2.实现一个适合高并发场景的LRU缓存
//
//    /**
//     * LRU：最近最久未被使用；
//     * 数据结构：双链表 + 哈希表
//     * 高并发--：读写并发考虑
//     */
//
//    public class LRUCache<K,V>{//
//        private final int DEFAULT_CAPACITY = 4;
//        private int capacity;
//        private Entry head,tail;
//        private Map<K,Entry> cache;
//        private ReetrantLock lock = new ReetrantLock();
//        class Entry{
//            private K key;
//            private V value;
//            Entry pre,next;
//            public Entry(K key,V value){
//                this.key = k;
//                this.value = value;
//            }
//        }
//
//        public LRUCache(){
//            LRUCache(DEFAULT_CAPACITY);
//        }
//
//        public LRUCache(int capacity){
//            this.capacity = capacity;
//            this.cache = new ConcurrentHashMap<>(capacity);
//            this.head.next = tail;
//            this.tail.pre = head;
//        }
//
//        /**
//         *
//         * @param key 缓存的key.
//         */
//        public V get(K k){
//            Entry node = cache.get(k);
//            // 未有该键值的缓存
//            if(node==null){
//                return null;//
//            }else{
//                try{
//                    lock.lock();
//                    moveAtNode(node);
//                    addAtHead(node);
//                }finally{
//                    lock.unlock();
//                }
//                return node.value;
//            }
//        }
//
//        /**
//         * 考虑是否已经加入过该Key,加入过则进行更新
//         * 未加入过，则考虑容量是否满了，需要进行淘汰
//         *@param K key
//         *@param V value
//         */
//        public void put(K key,V value){
//            Entry node = cache.get(key);
//            try{
//                lock.lock();
//                if(node!=null){// 如果该key以及在了，不需要淘汰，更新即可，不存在才需要考虑淘汰
//                    moveAtNode(node);
//                    addAtHead(node);
//                }else{
//                    if(capacity == cache.size()){// 淘汰不要的(即末尾的)
//                        cache.remove(tail.pre.pre.key);
//                        deleteAtNotUsedNode();
//                    }
//                    addAtHead(new Entry(key,value));
//                }
//                cache.put(key,value);
//            }finally{
//                lock.unlock();
//            }
//        }
//
//        private void addAtHead(Entry node){
//            head.next.pre = node;
//            node.next=head.next;
//            node.pre = head;
//            head.next = node;
//        }
//
//        private void moveAtNode(Entry node){
//            node.pre.next = node.next;
//            node.next.pre = node.pre;
//        }
//
//        private void deleteAtNotUsedNode(){
//            tail.pre.pre.next = tail;
//            tail.pre = tail.pre.pre;
//        }
//    }
//
//}
