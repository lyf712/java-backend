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

package com.lyf.design.structure.bloom;

import java.util.BitSet;
import java.util.Random;

/**
 * 布隆过滤器
 * @authorliyunfei
 * @date2022/11/4
 **/
class HashFun<T>{

      int seed[]={3,5,7,11,13,17,19,23};
      int hash(T t){// 取模法，平方法,seed
          int rs = 1;
          if(t instanceof String){
                String tmp = (String) t;
                for(int i=0;i<tmp.length();i++)
                        rs+=tmp.charAt(i)*seed[i];
          } else if (t instanceof Integer) {

          } else{
              throw new UnsupportedOperationException("");
          }
          return rs;
      }
}
public class SelfBloom<T> {

    private final static int DEFAULT_SIZE = 256<<32;

    private final static int FUN_SIZE = 8;

    private final HashFun[] hashFuns = new HashFun[FUN_SIZE];

    private final BitSet bitSet = new BitSet(DEFAULT_SIZE);

    public SelfBloom() {
        for(int i=0;i<FUN_SIZE;i++)
            hashFuns[i]=new HashFun<T>();
    }

    void add(T t){
        if(t!=null){
            for(int i=0;i<FUN_SIZE;i++){
                bitSet.set(hashFuns[i].hash(t),true);
            }
        }
    }

    boolean contains(T t){
            for(int i=0;i<FUN_SIZE;i++){
                if(!bitSet.get(hashFuns[i].hash(t)))
                    return false;
            }
            return true;
    }

}
