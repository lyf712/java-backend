package com.lyf.design.designmodel.factory;

/**
 * product series ,is not easy to change, should abstract to interface.
 * factory is easy to change,should place to implements.
 * @author liyunfei
 */
public interface AbstractFactory {
    
    ProductA getProductA();
    
    ProductB getProductB();
}
