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

package com.lyf.collections;

import com.google.common.collect.Collections2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author liyunfei
 **/
public class CollectionsUtils {
    public static void main(String[] args) {

    }

    void diff(){
          //Collections2
    }

    private static class Father implements Comparable<Integer>{

        private Integer age;

        @Override
        public int compareTo(Integer age) {

            return 0;
        }
    }
    private static class Son extends Father{

    }

    // comparable,compartor
    void sort(){

        List<Son> sons = new ArrayList<>();
        Collections.sort(sons, new Comparator<Father>() {
            @Override
            public int compare(Father o1, Father o2) {


                return 0;
            }
        });

        //Collections.sort();


    }
}
