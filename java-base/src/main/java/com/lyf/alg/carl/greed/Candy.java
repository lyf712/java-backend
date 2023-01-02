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

package com.lyf.alg.carl.greed;

import java.util.Arrays;

/**
 * @authorliyunfei
 * @date2023/1/2
 **/
public class Candy {
    public int candy(int[] ratings) {
        // 1 3 2 5 6
        if(ratings.length<2)return 1;

        int[]candy = new int[ratings.length];
        Arrays.fill(candy,1);
        for(int i=0;i<ratings.length-1;i++){
            if(ratings[i+1]>ratings[i]) candy[i+1]=candy[i]+1;
        }

        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]) candy[i] = Math.max(candy[i],candy[i+1]+1);
        }

        int sum = 0;
        for(int num:candy){
            sum+=num;
        }

        return sum;

    }
}
