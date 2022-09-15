package com.lyf.juc.base.threadsafe;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 */
class Counter {
    
    private static final int CAPACITY = 10;
    
    private int count = 0;
    
    static void staticMethod() {
        System.out.println("staticMethod");
    }
    
    void add() {
        System.out.println("add not static method");
        add0();
    }
    
    private void add0() {
        count++;
    }
    
    synchronized void add1() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }
    
    void add2() {
        synchronized (this) {
            System.out.println(new Date() + "get lock by Object this");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            add0();
            System.out.println(new Date() + "release lock by Object this");
        }
        
    }
    
    void add3(byte lock[]) {
        
        synchronized (lock) {
            System.out.println(new Date() + "get lock by Object arg");
            // 模拟占用锁
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            add0();
            System.out.println(new Date() + "relase lock by Object arg");
        }
        
    }
    
    void add4() {
        
        synchronized (Counter.class) {
            System.out.println(new Date() + "get lock by Counter.class");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            add0();
            System.out.println(new Date() + "release lock by Counter.class");
        }
        
    }
}

public class SynchronizedTest {
    
    private byte[] lock = new byte[1];
    
    private final Counter counter = new Counter();
    
    @Test
    public void testSynchronized() {
        //new Thread(counter::add1).start();
        //new Thread(counter::add2).start();
        //new Thread(() -> counter.add3(lock)).start();
        new Thread(counter::add4).start();
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //FIXME ???在锁住类对象时，为什么未释放锁，也能执行该静态方法
        //Counter.staticMethod();
        //new Thread(Counter::staticMethod).start();
        //counter.add();
        //new Thread(counter::add2).start();
        new Thread(counter::add4).start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
