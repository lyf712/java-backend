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

package com.lyf.alg.leetcode.str;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liyunfei
 **/
public class StrBaseTests {
    @Test
    public void testString(){
        String str = "hello";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        str.hashCode();
        CharSequence charSequence = new StringBuilder();
        //ThreadPoolExecutor
        Object o = new Object();
        o.hashCode();

        HashSet set = new HashSet();
        set.hashCode();


    }
}
