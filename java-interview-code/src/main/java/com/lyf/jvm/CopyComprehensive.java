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

package com.lyf.jvm;

import org.junit.Test;

/**
 * 深拷贝和浅拷贝的理解
 * https://www.zhihu.com/question/19810539/answer/2587341952
 *
 * @authorliyunfei
 * @date2022/11/26
 **/
public class CopyComprehensive {
       @Test
       public void test() throws CloneNotSupportedException {
              Person person1 = new Person();
              person1.setAge(2);
              person1.setName("ok");
              person1.setHand(new Hand(2F,21F));
              Person person2 = person1;//浅拷贝
              person2.setAge(3);
              System.out.println(person1+":"+person2);

              Person person3 = person1.clone();// 深拷贝
              person3.setAge(4);
              System.out.println(person1+":"+person3);
       }

       class Person implements Cloneable{
             private String name;
             private int age;
             private Hand hand;

           public void setName(String name) {
               this.name = name;
           }

           public void setAge(int age) {
               this.age = age;
           }

           public void setHand(Hand hand) {
               this.hand = hand;
           }

           @Override
           protected Person clone() throws CloneNotSupportedException {
               Person person = (Person) super.clone();
               person.hand = hand.clone();
               return person;
           }

           @Override
           public String toString() {
               return "Person{" +
                       "name='" + name + '\'' +
                       ", age=" + age +
                       ", hand=" + hand +
                       '}';
           }
       }
       class Hand implements Cloneable{
             private float size;
             private float length;

           public Hand(float size, float length) {
               this.size = size;
               this.length = length;
           }

           @Override
           protected Hand clone() throws CloneNotSupportedException {
               //    @IntrinsicCandidate
               //    protected native Object clone() throws CloneNotSupportedException;
               return (Hand) super.clone();
           }
       }
}
