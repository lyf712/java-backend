/*
 *    Copyright 1999-2022  lyf712
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.lyf.network.netty.multiprotocal.websocket.sample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * netty的ws是基于HTTP进行实现，pingpong;基本过程如下：
 * 1.HTTP握手请求，成功之后建立连接，即可相互通信
 * 2.通信的Frame可以为Text
 * 3.双方可主动关闭连接（正常、攻击意外）
 * client:Html5 or Postman
 * @authorliyunfei
 * @date2022/10/24
 **/
public class WsNettyServer {
    private final int port = 8080;
    private final ServerBootstrap serverBootstrap = new ServerBootstrap();
    private final EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    private final EventLoopGroup workGroup = new NioEventLoopGroup(2);
    private final Logger logger = Logger.getLogger(WsNettyServer.class.getName());

    private Channel channel;

    private WsRequestHandler wsRequestHandler;

    public void start() {
        logger.log(Level.INFO,"start ws server");
        serverBootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                                   socketChannel.pipeline().addLast("http-codec",new HttpServerCodec());
                                   socketChannel.pipeline().addLast("aggregator",new HttpObjectAggregator(65536));
                                   socketChannel.pipeline().addLast("http-chunked",new ChunkedWriteHandler());
                                   wsRequestHandler = new WsRequestHandler();
                                   socketChannel.pipeline().addLast("handler",wsRequestHandler);
                    }
                });
        try {
            Channel channel = serverBootstrap.bind(port).sync().channel();// .sync()
            logger.log(Level.INFO,"start successfully at "+port);
            this.channel = channel;
            int count = 1;
//            while (true){
//                channel.writeAndFlush(new TextWebSocketFrame("ok"+count++));
//                logger.log(Level.INFO,"auto send");
//                TimeUnit.SECONDS.sleep(2);
//            }
            channel.closeFuture().sync();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    public Channel getChannel(){
        return channel;
    }

    public WsRequestHandler getWsRequestHandler() {
        return wsRequestHandler;
    }
}
