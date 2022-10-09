package com.lyf.alg.leetcode.concurrent;

import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 * @author liyunfei
 */
public class LC1117 {
    @Test
    public void testSem(){
        Semaphore semaphore = new Semaphore(2);
        semaphore.release(2);
    }
}
