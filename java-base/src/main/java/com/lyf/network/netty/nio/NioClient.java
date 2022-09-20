package com.lyf.network.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author liyunfei
 */
public class NioClient {
    
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.bind(new InetSocketAddress("localhost",90));
            socketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            boolean isConnection = socketChannel.connect(new InetSocketAddress("localhost",80));
            if(isConnection){
                socketChannel.register(selector,SelectionKey.OP_READ);
                socketChannel.write(ByteBuffer.wrap("hello".getBytes()));
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}
