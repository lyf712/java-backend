package com.lyf.network.netty.nio.sample;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author liyunfei
 */
public class MutilReactorTask implements Runnable{
    
    private ServerSocketChannel serverSocketChannel;
    
    private Selector selector;
    
    private int port;
    
    private volatile boolean stop;
    
    public MutilReactorTask(int port) {
        this.port = port;
        init();
    }
    
    private void init(){
        System.out.println("init MutilReactorTask("+port+")");
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(port));
            selector = Selector.open();
            serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            System.out.println("init failed");
            e.printStackTrace();
        }
    }
    
    public void stop(){
        stop = false;
    }
    
    @Override
    public void run() {
        while (!stop){
            try {
                int num = selector.select(1000);
                System.out.println("轮询到的channel数量为:"+num);
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeySet.iterator();
                while (iterator.hasNext()){
                       SelectionKey selectionKey =  iterator.next();
                       iterator.remove();
                       System.out.println("监听到通道::"+selectionKey);
                       if(selectionKey.isValid()){
                           if(selectionKey.isAcceptable()){
                               System.out.println("接入连接，TCP处理，三次握手");
                               ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                               SocketChannel socketChannel = serverSocketChannel.accept();
                               socketChannel.configureBlocking(false);
                               socketChannel.register(selector,SelectionKey.OP_READ);
                           }
                           if(selectionKey.isReadable()){
                              handleInput(selectionKey);
                           }
                       }
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void handleInput(SelectionKey selectionKey){
        System.out.println("读入数据");
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer buffer = ByteBuffer.allocate(100);
        try {
            socketChannel.read(buffer);
            System.out.println("接受到数据：："+new String(buffer.array()));
            socketChannel.write(ByteBuffer.wrap("server receive ok!".getBytes()));
            //socketChannel.socket().getOutputStream().write("ok".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
