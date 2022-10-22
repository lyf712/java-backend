package com.lyf.network.netty.multiprotocal.websocket;

import com.lyf.network.netty.multiprotocal.BaseNettyServer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

/**
 * @author liyunfei
 */
public class WsNettyServer extends BaseNettyServer {
    
    private final int port = 8877;
    
    private static final WsNettyServer wsNettyServer = new WsNettyServer();
    
    public static WsNettyServer getInstance() {
        return wsNettyServer;
    }
    
    private WsNettyServer() {
        init();
    }
    
    @Override
    protected void init() {
        super.init();
        // 是子类共用父类属性还是？
        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new HttpRequestDecoder());
                socketChannel.pipeline().addLast(new HttpRequestEncoder());
                socketChannel.pipeline().addLast(new SimpleChannelInboundHandler<Object>() {
                    @Override
                    protected void messageReceived(ChannelHandlerContext channelHandlerContext, Object o)
                            throws Exception {
                        System.out.println(o);
                        
                        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                                HttpResponseStatus.OK);//, Unpooled.copiedBuffer("ok".getBytes())
                        String respHtml = "<html>" + "<h>Hello</h>" + "<li>link</li>" + "</html>";
                        response.content().writeBytes(respHtml.getBytes());
                        
                        channelHandlerContext.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
                    }
                });
            }
        });
    }
    
    @Override
    public void startServer() {
        try {
            ChannelFuture future = serverBootstrap.bind(port).sync();
            System.out.println("start success at " + port);
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
    
}
