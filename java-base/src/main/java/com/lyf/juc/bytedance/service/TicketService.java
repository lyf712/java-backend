package com.lyf.juc.bytedance.service;

import com.lyf.juc.bytedance.domain.User;

/**
 * @author liyunfei
 */
public interface TicketService {
    boolean saleTicket(User user);
}
