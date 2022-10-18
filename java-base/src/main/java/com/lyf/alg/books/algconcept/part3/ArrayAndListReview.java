package com.lyf.alg.books.algconcept.part3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 1.数组
 * 有序的元素序列（相同元素类型）
 * https://baike.baidu.com/item/%E6%95%B0%E7%BB%84/3794097?fr=aladdin
 * 2.链表
 * 链表是一种物理存储单元上非连续、非顺序的存储结构，数据元素的逻辑顺序是通过链表中的指针链接次序实现的
 * https://baike.baidu.com/item/%E9%93%BE%E8%A1%A8/9794473?fr=aladdin
 *
 *
 * @author liyunfei
 */
public class ArrayAndListReview {
   
   static class Student implements Comparable<Student>{
       private String name;
       private int age;
    
       public Student(String name, int age) {
           this.name = name;
           this.age = age;
       }
    
       public String getName() {
           return name;
       }
    
       public void setName(String name) {
           this.name = name;
       }
    
       public int getAge() {
           return age;
       }
    
       public void setAge(int age) {
           this.age = age;
       }
    
       @Override
       public String toString() {
           return "Student{" + "name='" + name + '\'' + ", age=" + age + '}';
       }
       
       @Override
       public int compareTo(Student o) {
           return this.getAge()-o.getAge();
       }
   }
   
   @Test
   public void testArray(){
       // 基本使用：声明形式、Arrays工具类的使用及其sort,binarySearch等API的设计
       // 、数组下标存取值
       int[] arr0=new int[]{1,2};
       System.out.println(Arrays.toString(arr0)+":"+arr0.length);
       int[] arr1=Arrays.copyOf(arr0,1);
       System.out.println(Arrays.toString(arr1)+":"+arr1.length);
       
       // 利用下标+ASCII，做hash
       int[]hash = new int[26];
       char ch = 'A';
       hash[ch-'A']++;
       System.out.println(hash[0]);
       
       Arrays.sort(arr0);
       char[] chars = new char[]{'a','v','b'};
       char[] chars1 = new char[1];
       Arrays.sort(chars);
       // 设计为何不检查 该数组是否有序，已成为二叉树(若先检查，则降低性能，用户若想用该API，应自行保证数组的有序
//       rangeCheck(a.length, fromIndex, toIndex);
//       return binarySearch0(a, fromIndex, toIndex, key)
       // 【>>>：“无符号”右移位运算符(>>>)，它使用了“零扩展”：无论正负，都在高位插入0】
       System.out.println(Arrays.binarySearch(chars,'v'));
       Student[]students =new Student[]{new Student("skx",13),new Student("lyf",12)};
       System.out.println(Arrays.toString(students));
       //Arrays.sort(students, Comparator.comparingInt(Student::getAge)); // lambda 和 匿名函数的使用
       Arrays.sort(students);// 自行实现接口
       System.out.println(Arrays.toString(students));
       
   }
   @Test
   public void testList(){
       Vector list0 = new Vector();
       ArrayList list1 = new ArrayList<>();
       LinkedList list2 = new LinkedList();
       CopyOnWriteArrayList list3 = new CopyOnWriteArrayList();
   }
}
