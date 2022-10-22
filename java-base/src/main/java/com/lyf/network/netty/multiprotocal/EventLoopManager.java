package com.lyf.network.netty.multiprotocal;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * @author liyunfei
 */
public class EventLoopManager {
    
    private static class Param {
        
        private static final int nBossThreads = 1;
        
        private static final int nWorkThreads = 2;
    }
    
    public static final EventLoopGroup bossGroup = new NioEventLoopGroup(Param.nBossThreads); //getWorkGroup();
    
    public static final EventLoopGroup workGroup = new NioEventLoopGroup(Param.nWorkThreads); //getWorkGroup();
    
    
}
