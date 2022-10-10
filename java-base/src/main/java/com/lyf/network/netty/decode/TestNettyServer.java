package com.lyf.network.netty.decode;

import com.google.protobuf.MessageLite;
import com.lyf.network.netty.sequence.cases.RequestProto;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author liyunfei
 */
public class TestNettyServer {
    
    public static void main(String[] args) {
        // 工作线程组
        final EventLoopGroup mainGroup = new NioEventLoopGroup();
        final EventLoopGroup workGroup = new NioEventLoopGroup();
        // 进行启动，连接，处理
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap
                    .group(mainGroup,workGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,ConfigConstant.CHANNEL_OPTION_SO_BACKLOG_SIZE)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                               socketChannel.pipeline().addLast(new StringDecoder());
                               socketChannel.pipeline().addLast(new StringEncoder());
                               
                               socketChannel.pipeline().addLast(
                                       new ObjectDecoder(1024*1024,
                                               ClassResolvers.weakCachingResolver(this.getClass().getClassLoader()))
                                       );
                               socketChannel.pipeline().addLast(
                                       new ObjectEncoder()
                               );
                               
                               socketChannel.pipeline().addLast(new ProtobufVarint32FrameDecoder());
                               socketChannel.pipeline().addLast(new ProtobufDecoder(RequestProto.Request.getDefaultInstance()));
                               socketChannel.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
                               socketChannel.pipeline().addLast(new ProtobufEncoder());
                               
                               // 添加编解码进pipeline
                               socketChannel.pipeline()
                                            .addLast(new TestServerChannelHandler());
                               // 思考 selector的体现？，封装在底层去轮询channel了？
                        }
                    });
            ChannelFuture future = serverBootstrap.bind(ConfigConstant.SERVER_PORT).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            //e.printStackTrace();
            // 引入日志--log4j
            System.out.println(""+e.getMessage());
        } finally {
            workGroup.shutdownGracefully();
            mainGroup.shutdownGracefully();
        }
    }
}
