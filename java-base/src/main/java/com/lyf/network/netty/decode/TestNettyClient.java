package com.lyf.network.netty.decode;

import com.lyf.network.netty.sequence.cases.RequestProto;
import com.lyf.network.netty.sequence.cases.ResponseProto;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.Scanner;

/**
 * @author liyunfei
 */
public class TestNettyClient {
    
    public static void main(String[] args) {
        final EventLoopGroup eventGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            TestClientChannelHandler testClientChannelHandler = new TestClientChannelHandler();
            bootstrap.group(eventGroup)
                     .channel(NioSocketChannel.class)
                     .option(ChannelOption.TCP_NODELAY,true)
                     .handler(new ChannelInitializer<SocketChannel>() {
                         @Override
                         protected void initChannel(SocketChannel socketChannel) throws Exception {
                             // 解决粘包问题--Java NIO原生自带解码器，使得无需关注底层实现
                             socketChannel.pipeline().addLast(
                                     new LineBasedFrameDecoder(1024)
                             );
                             
                             socketChannel.pipeline().addLast(new StringDecoder());
                             socketChannel.pipeline().addLast(new StringEncoder());

                             socketChannel.pipeline().addLast(
                                     new ObjectDecoder(1024,
                                             ClassResolvers.cacheDisabled(this.getClass().getClassLoader()))
                             );
                             socketChannel.pipeline().addLast(
                                     new ObjectEncoder()
                             );
    
    
                             socketChannel.pipeline().addLast(new ProtobufVarint32FrameDecoder());
                             // client接受响应，对resp解码即可
                             socketChannel.pipeline().addLast(new ProtobufDecoder(ResponseProto.Request.getDefaultInstance()));
                             socketChannel.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
                             socketChannel.pipeline().addLast(new ProtobufEncoder());
                             
                             
                             socketChannel.pipeline()
                                          .addLast(testClientChannelHandler);
                                   
                         }
                     });
            
            //testClientChannelHandler.write();
            //testClientChannelHandler.getCtx().writeAndFlush();
            
            ChannelFuture future = bootstrap
                    .connect(new InetSocketAddress("localhost",ConfigConstant.SERVER_PORT))
//                    .addListener(listener->{
//                        //listener.
//                    })
                    .sync();
            future.channel().closeFuture().sync();
            
            
            // 聊天室进行持续发短信
//            Channel channel = bootstrap
//                    .connect(new InetSocketAddress("localhost",ConfigConstant.SERVER_PORT))
//                    .sync()
//                    .channel();
//
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("please start chat");
//            String input;
//            while (!( input = scanner.nextLine()).equals("exit")){
//                System.out.println("send "+input);
//                channel.writeAndFlush(Unpooled.copiedBuffer(input.getBytes()));//input.getBytes() - 需要加String编码器
//            }
        
        
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            eventGroup.shutdownGracefully();
        }
    }
    
    
}
