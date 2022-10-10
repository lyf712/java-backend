package com.lyf.network.netty.sequence.cases;

import java.io.Serializable;

/**
 * @author liyunfei
 */
public class Response implements Serializable {
    private final static long serialVersionUID = 3123131231L;
    private Integer status;
    private String data;
    
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "Response{" + "status=" + status + ", data='" + data + '\'' + '}';
    }
}
