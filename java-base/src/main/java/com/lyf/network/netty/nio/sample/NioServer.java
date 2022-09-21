package com.lyf.network.netty.nio.sample;

/**
 * @author liyunfei
 */
public class NioServer {
    
    public static void main(String[] args) {
           new Thread(new MutilReactorTask(99)).start();
    }
}
