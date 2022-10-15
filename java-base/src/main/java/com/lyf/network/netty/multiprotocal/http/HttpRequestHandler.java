package com.lyf.network.netty.multiprotocal.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

import java.nio.charset.StandardCharsets;

/**
 * @author liyunfei
 */
public class HttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    
    private final static String DEFAULT_FILE_PATH = "E:\\JavaProjects\\LearnProjects\\java-backend\\java-base\\src\\main\\java\\com\\lyf\\network\\netty\\multiprotocal\\http\\files\\";
    
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, FullHttpRequest request) throws Exception {
              System.out.println(request);
              FullHttpResponse fullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
             
              // 处理 request →  resp
              // 同tomcat源码分析一致
             
              // 处理拦截--
//              if(request.getMethod().compareTo(HttpMethod.GET)!=0){
//                  return;
//              }
        
              // 返回页面（递归目录）
              //ByteBuf buf = Unpooled.copiedBuffer("".getBytes());
//              StringBuffer stringBuffer = new StringBuffer();
              String respHtml = "<html>"
                      + "<h>Hello</h>"
                      + "<li>link</li>"
                      + "</html>";
              
              fullHttpResponse.content().writeBytes(respHtml.getBytes(StandardCharsets.UTF_8));
              // 处理file
        
              // 写回响应
              channelHandlerContext.writeAndFlush(fullHttpResponse)
                      .addListener(ChannelFutureListener.CLOSE);
    }
    
    
    private void respDefaultHtml(){
    
    }
    
}
