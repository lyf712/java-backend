package com.lyf.mockos.server.cpu;

import java.util.concurrent.ThreadFactory;

/**
 * @author liyunfei
 */
public class NameThreadFactory implements ThreadFactory {
    
    
    
    @Override
    public Thread newThread(Runnable r) {
        r.run();
        return null;
    }
}
