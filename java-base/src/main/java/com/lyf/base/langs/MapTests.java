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

package com.lyf.base.langs;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @authorliyunfei
 * @date2022/11/24
 **/
public class MapTests {
    @Test
    public void testMapKey(){
           Map<MockKey,Integer> map = new HashMap<>();
           map.put(new MockKey("name1"),1);
           map.put(new MockKey("name2"),1);
           map.put(new MockKey("name1"),1);
           //    static final int hash(Object key) {
        //        int h;
        //        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        //    }
           System.out.println(map.size());
    }
}
