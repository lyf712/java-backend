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

package com.lyf.network.netty.multiprotocal.udp.sample;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.net.InetSocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @authorliyunfei
 * @date2022/10/25
 **/
public class UdpClient {

    private final int port = 8080;
    private final Bootstrap bootstrap = new Bootstrap();
    private final EventLoopGroup workGroup = new NioEventLoopGroup();

    private final Logger logger = Logger.getLogger(UdpClient.class.getName());

    public void start() throws InterruptedException {
        try {
            bootstrap.group(workGroup)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new UdpClientHandler());
            Channel channel = bootstrap.bind(0).sync().channel();
            // 发送至该网段所有机器
            channel.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("query".getBytes()),new InetSocketAddress("255.255.255.255",port)));
            if(!channel.closeFuture().await(60*1000)){
                System.out.println("time out!");
                logger.log(Level.WARNING,"time out!");
            }
        } finally {
            workGroup.shutdownGracefully();
        }
    }

}
