package com.lyf.network.netty.sequence.cases;

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
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.net.InetSocketAddress;

/**
 * @author liyunfei
 */
public class DemoNettyClient2 {
    
    private final static int PORT = 80;
    
    public static void main(String[] args) {
        EventLoopGroup workGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workGroup)
                .channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
//                        socketChannel.pipeline()
////                                .addLast(new ObjectDecoder(1024, ClassResolvers
////                                        .cacheDisabled(this.getClass().getClassLoader())));
//                                  .addLast(new ByteArrayDecoder());
//                        socketChannel.pipeline()
//                                .addLast(new ByteArrayEncoder());
//                                .addLast(new ObjectEncoder());
                        
                        
                        socketChannel.pipeline().addLast(new ChannelHandlerAdapter() {
                            @Override
                            public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                //ByteBuf buf = Unpooled.copiedBuffer("hello,i am client".getBytes());
                                //ctx.writeAndFlush(buf);
                                Request request = new Request();
                                request.setUsername("client-1");
                                request.setParam("hello");
                                ctx.writeAndFlush(request);
                            }
                            
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//                                ByteBuf buf = (ByteBuf) msg;
//                                byte[] bytes = new byte[buf.readableBytes()];
//                                buf.readBytes(bytes);
                                System.out.println("client receive::" + msg);//new String(bytes));
                               // super.channelRead(ctx, msg);
                            }
                            
                            @Override
                            public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                                System.out.println(cause.getMessage());
                            }
                        });
//                        socketChannel.pipeline() .addLast(new ObjectEncoder())
                        ;
                    }
                });
        
        try {
            ChannelFuture future = bootstrap.connect(new InetSocketAddress("localhost", PORT)).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
