package com.lyf.httpweb.client;

import java.net.SocketAddress;

/**
 * @author liyunfei
 */
public interface HttpClient<T> {
    void connect(SocketAddress endpoint);
    void send(T t);
}
