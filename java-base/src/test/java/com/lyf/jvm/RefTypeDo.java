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

package com.lyf.jvm;

/**
 * @author Hang YU
 **/
public class RefTypeDo {

    private Integer type;
    private String name;

    public RefTypeDo(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    // 运算--操作
    public int compute(int num1, int num2){
        // 堆内-->局部变量
        final Integer localType = type;
        if(localType == 1){
            return num1+num2;
        }else {
            return num1-num2;
        }
    }

    public int exception(){throw new UnsupportedOperationException("----");}


}
