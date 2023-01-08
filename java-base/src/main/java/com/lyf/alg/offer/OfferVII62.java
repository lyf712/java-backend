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

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @authorliyunfei
 * @date2023/1/8
 **/
public class OfferVII62 {
    @Test
    public void test(){
        lastRemaining(5,3);
    }

    public int lastRemaining0(int n, int m){
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int pointer = 0;
        while (n > 1) {
            pointer = (pointer + m - 1) % n;//
            list.remove(pointer);
            n--;
        }
        return list.get(0);
    }

    public int lastRemaining(int n, int m) {
        int size=n;// 当前的数量
        boolean []record = new boolean[n];//记录是否被删除
        Arrays.fill(record,false);
        int curIndex = 0;//
        while(size>1){
            int count = 1;
            m = m%size;
            while(count<=m) { // 移动m次
                if(!record[curIndex])
                   count++;
                curIndex++;
                curIndex%=n;
            }

            if(curIndex==0) {
                for(int i=n-1;i>0;i--){
                    if(!record[i]){
                        curIndex = i;
                        break;
                    }
                }
            } else {
                for(int i=curIndex;i>=0;i--){
                    if(!record[i]){
                        curIndex = i;
                        break;
                    }
                }
            }//回退一个

            System.out.println(curIndex);
            record[curIndex]=true;//删除

            curIndex++;
            curIndex%=n;
            size--;
        }

        for(int i=0;i<record.length;i++){
            if(!record[i]) return i;
        }
        return -1;
    }


}
