package com.lyf.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author liyunfei
 */
@RefreshScope
// 需要进行在Application标识
@ConfigurationProperties(prefix = "user2")
// 看Application是否重启
public class UserBean2 implements InitializingBean, DisposableBean {
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
    
    @Override
    public void destroy() throws Exception {
        System.out.println("UserBean2 destroy");
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
    
    }
}
