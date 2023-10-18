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

package com.lyf.base;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * <a href="https://javaguide.cn/java/basis/java-basic-questions-01.html">java基础（上）</a>
 *
 * @author liyunfei
 **/
public class Part_01 {

    public static void main(String[] args) {
       // bitMoveOpt();
        //CntTask cntTask= new CntTask();
//        for (int i = 0; i < 10; i++) {
//            CntTask cntTask= new CntTask();
//            exucteTest(cntTask);
//        }

    }

    private class Father{

        void method() throws Exception{
            System.out.println("OK F");
        }
    }

    private class Son extends Father{
        @Override
        void method() throws NullPointerException {
            //super.method();
            System.out.println("OK S");
        }
    }


    private static void exucteTest(CntTask cntTask) {
        for(int i=0;i<100;i++){
            new Thread(cntTask).start();
        }
        System.out.println(cntTask.getVar1());
        System.out.println(CntTask.getVar2());
        System.out.println(cntTask.getVar3());
        System.out.println(CntTask.getVar4());
        System.out.println(cntTask.getVar5());
        System.out.println(CntTask.getVar6());
        System.out.println(cntTask.getVar7());
        System.out.println(CntTask.getVar8());
        System.out.println(">>>>>>>>>>>>>");
    }

    private static class CntTask implements Runnable{

        private  int var1 =0 ;

        private static int var2 =0 ;

        private AtomicInteger var3 = new AtomicInteger(0);

        private static AtomicInteger var4 = new AtomicInteger(0);

        private  volatile int var5 =0 ;

        private volatile static int var6 =0;

        private volatile AtomicInteger var7 = new AtomicInteger(0);

        private volatile static AtomicInteger var8 = new AtomicInteger(0);

        @Override
        public void run() {
            var1++;
            var2++;
            var3.getAndIncrement();
            var4.getAndIncrement();
            var5++;
            var6++;
            var7.getAndIncrement();
            var8.getAndIncrement();
        }

        public int getVar1() {
            return var1;
        }

        public static int getVar2() {
            return var2;
        }

        public AtomicInteger getVar3() {
            return var3;
        }

        public static AtomicInteger getVar4() {
            return var4;
        }

        public int getVar5() {
            return var5;
        }

        public static int getVar6() {
            return var6;
        }

        public AtomicInteger getVar7() {
            return var7;
        }

        public static AtomicInteger getVar8() {
            return var8;
        }
    }

    private static void precision(){
        // BigInteger
        // BigDecimal bigDecimal= new BigDecimal("");
        // Long -- 分
        // Format---

    }

    private static void splitBox(){
        ///   private static class IntegerCache
        //           cache = new Integer[(high - low) + 1];
       //  Integer.valueOf(1);

//        Integer val1 = Integer.valueOf(1);
//        //   private final int value;
//        int val2 = val1.intValue();
    }

    private static void bitMoveOpt(){
        int val1=1;
        int val2=-1;

        //for(int j=0;j<32;j++){
            //System.out.println(Integer.toBinaryString(val1));
            //System.out.println(Integer.toBinaryString(val2));
        //}
        // 补码的理解
        //System.out.println(Integer.toBinaryString(val1<<1) + ":" + Integer.toBinaryString(val1<<31) + ":" +( val1<<31));
//        System.out.println(val1<<30);

        //System.out.println(Integer.toBinaryString(val2<<1)+":"+(val2<<1) +":" + Integer.toBinaryString(val2>>>1) + ":" +(val2>>>1) + ":"+ Integer.toBinaryString(val2>>1) +":" +(val2>>1));
       // printVal((-4)>>1);
        printVal(-8);
        printVal((-8)>>>2);
        //printVal(4>>1);
        //printVal(4>>>1);

    }

    private static void printVal(final int val){
        System.out.println(val);
        // 补码--
        System.out.printf("%s : %d \n",Integer.toBinaryString(val),val);
        //val++;
    }
    
    private void handleMethod1(int...val){

        // ...

        final int var1 = val[0];
        final int var2 = val[1];
        // ctrl + alt + m(method) -> 抽象提炼方法 -> 抽象提炼训练，命名注释规范,可读性提升
        add(var1, var2);

        // ...
    }

    private static void add(int var1, int var2) {
        System.out.println(var1 + var2);
    }
}
