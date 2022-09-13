package com.lyf.nju.concurrency;

/**
 * mutex 互斥尝试
 *
 * @author liyunfei
 */
public class MutextTry {
    // 尝试1
    private enum Lock{
        UNLOCK,
        LOCK
    }
    Lock lock = Lock.UNLOCK;
    
    void tryLock(int sum){
    
//        if(lock.compareTo(Lock.LOCK)==0){
//
//        }
        
        while (lock.compareTo(Lock.LOCK)==0);
        lock = Lock.LOCK;
        sum++;
        lock = Lock.UNLOCK;
        // store/load不能保证原子性
    }
}
