package com.lyf.design.designmodel.strategy;

/**
 * @author liyunfei
 */
public class Context {
    Strategy strategy;
    
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    
    void exec(){
        System.out.println("context exec method::");
        strategy.algMethod();
    }
    
}
