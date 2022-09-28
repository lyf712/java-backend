package com.lyf.httpweb.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liyunfei
 */
public class AbstractHttpClient {
   
    protected Socket socket = null;
   
    AbstractHttpClient(){
        init();
    }
    private void init(){
        socket = new Socket();
        try {
            socket.bind(new InetSocketAddress(80));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
