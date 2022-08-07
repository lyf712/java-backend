package com.lyf.design.designmodel;

/**
 * @author liyunfei
 */
public interface MyInterface {
    int var1 = 10;
    
    //
    void method1();
    
    //
    default void method2(){
        System.out.println("");
    }
    
}
