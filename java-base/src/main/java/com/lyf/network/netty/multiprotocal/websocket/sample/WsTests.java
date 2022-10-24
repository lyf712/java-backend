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

import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @authorliyunfei
 * @date2022/10/24
 **/
public class WsTests {
    final WsNettyServer wsNettyServer = new WsNettyServer();

    final Logger logger = Logger.getLogger(WsTests.class.getName());



    @Test
    public void testStart() {
        logger.log(Level.INFO,"test ws");
        System.out.printf("hello");//???为何不输出？？，等关闭才输出
        new Thread(()->{
            // 去获取online 每两秒轮询
            while (true){
                try {
                    logger.log(Level.INFO,"online is"+WsRequestHandler.getHandlerContextConcurrentHashMap().size()+":");
                    if(!WsRequestHandler.getHandlerContextConcurrentHashMap().isEmpty()){
                        logger.log(Level.INFO,"online is no empty");
                        WsRequestHandler.getHandlerContextConcurrentHashMap().forEach((k,v)->{
                            v.channel().writeAndFlush(new TextWebSocketFrame("hello"));
                        });
                    }else{
                        logger.log(Level.INFO,"online is empty");
                    }
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }).start();
        wsNettyServer.start();
        logger.log(Level.INFO,wsNettyServer.getChannel().toString());
    }
    // 会隔离--注意Test之间为保证正确性，进行了隔离，（采用副本机制
    @Test
    public void serverPush(){
        // 会单独启动虚拟机？为何获取就为0 了
        if(!WsRequestHandler.getHandlerContextConcurrentHashMap().isEmpty()){
            logger.log(Level.INFO,"online is no empty");
            WsRequestHandler.getHandlerContextConcurrentHashMap().forEach((k,v)->{
                v.channel().writeAndFlush("hello");
            });
        }else{
            logger.log(Level.INFO,"online is empty");
        }
        //wsNettyServer.getChannel().writeAndFlush(new TextWebSocketFrame("hello"));
    }
}
