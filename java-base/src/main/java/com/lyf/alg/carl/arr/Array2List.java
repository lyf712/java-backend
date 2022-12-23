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

package com.lyf.alg.carl.arr;

import org.junit.Test;

/**
 * @authorliyunfei
 * @date2022/12/22
 **/
public class Array2List {
      @Test
      public void test(){
          char[][] chars = new char[2][2];
          chars[0][0]='a';
          chars[0][1]='b';
          // return new String(data);
          String str = String.copyValueOf(chars[0]);
      }
}