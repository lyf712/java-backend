package com.lyf.network.netty.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author liyunfei
 */
public class NioServer {
    
    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();
            ServerSocket socket = new ServerSocket(99);
            ServerSocketChannel serverSocketChannel = socket.getChannel();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
    
            SocketChannel socketChannel = serverSocketChannel.accept();
            //socketChannel.
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
    }
}
