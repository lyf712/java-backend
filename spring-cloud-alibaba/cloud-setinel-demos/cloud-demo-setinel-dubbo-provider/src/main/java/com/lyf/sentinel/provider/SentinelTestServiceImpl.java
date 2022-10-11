package com.lyf.sentinel.provider;

import com.lyf.sentinel.api.SentinelTestService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 */
@Service
public class SentinelTestServiceImpl implements SentinelTestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SentinelTestServiceImpl.class);
    private static final int MAX_TIME_OUT = 10;
    @Override
    public String hello(String param) {
        int timeout = new Random().nextInt(MAX_TIME_OUT);
        try {
            // 模拟 延时 -- 系统故障/通信超时
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            LOGGER.warn("communicate Interrupted {}",e.getMessage());
        }
        LOGGER.info("provider handle {}",param);
        return "provider handle:"+param;
    }
}
