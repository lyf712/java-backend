package com.lyf.base.javacore.base.interfacelamdba;

/**
 * @author liyunfei
 */
public interface InterfaceDemo {
    int hello = 1;
    static void staticMethod(){}
    default void defaultMethod(){}
    void interfaceMethod();
}
