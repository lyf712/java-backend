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

package com.lyf.jvm.stringconcept;

import org.junit.Test;

/**
 * @author liyunfei
 **/
public class StringTest {
    public static void main(String[] args) {
        //String debug 看 mem
        System.out.println();
        for(int i=0;i<10;i++){
            System.out.println(String.valueOf(i));//.intern()
        }

        for(int i=0;i<10;i++){
            System.out.println(String.valueOf(i).intern());
        }
    }

    @Test
    public void testMemAlloc(){
        String s1 = "a";
        final String s11 = "a";
        String s2 = "b";
        final String s22 = "a";
        String s3 = "ab";


    }

}
