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

package com.lyf.jse.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @authorliyunfei
 * @date2022/11/25
 **/
public class FuntionCompute {
       static double compute(double x){
           return -2051.4*x+2926.6;
       }

    public static void main(String[] args) {
        double[] x1 = {1.4251,
                1.4173,
                1.4165,
                1.4114,
                1.4065,
                1.4039,
                1.3909,
                1.3843,
                1.3824,
                1.3809};
        double[] x2= {
                1.4273,
                1.4259,
                1.4244,
                1.4182,
                1.4055,
                1.3973,
                1.3827,
                1.3804,
                1.3794,
                1.3784,
        };

        for(double d1:x1){
            BigDecimal bd = new BigDecimal(compute(d1));
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            System.out.print(bd +",");
            //Math.
        }
        System.out.println();
        for(double d1:x2){
            BigDecimal bd = new BigDecimal(compute(d1));
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            System.out.print(bd +",");
        }
    }
}
