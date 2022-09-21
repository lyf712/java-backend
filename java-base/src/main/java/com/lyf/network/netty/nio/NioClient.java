package com.lyf.network.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author liyunfei
 */
public class NioClient {
    
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.bind(new InetSocketAddress("localhost",80));
            socketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            boolean isConnection = socketChannel.connect(new InetSocketAddress("localhost",99));
            if(isConnection){
                System.out.println("connected");
                socketChannel.register(selector,SelectionKey.OP_READ);
//                socketChannel.write(ByteBuffer.wrap("hello".getBytes()));
            }else {
                // 还未收服务端的ack答应
                socketChannel.register(selector, SelectionKey.OP_CONNECT);
            }
            for (;;){
                int num = selector.select(1000);
                System.out.println("nio-client listened num is:"+num);
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> selectionKeyIterator = selectionKeySet.iterator();
                while (selectionKeyIterator.hasNext()){
                    SelectionKey selectionKey = selectionKeyIterator.next();
                    selectionKeyIterator.remove();
                    if(selectionKey.isValid()){
                        
                        System.out.println("客户端连接成功");
                        SocketChannel socketChannel1 =(SocketChannel) selectionKey.channel();
                        
                        if(selectionKey.isConnectable()){
                            System.out.println("Connectable");
                            if(socketChannel1.finishConnect()){
                                socketChannel1.register(selector,SelectionKey.OP_READ);
                                socketChannel1.write(ByteBuffer.wrap("client send ok".getBytes()));
                            }else {
                                //
                                System.out.println("exit..");
                                System.exit(1);
                            }
                        }
                        
                        if(selectionKey.isReadable()){
                            System.out.println("有数据读入");
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            socketChannel1.read(buffer);
                            System.out.println(new String(buffer.array()));
                            
                            // 要关闭链路！！
                            selectionKey.cancel();
                            socketChannel1.close();
                        }
                        
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}
