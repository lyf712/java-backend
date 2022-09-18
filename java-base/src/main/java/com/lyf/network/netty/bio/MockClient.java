package com.lyf.network.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author liyunfei
 */
public class MockClient {
    
    public static void main(String[] args) {
        try {
            Socket client = new Socket("127.0.0.1",8080);
            OutputStream outputStream = client.getOutputStream();
            outputStream.write("hello".getBytes());
            InputStream inputStream = client.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            while((len=inputStream.read(bytes))!=-1){
                System.out.println("receive::"+new String(bytes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}
