package com.lyf.juc.base.threadsafe;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liyunfei
 */
class CounterByReentrant{
    private int count;
    final ReentrantLock lock = new ReentrantLock();
    // Condition condition = lock.newCondition(); FIXME Condition的使用
    final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    final Lock readLock = readWriteLock.readLock();
    final Lock writeLock = readWriteLock.writeLock();
    void put(){
        lock.lock();
        try {
            System.out.println("get lock");
            put0();
        }finally {
            System.out.println("relase lock");
            lock.unlock();
        }
    }
    int get(){
        System.out.println(Thread.currentThread().getName()+"::read");
        return get0();
    }
    private void put0(){count++;}
    private int get0(){return count;}
    
    void  put1(){
        writeLock.lock();
        try {
            System.out.println("get lock");
            put0();
        }finally {
            writeLock.unlock();
        }
    }
    //写的时候其他线程不能进来，只能等待线程写完。
    // 读的时候其他线程可以读取，但是加了个读锁保证连续读逻辑上的一致
    int get1(){
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"::get lock and read");
            return get0();
        }finally {
            readLock.unlock();
        }
    }
}
public class ReentrantLockTest {
    @Test
    public void testReadLock(){
        CounterByReentrant counter = new CounterByReentrant();
        for(int i=0;i<10;i++)
           new Thread(counter::get,"thread-"+i).start();
        for(int i=0;i<10;i++)
            new Thread(counter::get1,"thread-"+i).start();
    }
}
