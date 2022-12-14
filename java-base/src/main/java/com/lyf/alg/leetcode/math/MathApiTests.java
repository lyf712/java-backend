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

package com.lyf.alg.leetcode.math;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @authorliyunfei
 * @date2022/12/21
 **/
public class MathApiTests {
    @Test
    public void testApi(){
        //Math.sqrt()
        //new LinkedList<>().g

        System.out.println((0.1+0.2)==0.3);
        System.out.println((0.1F+0.2F)==0.3F);
        System.out.println((1+2)==3);
        float i = 0.1F;
        float j = 0.2F;
        if(i+j==0.3F){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
