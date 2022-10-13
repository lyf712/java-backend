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
    
    private int counter = 0;
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
    
    /**
     * server receive:package-1
     * ===============================
     * server receive:client send msg(0)client send msg(1)client send msg(2)client send msg(3)client send msg(4)client send msg(5)client send msg(6)client send msg(7)client send msg(8)client send msg(9)client send msg(10)client send msg(11)client send msg(12)client send msg(13)client send msg(14)client send msg(15)client send msg(16)client send msg(17)client send msg(18)client send msg(19)client send msg(20)client send msg(21)client send msg(22)client send msg(23)client send msg(24)client send msg(25)client send msg(26)client send msg(27)client send msg(28)client send msg(29)client send msg(30)client send msg(31)client send msg(32)client send msg(33)client send msg(34)client send msg(35)client send msg(36)client send msg(37)client send msg(38)client send msg(39)client send msg(40)client send msg(41)client send msg(42)client send msg(43)client send msg(44)client send msg(45)client send msg(46)client send msg(47)client send msg(48)client send msg(49)client send msg(50)client send msg(51)client send msg(52)client send msg(53)client s
     * server receive:package-2
     * ===============================
     * server receive:end msg(54)client send msg(55)client send msg(56)client send msg(57)client send msg(58)client send msg(59)client send msg(60)client send msg(61)client send msg(62)client send msg(63)client send msg(64)client send msg(65)client send msg(66)client send msg(67)client send msg(68)client send msg(69)client send msg(70)client send msg(71)client send msg(72)client send msg(73)client send msg(74)client send msg(75)client send msg(76)client send msg(77)client send msg(78)client send msg(79)client send msg(80)client send msg(81)client send msg(82)client send msg(83)client send msg(84)client send msg(85)client send msg(86)client send msg(87)client send msg(88)client send msg(89)client send msg(90)client send msg(91)client send msg(92)client send msg(93)client send msg(94)client send msg(95)client send msg(96)client send msg(97)client send msg(98)client send msg(99)
     *
     * @param ctx channel的上下文 -- 讨论类型定义
     * @param msg 消息传输的 -- 讨论编解码和序列化
     * @throws Exception 异常
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //super.channelRead(ctx, msg);
        counter++;
        System.out.println("server receive:package-"+counter);
        System.out.println("===============================");
        if(msg instanceof ByteBuf){
            ByteBuf buf = (ByteBuf) msg;
            byte[] bytes= new byte[buf.readableBytes()];
            buf.readBytes(bytes);
            System.out.println("server receive:"+new String(bytes));
            
            String resp = "ok("+counter+")"+System.getProperty("line.separator");// 注意加分隔符不然读取不了
            //发送String类型--
            ctx.writeAndFlush(resp);//"ok" //Unpooled.copiedBuffer(resp.getBytes())
            //FIXME Client收不到回信？？ --flush刷新问题？
            
            // ByteBuf 可以直接转String-
            
        }else if(msg instanceof String){
            System.out.println("server receive:"+msg);
            ctx.writeAndFlush("ok");
        }
        
     
    }
}
