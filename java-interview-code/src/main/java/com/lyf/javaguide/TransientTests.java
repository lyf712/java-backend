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

package com.lyf.javaguide;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author liyunfei
 **/
public class TransientTests {
    @Test
    public void test(){
        HashMap map = new HashMap();

        /**
         * The table, initialized on first use, and resized as
         * necessary. When allocated, length is always a power of two.
         * (We also tolerate length zero in some operations to allow
         * bootstrapping mechanics that are currently not needed.)
         */
        //transient HashMap.Node<K,V>[] table;

        /**
         * Holds cached entrySet(). Note that AbstractMap fields are used
         * for keySet() and values().
         */
        //transient Set<Map.Entry<K,V>> entrySet;

        /**
         * The number of key-value mappings contained in this map.
         */
        //transient int size;

        /**
         * The number of times this HashMap has been structurally modified
         * Structural modifications are those that change the number of mappings in
         * the HashMap or otherwise modify its internal structure (e.g.,
         * rehash).  This field is used to make iterators on Collection-views of
         * the HashMap fail-fast.  (See ConcurrentModificationException).
         */
        //transient int modCount;

    }
}
