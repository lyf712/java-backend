/*
 *    Copyright 1999-2022  lyf712
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.lyf.util;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

/**
 * @author liyunfei
 **/
public class LimiterAlg {
    @Test
    public void testGuavaLimit(){
        RateLimiter limiter = RateLimiter.create(1);

    }
    // 计数器、滑动窗口、漏桶、令牌桶四种限流算法
    
}
