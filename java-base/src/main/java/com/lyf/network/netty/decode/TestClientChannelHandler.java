package com.lyf.network.netty.decode;

import com.lyf.network.netty.decode.msg.TestRequest;
import com.lyf.network.netty.sequence.cases.Request;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.StringUtil;

import java.nio.Buffer;
import java.util.Scanner;

/**
 * @author liyunfei
 */
public class TestClientChannelHandler extends ChannelHandlerAdapter {
    
    private  ChannelHandlerContext ctx;
    // 计数客户端发送的包数量-flush刷新则是发送一次
    private int counter=0;
    private final int PACKAGE_SIZE = 100;
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("exception:"+cause.getMessage());
        super.exceptionCaught(ctx, cause);
    }
    
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
       // super.channelActive(ctx);
        // 直接写入字符串是无反应的
        //ctx.writeAndFlush("hello,i am client");
    
//        ByteBuf buf = Unpooled.copiedBuffer("hello,i am client".getBytes());
//        ctx.writeAndFlush(buf);
//        this.ctx = ctx;
        
        // 测试chatroom - 需要介绍才能执行channelRead
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        while (!input.equals("exit")){
//            input = scanner.nextLine();
//            ByteBuf buf = Unpooled.copiedBuffer(input.getBytes());
//            ctx.writeAndFlush(buf);
//        }
    
        // 发生字符串
        //ctx.writeAndFlush("hello,i am client,string test");
        
        // 发送Java对象
        //  An exceptionCaught() event was fired, and it reached at the tail of the pipeline. It usually means the last handler in the pipeline did not handle the exception.
        //  java.net.SocketException: Connection reset
        // ctx.writeAndFlush(new Request());
        // 需要配置解码器
        
        // ctx.writeAndFlush(new TestRequest());
        // 测试粘包-客户端模拟
        stickPackage(ctx);
    }
    
    /**
     * client receive:package-1
     * ===============================
     * client receive:   t ok   t ok
     *
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        counter++;
        System.out.println("client receive:package-"+counter);
        System.out.println("===============================");
        if(msg instanceof ByteBuf){
            ByteBuf buf = (ByteBuf) msg;
            byte[] bytes= new byte[buf.readableBytes()];
            buf.readBytes(bytes);
            System.out.println("client receive:"+new String(bytes));
        }else if(msg instanceof String){
            System.out.println("client receive:"+msg);
        }

    }
    
    
    
    public ChannelHandlerContext getCtx() {
        return ctx;
    }
    
    //粘包：（1）发生压力过大，不同的包粘在一起 （2）包过大
    void stickPackage(ChannelHandlerContext ctx) throws Exception{
        for(int i=0;i<PACKAGE_SIZE;i++){
            String msg = "client send msg("+i+")"+System.getProperty("line.separator");
            ByteBuf buf = Unpooled.copiedBuffer(msg.getBytes());
            ctx.writeAndFlush(buf);
        }
    }
    
    
    
    
}
