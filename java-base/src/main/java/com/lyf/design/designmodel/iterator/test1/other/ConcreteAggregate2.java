package com.lyf.design.designmodel.iterator.test1.other;

import com.lyf.design.designmodel.iterator.test1.Aggregate;
import com.lyf.design.designmodel.iterator.test1.ConcreteAggregate;
import com.lyf.design.designmodel.iterator.test1.MyIterator;

/**
 * @author liyunfei
 */
public class ConcreteAggregate2 implements Aggregate {
    Object[]elements;
    /// this
    MyIterator2 myIterator2 = new MyIterator2(this,0);
    
    @Override
    public int size() {
        return 0;
    }
    
    @Override
    public void add(Object o) {
    
    }
    
    Object get(int index){
        return elements[index];
    }
    
    MyIterator iterator(){
        return myIterator2;
    }
}
