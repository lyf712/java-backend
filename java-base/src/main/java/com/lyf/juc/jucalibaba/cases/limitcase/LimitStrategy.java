package com.lyf.juc.jucalibaba.cases.limitcase;

/**
 * @author liyunfei
 */
public interface LimitStrategy {
    
    /**
     *
     * //@param user 用户.
     * //@param request 请求.
     * @return 成功/失败 or 限流
     */
    String request();//String user,String request
}
