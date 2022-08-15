package com.lyf.design.designmodel.iterator.test1.other;

import com.lyf.design.designmodel.iterator.test1.MyIterator;

/**
 * @author liyunfei
 */
public class MyIterator2 implements MyIterator {
    ConcreteAggregate2 concreteAggregate2;
    int cur;
    
    public MyIterator2(ConcreteAggregate2 concreteAggregate2, int cur) {
        this.concreteAggregate2 = concreteAggregate2;
        this.cur = cur;
    }
    
    @Override
    public Object item() {
        return concreteAggregate2.get(cur);
    }
    
    @Override
    public Object next() {
        return null;
    }
    
    @Override
    public boolean hasNext() {
        return false;
    }
}
