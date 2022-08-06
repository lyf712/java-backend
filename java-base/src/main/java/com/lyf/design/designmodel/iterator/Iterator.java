package com.lyf.design.designmodel.iterator;

/**
 * @author liyunfei
 */
public interface Iterator<E> {
    E item();
    E next();
    E first();
    boolean hasNext();
    //boolean isDone();
}
