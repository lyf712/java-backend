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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author liyunfei
 **/
public class LCPractice {
    public static void main(String[] args) {
        new LCPractice().removeSubfolders(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"});
    }
    public List<String> removeSubfolders(String[] folder) {
        /**
         * 遍历匹配的方式
         * 时间复杂度：n^3
         */
        Arrays.sort(folder, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        List<String> rs = new ArrayList<>();
        for(String floder0:folder){
            boolean isDelete = false;
            for(String folder1:rs){
                if(validate(floder0,folder1)){ // floder0.startsWith(folder1)
                    System.out.println(floder0);
                    isDelete = true;
                    break;
                }
            }
            if(!isDelete){
                rs.add(floder0);
            }
        }
        return rs;
    }

    boolean validate(String s0,String s1){
        String[]strs1=s0.split("\\/");
        String[]strs2=s1.split("\\/");
        int len = Math.min(strs1.length,strs2.length);
        //System.out.println(len);
        for(int i=0;i<len;i++){
            System.out.println(strs1[i]+":"+strs2[i]+":"+i+":"+len);
            if(strs1[i]!=strs2[i]) return false;
        }
        System.out.println("true");
        return true;
    }
}
