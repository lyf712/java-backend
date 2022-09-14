package com.lyf.juc.base;

import java.util.concurrent.TimeUnit;

/**
 * 阿里云：计算平台事业部
 * 注重：多线程JUC+数据结构的组合
 *
 * （JAVA）有3个独立的线程，一个只会输出A，一个只会输出L，一个只会输出I。
 * 在三个线程同时启动的情况下，请用合理的方式让他们按顺序打印 ALIALI。
 * 三个线程开始正常输出后，主线程若检测到用户任意的输入则停止三个打印线程的工作，整体退出。
 *
 * -.- 吸烟者模型 (0-.-0) -.-
 *
 * @author liyunfei
 */
public class CollaborationInterview {
     
     // ---单个线程的执行---
     private class MyThread implements Runnable{
         private String name;
         int ptr = 1;
         // private boolean flag[]={true,false,false};
         public MyThread(String name) {
             this.name = name;
         }
         @Override
         public void run() {
             if(ptr/3==1){
                 System.out.println("A");
             }else if(ptr/3==2){
                 System.out.println("L");
             }else if(ptr/3==0){
                 System.out.println("I");
             }
             // -/.\-
         }
     }
     
     // =-----?.?-----=
     
     private volatile static String flag = "A";
     
     private static class MyThread1 implements Runnable{
         private String name;
         public MyThread1(String name) {
             this.name = name;
         }
         @Override
         public void run() {
             for (;;){
                 try {
                     TimeUnit.SECONDS.sleep(1);
                 } catch (InterruptedException e) {
                     System.out.println("停止运行");
                     break;
                     // e.printStackTrace();
                 }
                 if(name.equals(flag)){
                     System.out.println(Thread.currentThread().getName()+":"+name);
                     updateFlag();
                 }
                 
             }
             
         }
         void updateFlag(){
             switch (flag){
                 case "A":{flag = "L";break;}// 原子性修改？
                 case "L":{flag = "I";break;}
                 case "I":{flag = "A";break;}
             }
         }
     }
     
     public static void main(String[] args) {
         new Thread(new MyThread1("A"),"thread-1").start();
         new Thread(new MyThread1("L"),"thread-2").start();
         new Thread(new MyThread1("I"),"thread-3").start();
         try {
             TimeUnit.SECONDS.sleep(100);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
     
}
