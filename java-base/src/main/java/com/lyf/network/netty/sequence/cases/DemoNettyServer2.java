package com.lyf.network.netty.sequence.cases;

import io.netty.bootstrap.ServerBootstrap;
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
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * @author liyunfei
 */
public class DemoNettyServer2 {
    public final static int PORT = 80;
    
    public static void main(String[] args) {
     
        EventLoopGroup workGroup = new NioEventLoopGroup();
        EventLoopGroup majorGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap
                    .group(majorGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ByteBuf demiter = Unpooled.copiedBuffer("$_".getBytes());
//                            socketChannel.pipeline()
////                                    .addLast(new ObjectDecoder(1024*1024, ClassResolvers
////                                            .weakCachingResolver(
////                                            this.getClass().getClassLoader()
////                                    )));
//                                     .addLast(new ByteArrayDecoder());
//                            socketChannel.pipeline().addLast(new ByteArrayEncoder());
                            
                            
                            socketChannel.pipeline()      .addLast(new ChannelHandlerAdapter() {
                                        @Override
                                        public void channelRead(ChannelHandlerContext ctx, Object msg)
                                                throws Exception {
//                                            ByteBuf buf = (ByteBuf) msg;
//                                            byte[] bytes = new byte[buf.readableBytes()];
//                                            buf.readBytes(bytes);
//                                            System.out.println("server receive::" + new String(bytes));
//                                            ByteBuf respBytes = Unpooled.copiedBuffer("ok".getBytes());
                                            System.out.println("receive:"+msg);
                                            Response response = new Response();
                                            response.setStatus(200);
                                            response.setData("ok");
                                            ctx.writeAndFlush(response);
                                        }
                                    });
//                            socketChannel.pipeline()          .addLast(new ObjectEncoder());
                        
                        }
                    });
            // 绑定，阻塞监听-- selector的作用？
            ChannelFuture f = serverBootstrap.bind(PORT).sync();
            // 同步--结束
            f.channel().closeFuture().sync();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
    }
}
