package com.lyf.juc.jucalibaba.cases.limitcase;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

/**
 * @author liyunfei
 */
public class GuavaLimiter {
    @Test
    public void test(){
        RateLimiter rateLimiter = RateLimiter.create(5);
        rateLimiter.acquire();
    }
    
}
