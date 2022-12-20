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

package com.lyf.alg.carl;

import org.junit.Test;

import java.util.*;

/**
 * @authorliyunfei
 * @date2022/12/20
 **/
public class SortTests {
       @Test
       public void sortMap(){
              Map<Integer,Integer> map = new HashMap<>();
              //map.entrySet().stream().toList().sort();
              map.put(1,3);
              map.put(2,4);
              List<Map.Entry<Integer,Integer>> entryList = map.entrySet().stream().toList();
              List<Map.Entry<Integer,Integer>> entryList2 = new ArrayList<>(entryList);//Collections.synchronizedList(entryList);
              entryList2.sort((e1,e2)-> e2.getValue()-e1.getValue());
              entryList.forEach(e-> System.out.println(e.getKey()+":"+e.getValue()));
              entryList2.forEach(e-> System.out.println(e.getKey()+":"+e.getValue()));

       }
}
