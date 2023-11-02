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

package com.lyf.huawei.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyunfei
 **/
public class Kuohao {

    public static void main(String[] args) {
        recursion(3,3,new StringBuffer());
        rs.forEach(System.out::println);
    }

    static List<String> rs = new ArrayList<>();
    static void recursion(int left,int right,StringBuffer stringBuffer){
        if(right==0){
           rs.add(stringBuffer.toString());
           return;
        }
        if(left>0){
            recursion(left-1,right,stringBuffer.append("("));
        }

        if(right > 0 && left<=right){
            recursion(left,right-1,stringBuffer.append(")"));
        }
    }

}
