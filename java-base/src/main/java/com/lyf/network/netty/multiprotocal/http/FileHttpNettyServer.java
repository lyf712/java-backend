package com.lyf.network.netty.multiprotocal.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author liyunfei
 */
public class FileHttpNettyServer {
    
    public static void main(String[] args) {
        EventLoopGroup workGroup = new NioEventLoopGroup();
        EventLoopGroup mainGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(mainGroup,workGroup)
                           .channel(NioServerSocketChannel.class)
                           .option(ChannelOption.SO_BACKLOG,1024)
                           .childHandler(new ChannelInitializer<SocketChannel>() {
                               @Override
                               protected void initChannel(SocketChannel socketChannel) throws Exception {
                                   socketChannel.pipeline().addLast("http-decoder",new HttpRequestDecoder());
                                   socketChannel.pipeline().addLast("http-aggregator",new HttpObjectAggregator(65536));
                                   socketChannel.pipeline().addLast("http-encoder",new HttpResponseEncoder());
                                   //支持异步发送大的流编码
                                   socketChannel.pipeline().addLast("http-chunked",new ChunkedWriteHandler());
                                   socketChannel.pipeline().addLast(new HttpRequestHandler());
                               }
                           });
            ChannelFuture future = serverBootstrap.bind("localhost",80).sync();
            System.out.println("file server start at port 80 success!");
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
    
    }
}
