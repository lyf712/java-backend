package com.lyf.design.designmodel.iterator.test1;

import com.lyf.design.designmodel.iterator.Iterator;

/**
 * @author liyunfei
 */
public class ConcreteAggregate<T> implements Aggregate{
    
    protected T[] elements;
    
    @Override
    public int size() {
        return 0;
    }
    
    @Override
    public void add(Object o) {
    
    }
    
    public T get(int index){
        // check--
        return elements[index];
    }
    
    MyIterator<T> iterator(){
        return new ConcreteIterator<T>(0);
    }
    
    protected class ConcreteIterator<T> implements MyIterator{
    
        private int cursor;
        
        public ConcreteIterator(int cursor){
            this.cursor = cursor;
        }
        
        @Override
        public T item() {
            return (T) get(cursor);
        }
    
        @Override
        public T next() {
            return (T) get(cursor++);
        }
    
        @Override
        public boolean hasNext() {
            return cursor < size();
        }
    }
}
