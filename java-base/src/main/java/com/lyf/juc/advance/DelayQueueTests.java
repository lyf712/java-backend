package com.lyf.juc.advance;

import org.junit.Test;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 */
public class DelayQueueTests {
    
    private class DelaySingleTask implements Delayed,Runnable{
    
        @Override
        public void run() {
        
        }
    
        
        // ---
        
        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }
    
        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }
    
    @Test
    public void testDelayQueueApi(){
        DelayQueue<DelaySingleTask> delayQueue = new DelayQueue<DelaySingleTask>();
    }
}
