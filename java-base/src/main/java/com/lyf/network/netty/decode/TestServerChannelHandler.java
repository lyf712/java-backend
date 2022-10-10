package com.lyf.network.netty.decode;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * TODO 分析适配器的设计
 *
 * @author liyunfei
 */
public class TestServerChannelHandler extends ChannelHandlerAdapter {
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
    
    /**
     *
     * @param ctx channel的上下文 -- 讨论类型定义
     * @param msg 消息传输的 -- 讨论编解码和序列化
     * @throws Exception 异常
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //super.channelRead(ctx, msg);
        if(msg instanceof ByteBuf){
            ByteBuf buf = (ByteBuf) msg;
            byte[] bytes= new byte[buf.readableBytes()];
            buf.readBytes(bytes);
            System.out.println("server receive:"+new String(bytes));
            ctx.writeAndFlush(Unpooled.copiedBuffer("ok".getBytes()));//"ok"
        }else if(msg instanceof String){
            System.out.println("server receive:"+msg);
            ctx.writeAndFlush("ok");
        }
        
     
    }
}
