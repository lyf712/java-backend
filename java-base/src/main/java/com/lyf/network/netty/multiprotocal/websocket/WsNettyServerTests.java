package com.lyf.network.netty.multiprotocal.websocket;

import org.junit.Test;

/**
 * @author liyunfei
 */
public class WsNettyServerTests {
       private WsNettyServer wsNettyServer = WsNettyServer.getInstance();
       @Test
       public void test(){
           wsNettyServer.startServer();
       }
}
