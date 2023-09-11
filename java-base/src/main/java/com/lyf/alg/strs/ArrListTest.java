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

package com.lyf.alg.strs;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author liyunfei
 **/
public class ArrListTest {
    @Test
    public void test(){
//        ArrayList<Integer>[]arrayLists = new ArrayList[10];
//        arrayLists[0].add(0);
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        arrayLists.add(new ArrayList<>());
        arrayLists.get(0).add(1);
        //arrayLists.get(0).add(1);

    }
}
