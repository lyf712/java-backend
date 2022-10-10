package com.lyf.network.netty.nio;

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
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author liyunfei
 */
public class NettyServer {
    
    public final static int PORT = 80;
    
    public static void main(String[] args) {
        // 创建服务端的线程组
        // TODO 类图分析，：多线程的设计思想讨论
        // EventLoopGroup extends EventExecutorGroup
        // EventExecutorGroup extends ScheduledExecutorService
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        
        try {
            // 辅助启动类，对channel的轮询等繁琐进行封装
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // TODO builder,链式设计思想分析？
            serverBootstrap
                    // 主线程组、从线程组？
                    .group(bossGroup, workGroup)
                    // 尝试其他channle-
                    .channel(NioServerSocketChannel.class)
                    // 参数配置
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    // 处理channel的消息，读写转换等
                    // 可以单独抽象出来一个类，解耦，方便灵活拓展
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ByteBuf demiter = Unpooled.copiedBuffer("$_".getBytes());
                            socketChannel.pipeline()
                                    // 解决拆包、粘包问题
                                    //.addLast(new DelimiterBasedFrameDecoder(1024, demiter)).addLast(new StringDecoder())
                                    .addLast(new ChannelHandlerAdapter() {
                                        @Override
                                        public void channelRead(ChannelHandlerContext ctx, Object msg)
                                                throws Exception {
                                            
                                            //super.channelRead(ctx, msg);
                                            ByteBuf buf = (ByteBuf) msg;
                                            byte[] bytes = new byte[buf.readableBytes()];
                                            buf.readBytes(bytes);
                                            System.out.println("server receive::" + new String(bytes));
                                            
                                            ByteBuf respBytes = Unpooled.copiedBuffer("ok".getBytes());
                                            ctx.writeAndFlush(respBytes);
                                        }
                                    })
                            
                            ;
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
