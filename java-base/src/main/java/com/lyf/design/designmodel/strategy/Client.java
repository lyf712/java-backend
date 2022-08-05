package com.lyf.design.designmodel.strategy;

/**
 * @author liyunfei
 */
public class Client {
    
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new StrategyA());
        context.exec();
        context.setStrategy(new StrategyB());
        context.exec();
    }
}
