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

package analysis;

import io.netty.channel.*;
import io.netty.channel.local.LocalChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.util.concurrent.ExecutionException;

/**
 * @author liyunfei
 **/
public class ChannelTests {

    /**
     * channel的facade设计理解
     */

    @Test
    public void test1() throws FileNotFoundException {
//        Channel channel = (Channel) Channels.newChannel(new FileInputStream(""));
//        //channel.connect()
        Channel channel = new LocalChannel(new DefaultEventLoop());
        channel.pipeline().addLast(new MyInboundHandler());
        ChannelFuture future = channel.connect(new InetSocketAddress("www.baidu.com",80));
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static class MyInboundHandler extends ChannelHandlerAdapter{
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("Connected");
            super.channelActive(ctx);
        }
    }

}
