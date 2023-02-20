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

package com.lyf.datastructurealg.hot100;

import java.util.Arrays;

/**
 * @author liyunfei
 **/
public class StringBuilderAPI {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.reverse().toString();
        sb.delete(0,sb.length());
        //Arrays.copyOf()
        //System.arraycopy();
       // Arrays.copyOf()
    }
}
