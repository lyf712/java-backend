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

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * @authorliyunfei
 * @date2022/11/4
 **/
public class GuavaBloom {
    @Test
    public void test(){
        BloomFilter<Integer> bloomFilter =
                BloomFilter.create(Funnels.integerFunnel(),500,0.01);
        for(int i=1;i<1000;i++){
            int random = new Random().nextInt(100*10000);
            bloomFilter.put(random);
            //Assert.assertTrue(bloomFilter.mightContain(random));
        }
        int count = 0;
        for(int i=1;i<10000;i++){
            if(bloomFilter.mightContain(new Random().nextInt(1000*10000)))
                count++;
        }
        System.out.println("count:"+count);
    }
}
