package com.lyf.network.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 */
public class NioServer {
    
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",80));
            serverSocketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            // Key 的使用
            serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            
            // 为什么先是轮询selector
            //SocketChannel socketChannel = serverSocketChannel.accept();
            
         
            int num = selector.select();
            System.out.println("num:"+num);
            Set<SelectionKey> keys= selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            
            
            SelectionKey selectionKey = null;
            System.out.println("::"+iterator.hasNext());
            
            for (;;){
                // jianting
                System.out.println("listening::"+iterator);
                while (iterator.hasNext()){
                    selectionKey =  iterator.next();
                    iterator.remove();
                    System.out.println("selectionKey::"+selectionKey);
                    if(selectionKey.isValid()){
                        System.out.println("valid::");
                        // 需要先接受新的连接,并注册到selector中
                        if(selectionKey.isAcceptable()){
                            System.out.println("accept::");
                            ServerSocketChannel socketChannel = (ServerSocketChannel) selectionKey.channel();
                            SocketChannel socketChannelAccept = socketChannel.accept();
                            socketChannelAccept.configureBlocking(false);
                            socketChannelAccept.register(selector,SelectionKey.OP_READ);
                            System.out.println(selector.selectedKeys().size());
                        }
            
                        if(selectionKey.isReadable()){
                            System.out.println("read data...");
                            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(100);
                            socketChannel.read(buffer);
                            System.out.println("receive::"+new String(buffer.array()));
                        }
                    }
                    iterator = selector.selectedKeys().iterator();
                }
                
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    
    }
}
