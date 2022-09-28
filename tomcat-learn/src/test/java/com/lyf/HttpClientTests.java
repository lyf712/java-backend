package com.lyf;

import com.lyf.httpweb.client.DefaultHttpClient;
import com.lyf.httpweb.client.HttpClient;
import org.junit.Test;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 */
public class HttpClientTests {
    
    HttpClient httpClient = new DefaultHttpClient();
    
    // 连接一个，同时发10个，只能接收一个
    @Test
    public void testRequest() {
        httpClient.connect(new InetSocketAddress("localhost",8081));
        //
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                httpClient.send("hello! i am " + Thread.currentThread().getName());
            }).start();
        }
    }
    //
    @Test
    public void testRequestDifPort(){
        //
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            new Thread(() -> {
                httpClient.connect(new InetSocketAddress("localhost",8082+finalI));
                httpClient.send("hello! i am " + Thread.currentThread().getName());
            }).start();
        }
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
