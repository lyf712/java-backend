package com.lyf.httpweb.client;

import java.io.IOException;
import java.net.SocketAddress;

/**
 * @author liyunfei
 */
public class DefaultHttpClient<T> extends AbstractHttpClient implements HttpClient<T> {
    
    
    @Override
    public void connect(SocketAddress endpoint) {
        try {
            socket.connect(endpoint);
            System.out.println("connect " + endpoint + " succeed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void send(T t) {
        // Adapter处理---
        String content = (String) t;
        try {
            socket.getOutputStream().write(content.getBytes());
            byte[] resp = new byte[1024];
            socket.getInputStream().read(resp);
            System.out.println("receive:" + resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
