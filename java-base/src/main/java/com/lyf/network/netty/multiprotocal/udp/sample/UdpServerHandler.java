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

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;

import java.nio.charset.Charset;
import java.util.Date;

//import java.net.DatagramPacket;

/**
 * @authorliyunfei
 * @date2022/10/25
 **/
public class UdpServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
        // if(datagramPacket.getData())
        String data = datagramPacket.content().toString(Charset.defaultCharset());//datagramPacket.getData();
        System.out.println(new Date()+"receive:" + data);
        if (data.equals("query")) {
            //channelHandlerContext.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("ok".getBytes()),datagramPacket.getSocketAddress()))
            channelHandlerContext.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("ok".getBytes()), datagramPacket.sender()));
        } else {
            channelHandlerContext.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("error param".getBytes()), datagramPacket.sender()));
        }
    }
}
