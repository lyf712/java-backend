package com.lyf.design.designmodel.factory;

/**
 * @author liyunfei
 */
public class FactoryA implements AbstractFactory{
    
    @Override
    public ProductA getProductA() {
        return new ProductA() {
            @Override
            public void startA() {
                System.out.println("start a ...");
            }
    
            @Override
            public void closeA() {
                System.out.println("close a ...");
            }
        };
    }
    
    @Override
    public ProductB getProductB() {
        return new ProductB() {
            @Override
            public void startB() {
        
            }
    
            @Override
            public boolean checkB() {
                return false;
            }
    
            @Override
            public void closeB() {
        
            }
        };
    }
}
