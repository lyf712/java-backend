package com.lyf.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author liyunfei
 */
@RefreshScope
// 需要进行在Application标识
@ConfigurationProperties(prefix = "user1")
public class UserBean1 {
     private String userName;
     private Integer age;
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
}
