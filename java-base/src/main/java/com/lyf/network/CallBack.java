package com.lyf.network;

/**
 * @author liyunfei
 */
public interface CallBack<T extends Event> {
    
    void onSuccess(T t);
    
    void onError(T t);
}
