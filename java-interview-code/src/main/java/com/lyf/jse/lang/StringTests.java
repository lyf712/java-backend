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

package com.lyf.jse.lang;

import org.junit.Test;

/**
 * @authorliyunfei
 * @date2022/11/25
 **/
public class StringTests {
    /**
     * String 字符常量池（ 堆内存 ）
     * https://blog.csdn.net/qq_52880445/article/details/123171467
     * 注意JDK1.7前后的变化；对比 堆、方法区、常量池--（后续结合JVM再看 FIXME
     * 1.String的创建过程 String str = "abc";String str2= new String("abc");
     * 2.String的特性， final类（）,不可变（只读字符串，修改则是创建新的对象修改引用） → 便于做Map的key，hashcode定下来不容易变化，减少hashcode的计算工作
     * TODO 3.==,equals, 值比较，内容比较，引用，地址比较； == 是比较对象的引用地址，hash值比较
     *
     */
    @Test
    public void test(){
           String str1 = "abc";// 分配至常量池
           String str2 = "abc";
           String str3 = new String("abc");// 分配值堆空间
           String str4 = new String("abc");

          /**
           * 5e025e70:96354
           * 5e025e70:96354
           * 1fbc7afb:96354
           * 45c8e616:96354
           */
           System.out.println(Integer.toHexString(System.identityHashCode(str1))+":"+str1.hashCode());
           System.out.println(Integer.toHexString(System.identityHashCode(str2))+":"+str2.hashCode());
           System.out.println(Integer.toHexString(System.identityHashCode(str3))+":"+str3.hashCode());
           System.out.println(Integer.toHexString(System.identityHashCode(str4))+":"+str4.hashCode());

           // 测试
           String strInit = "abcinit";
           System.out.println(Integer.toHexString(System.identityHashCode(strInit)));
           System.out.println(strInit.hashCode());//hashcode不能代表地址 如何打印地址 -1206133646
           strInit+="ok";
           System.out.println(Integer.toHexString(System.identityHashCode(strInit)));
           System.out.println(strInit.hashCode());//546739662

           StringBuilder stringBuilder = new StringBuilder(str1);
           System.out.println(stringBuilder.reverse().toString());
           //synchronized ;;线程安全---为什么Buffer是安全，缓冲池暗含 数据量大，需要缓冲 因此需要去保证安全
           StringBuffer stringBuffer = new StringBuffer();

           //str5:dbc;abc
           //address:1d251891::99237
           //address:5e025e70::96354
           String str5 = str1.replace('a','d');
           System.out.println("str5:"+str5+";"+str1);
           computeAddressAndHashCode(str5);
           computeAddressAndHashCode(str1);


           //address:58ceff1::93122545
           //address:58ceff1::93122545
           // 引用地址不变，值内容改变
           TestClass testClass = new TestClass();
           testClass.setName("lyf");
           computeAddressAndHashCode(testClass);
           testClass.setName("skx");
           computeAddressAndHashCode(testClass);
           testClass = new TestClass("hello",1);
           //Vaddress:7c30a502::2083562754
           computeAddressAndHashCode(testClass);

           // final对象，不能指向新引用
           final TestClass testClass2 = new TestClass();
           testClass2.setName("lyf");
           computeAddressAndHashCode(testClass);
           testClass2.setName("skx");
           computeAddressAndHashCode(testClass);
//           //Cannot assign a value to final variable 'testClass2'
//           testClass2 = new TestClass("hello",1);
//           //Vaddress:7c30a502::2083562754
//           computeAddressAndHashCode(testClass);


           //address:2133c8f8::557041912
           //address:2133c8f8::557041912
           // address:43a25848::1134712904
           TestClass3 testClass3 = new TestClass3();
           testClass3.setName("lyf");
           computeAddressAndHashCode(testClass3);
           testClass3.setName("skx");
           computeAddressAndHashCode(testClass3);
           testClass3 = new TestClass3();
           computeAddressAndHashCode(testClass3);
    }


    void computeAddressAndHashCode(Object o){
           System.out.println("address:"+Integer.toHexString(System.identityHashCode(o))+"::"+o.hashCode());
    }

    // 不能继承
    final private class TestClass3{
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    private class TestClass{
           private String name;
           private Integer age;

        public TestClass() {
        }

        public TestClass(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        // ---
    }

}
