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

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @authorliyunfei
 * @date2022/10/24
 **/
public class WsRequestHandler extends SimpleChannelInboundHandler<Object> {
    private final Logger logger = Logger.getLogger(WsNettyServer.class.getName());
    private WebSocketServerHandshaker webSocketServerHandshaker;

    private static ChannelHandlerContext channelHandlerContext;

    private long count = 1;

    private static volatile ConcurrentHashMap<String,ChannelHandlerContext> handlerContextConcurrentHashMap = new ConcurrentHashMap<>(8);

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, Object msg) throws Exception {
        if (msg instanceof FullHttpRequest) {
            // 处理HTTP请求
            logger.log(Level.INFO,"req http");
            handleHttpRequest(channelHandlerContext, (FullHttpRequest) msg);
        } else if (msg instanceof WebSocketFrame) {
            // 处理WS帧
            logger.log(Level.INFO,"req ws");
            handleWebsocketFrame(channelHandlerContext, (WebSocketFrame) msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.log(Level.WARNING, cause.getMessage());
        ctx.close();
    }

    private void handleHttpRequest(ChannelHandlerContext context, FullHttpRequest request) {
        // 判断是否合法(HTTP状态、upgrade是否标识)，是否是WS的第一次握手
        if (request.getDecoderResult().isFailure() || !"websocket".equals(request.headers().get("upgrade"))) {
            sendHttpResp(context, request, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return;
        }
        logger.log(Level.INFO,"first hand");
        // 构造WS shacker进行第一次握手
        WebSocketServerHandshakerFactory webSocketServerHandshakerFactory = new WebSocketServerHandshakerFactory(
                "ws://localhost:8080/ws/send", null, false
        );
        webSocketServerHandshaker = webSocketServerHandshakerFactory.newHandshaker(request);
        if (webSocketServerHandshaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedWebSocketVersionResponse(context.channel());
        } else {
            webSocketServerHandshaker.handshake(context.channel(), request);
            handlerContextConcurrentHashMap.put("user-"+count,context);
            logger.log(Level.INFO,"join user-"+count++);
            logger.log(Level.INFO,"num is"+handlerContextConcurrentHashMap.size()+"");

        }
    }

    private void handleWebsocketFrame(ChannelHandlerContext context, WebSocketFrame webSocketFrame) {
        // ping、close、text
        if(webSocketFrame instanceof CloseWebSocketFrame){
            webSocketServerHandshaker.close(context.channel(),((CloseWebSocketFrame) webSocketFrame).retain());
            return;
        }
        if(webSocketFrame instanceof PingWebSocketFrame){
            logger.log(Level.INFO,"ping");
            context.channel().writeAndFlush(new PongWebSocketFrame(webSocketFrame.content().retain()));
            return;
        }
        if(!(webSocketFrame instanceof TextWebSocketFrame)){
            throw new UnsupportedOperationException("un support non text for ws");
        }
        String request = ((TextWebSocketFrame) webSocketFrame).text();
        logger.log(Level.INFO,"resp ...");
        //context.channel().writeAndFlush(request+",welcome ws ,now is :"+new Date());
        channelHandlerContext = context;
        context.channel().writeAndFlush(new TextWebSocketFrame(request+"-welcome ws,now time is"+new Date()));
    }

    private void sendHttpResp(ChannelHandlerContext context, FullHttpRequest request, FullHttpResponse response) {

        if (response.getStatus().code() != 200) {
            ByteBuf byteBuf = Unpooled.copiedBuffer(response.getStatus().toString().getBytes());
            response.content().writeBytes(byteBuf);
            byteBuf.release();
            //context.writeAndFlush(byteBuf);
            //
        }

        // 处理关闭连接
        ChannelFuture channelFuture = context.channel().writeAndFlush(response);
        if(!Boolean.parseBoolean(request.headers().get("keep-alive")) || response.getStatus().code()!=200){
            //channelFuture.channel().close();
            channelFuture.addListener(ChannelFutureListener.CLOSE);
            // remove map---
        }
    }

    public static ConcurrentHashMap<String, ChannelHandlerContext> getHandlerContextConcurrentHashMap() {
        Logger logger1 = Logger.getLogger("static");
        logger1.log(Level.INFO,handlerContextConcurrentHashMap.size()+":");
        return handlerContextConcurrentHashMap;
    }
}
