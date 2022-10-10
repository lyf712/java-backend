package com.lyf.network.netty.sequence.cases;

import java.io.Serializable;

/**
 * @author liyunfei
 */
public class Request implements Serializable {
       private final static long serialVersionUID = 431231231L;
       private String username;
       private String param;
       
       public String getUsername() {
              return username;
       }
       
       public void setUsername(String username) {
              this.username = username;
       }
       
       public String getParam() {
              return param;
       }
       
       public void setParam(String param) {
              this.param = param;
       }
       
       @Override
       public String toString() {
              return "Request{" + "username='" + username + '\'' + ", param='" + param + '\'' + '}';
       }
}
