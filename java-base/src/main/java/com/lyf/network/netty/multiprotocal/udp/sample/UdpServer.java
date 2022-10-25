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
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

/**
 * @authorliyunfei
 * @date2022/10/25
 **/
public class UdpServer {
    private static final int port = 8080;
    private static final Bootstrap bootstrap = new Bootstrap();
    private static final EventLoopGroup workGroup = new NioEventLoopGroup();

    public void start() throws InterruptedException {
        try {
            bootstrap.group(workGroup)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new UdpServerHandler());
            bootstrap.bind(port).sync().channel().closeFuture().await(); // awaite 和 waite:current thread is not owner
            // https://blog.csdn.net/hudaJY/article/details/89057626
            // await 采用Lock
        } finally {
            workGroup.shutdownGracefully();
        }
    }

//    public static void main(String[] args) throws InterruptedException {
//        //new UdpServer().start();
//        Bootstrap bootstrap = new Bootstrap();
//        try {
//            bootstrap.group(workGroup)
//                    .channel(NioDatagramChannel.class)
//                    .option(ChannelOption.SO_BROADCAST, true)
//                    .handler(new UdpServerHandler());
//            bootstrap.bind(port).sync().channel().closeFuture().await(); //current thread is not owner
//        } finally {
//            workGroup.shutdownGracefully();
//        }
//    }

}
