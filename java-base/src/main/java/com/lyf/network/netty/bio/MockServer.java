package com.lyf.network.netty.bio;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liyunfei
 */
class SocketHandler implements Runnable{
    private Socket socket;
    
    public SocketHandler(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        InputStream in = null;
        try {
            in = socket.getInputStream();
//            InputStreamReader inputStreamReader = new InputStreamReader(in);
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            String readIn = bufferedReader.readLine();
            byte[] bytes = new byte[1024];
//            while(in.read(bytes) !=-1){
            in.read(bytes);
                System.out.println("receive::"+new String(bytes));
//            }
           
            socket.getOutputStream().write("ok".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class MockServer {
    private static final int port = 8080;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        for (;;){// 循环监听
            Socket socket = serverSocket.accept();
            // 伪异步IO，将此处改线程池，只能解决防止宕机，资源耗尽等情况，并不能实质上解决问题
            new Thread(new SocketHandler(socket)).start();
        }
    }
}
