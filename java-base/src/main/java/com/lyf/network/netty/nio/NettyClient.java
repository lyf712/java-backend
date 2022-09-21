package com.lyf.network.netty.nio;

import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;

/**
 * @author liyunfei
 */
public class NettyClient {
    
    public static void main(String[] args) {
    
        NioEventLoop eventLoop;//new NioEventLoop();
        
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
    
        DelimiterBasedFrameDecoder delimiterBasedFrameDecoder  ;//= new DelimiterBasedFrameDecoder();
        
    }
}
