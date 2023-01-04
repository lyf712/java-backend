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

package com.lyf.alg.offer;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @authorliyunfei
 * @date2023/1/4
 **/
public class OfferVII50 {
    public char firstUniqChar(String s) {
        // 哈希计数 O(N) -- 2*N
        //    HashMap<Character,Integer> record = new HashMap<>();
        //    for(int i=0;i<s.length();i++){
        //         record.put(s.charAt(i),record.getOrDefault(s.charAt(i),0)+1);
        //    }


        //    for(int i=0;i<s.length();i++){
        //         if(record.get(s.charAt(i))==1) return s.charAt(i);
        //    }
        //    return ' ';


        //改进
        HashMap<Character,Integer> record = new HashMap<>();
        //char rs = ' ';
        LinkedList<Character> tmp = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            int rate = record.getOrDefault(s.charAt(i),0);
            //if(rate==0) //rs = s.charAt(i);
            if(rate==0) tmp.addLast(s.charAt(i));

            record.put(s.charAt(i),rate+1);
        }
        while(!tmp.isEmpty()){
            Character ch = tmp.getFirst();
            if(record.get(ch)==1)return ch;
            else tmp.removeFirst();
        }

        //    for(int i=0;i<s.length();i++){
        //         if(record.get(s.charAt(i))==1) return s.charAt(i);
        //    }
        return ' ';


        // 堆，N + nLogN


    }
}
