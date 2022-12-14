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

import java.util.Arrays;

/**
 * @authorliyunfei
 * @date2022/12/26
 **/
public class StreamTests {
    @Test
    public void arrStream(){
         int [] nums = new int[10];
         Arrays.stream(nums).sum();
        // Stream.of(new int[]{1,2,4}).min((o1, o2) -> {return o1.length-o2.length});
        int[] arr = new int[10];
        Arrays.stream(arr).min().getAsInt();
        //Math.pow()
    }
}
