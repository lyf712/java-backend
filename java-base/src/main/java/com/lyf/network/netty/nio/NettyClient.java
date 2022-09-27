package com.lyf.network.netty.nio;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
//import java.nio.channels.SocketChannel;

/**
 * @author liyunfei
 */
public class NettyClient {
    
    private final static int PORT = 80;
    
    public static void main(String[] args) {
        // 创建工作线程组
        EventLoopGroup workGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        // 配置相应的参数
        bootstrap.group(workGroup)
                // .connect(NioSocketChannel.class)
                .channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
                // 主要去理解ChannelHandlerContext-
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new ChannelHandlerAdapter() {
                            @Override
                            public void channelActive(ChannelHandlerContext ctx) throws Exception {
                               // ctx.writeAndFlush("hello,i am client");
                                //   super.channelActive(ctx);
                                ByteBuf buf = Unpooled.copiedBuffer("hello,i am client".getBytes());
//                                byte[] bytes = "hello,i am client".getBytes();
//                                ByteBuf buf = Unpooled.copiedBuffer(bytes);
                                ctx.writeAndFlush(buf);
                            }
                            
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                ByteBuf buf = (ByteBuf) msg;
                                byte[] bytes = new byte[buf.readableBytes()];
                                buf.readBytes(bytes);
                                System.out.println("client receive::" + new String(bytes));
                                super.channelRead(ctx, msg);
                            }
                            
                            @Override
                            public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                                System.out.println(cause.getMessage());
                                //super.exceptionCaught(ctx, cause);
                            }
                        });
                    }
                });
        
        try {
            ChannelFuture future = bootstrap.connect(new InetSocketAddress("localhost", PORT)).sync();
            // 关闭连接
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
    }
}
