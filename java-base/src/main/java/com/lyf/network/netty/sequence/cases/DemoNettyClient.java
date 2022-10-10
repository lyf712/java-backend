package com.lyf.network.netty.sequence.cases;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * 在Netty通信的基础上进行 添加proto通信
 *
 * @author liyunfei
 */
public class DemoNettyClient {
    
    public static void main(String[] args) {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                     .channel(NioSocketChannel.class)
                     .option(ChannelOption.TCP_NODELAY,true)
                     //.option(ChannelOption.SO_BACKLOG,1024)
                     .handler(new ChannelInitializer<SocketChannel>() {
                         @Override
                         protected void initChannel(SocketChannel socketChannel) throws Exception {
                                   socketChannel.pipeline()
                                           .addLast(new ObjectDecoder(1024,
                                                   ClassResolvers
                                                          .cacheDisabled(this.getClass().getClassLoader())))
                                           .addLast(new ChannelHandlerAdapter(){
                                               @Override
                                               public void connect(ChannelHandlerContext ctx,
                                                       SocketAddress remoteAddress, SocketAddress localAddress,
                                                       ChannelPromise promise) throws Exception {
                                                   System.out.println("connect");
                                                   System.out.println("connected!");
                                                   Request request = new Request();
                                                   request.setParam("test");
                                                   request.setUsername("client");
                                                   ctx.writeAndFlush(request);
                                                   //super.connect(ctx, remoteAddress, localAddress, promise);
                                              
                                               }
    
                                               @Override
                                               public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                                   //super.channelActive(ctx);
                                                   System.out.println("active");
                                                   Request request = new Request();
                                                   request.setParam("test");
                                                   request.setUsername("client");
                                                   ctx.writeAndFlush(request);
                                               }
    
                                               @Override
                                               public void channelRead(ChannelHandlerContext ctx, Object msg)
                                                       throws Exception {
                                                   System.out.println("client receive:"+msg);
                                               }
                                           })
                                           .addLast(new ObjectEncoder())
                                   ;
                                   
                         }
                     });
            ChannelFuture future =
                    bootstrap.connect(new InetSocketAddress("localhost",8080)).sync();
            future.channel().closeFuture().sync();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        
        }
    }
}
