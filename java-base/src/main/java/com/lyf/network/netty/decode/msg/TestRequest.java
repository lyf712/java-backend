package com.lyf.network.netty.decode.msg;

import java.io.Serializable;

/**
 * @author liyunfei
 */
public class TestRequest implements Serializable {
    @java.io.Serial
    private static final long serialVersionUID = -6849712470754667710L;
    private long id;
    private String data;
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "TestRequest{" + "id=" + id + ", data='" + data + '\'' + '}';
    }
}
