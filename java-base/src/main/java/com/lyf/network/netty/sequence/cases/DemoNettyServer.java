package com.lyf.network.netty.sequence.cases;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.net.InetSocketAddress;
import java.util.logging.Logger;

/**
 * @author liyunfei
 */
public class DemoNettyServer {
    private static final Logger logger = Logger.getLogger("DemoNettyServer");
    
    public static void main(String[] args) {
        EventLoopGroup mainGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        
        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap
                    .group(mainGroup,workGroup)
                    .channel(NioServerSocketChannel.class)
                    // 配置连接阻塞队列数等--基于socket层面的交互
                    .option(ChannelOption.SO_BACKLOG,1024)
                    // TODO 该处的channel的类型思考
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                                  channel.pipeline()
                                          // 序列化解码
                                          .addLast(new ObjectDecoder(1024*1024,
                                              ClassResolvers.weakCachingResolver(this.getClass().getClassLoader())))
                                         // 处理连接和信息交互
                                          .addLast(new ChannelHandlerAdapter(){
                                              @Override
                                              public void channelRead(ChannelHandlerContext ctx, Object msg)
                                                      throws Exception {
                                                  Request request = (Request)msg;
                                                  System.out.println("netty server receive:"+request);
                                                  //super.channelRead(ctx, msg);
                                                  // 逻辑处理加工   request  mapping to response
                                                  
                                                  Response response = new Response();
                                                  response.setData("ok");
                                                  response.setStatus(200);
                                                  ctx.writeAndFlush(response);
                                              }
    
                                              @Override
                                              public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
                                                      throws Exception {
                                                  System.out.println("ece:"+cause.getMessage());
                                                  super.exceptionCaught(ctx, cause);
                                              }
                                          })
                                          .addLast(new ObjectEncoder());
                            ;
                        }
                    });
            ChannelFuture future = serverBootstrap.bind(new InetSocketAddress("localhost",8080))
                    .sync();
            future.channel().closeFuture().sync();
            
        }catch (Exception e){
            logger.info("err:"+e.getMessage());
        }finally {
            mainGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
