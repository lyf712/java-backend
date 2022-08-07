package com.lyf.design.designmodel.iterator.test1;

/**
 * @author liyunfei
 */
public interface MyIterator<T> {
    T item();
    T next();
    boolean hasNext();
}
