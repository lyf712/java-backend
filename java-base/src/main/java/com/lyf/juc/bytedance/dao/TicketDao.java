package com.lyf.juc.bytedance.dao;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author liyunfei
 */
public class TicketDao {
    // 一致性保证
    private volatile AtomicLong count = new AtomicLong(1);
}
