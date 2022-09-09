package com.lyf.mockos.client;

/**
 * @author liyunfei
 */
public class JdkNetService implements NetService{
    private NetService delegate;
    
    public JdkNetService() {
    }
    
    public JdkNetService(NetService delegate) {
        if(delegate instanceof JdkNetService){
            delegate = new JdkNetService();
        }
        this.delegate = delegate;
    }
    
    @Override
    public String send() {
        return null;
    }
}
