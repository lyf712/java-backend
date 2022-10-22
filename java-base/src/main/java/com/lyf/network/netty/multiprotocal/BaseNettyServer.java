package com.lyf.network.netty.multiprotocal;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author liyunfei
 */
public abstract class BaseNettyServer {
       
       protected ServerBootstrap serverBootstrap = new ServerBootstrap();
       
       protected EventLoopGroup bossGroup;
    
       protected EventLoopGroup workGroup;
       
       protected void init(){
               bossGroup = EventLoopManager.bossGroup;
               workGroup = EventLoopManager.workGroup;
               serverBootstrap.group(bossGroup,workGroup)
                              .channel(NioServerSocketChannel.class)
                              .option(ChannelOption.SO_BACKLOG,1024);
//                              .childHandler(new ChannelInitializer<SocketChannel>() {
//                                  @Override
//                                  protected void initChannel(SocketChannel socketChannel) throws Exception {
//
//                                  }
//                              });
       }
       
       public abstract void startServer();
       
       
}
