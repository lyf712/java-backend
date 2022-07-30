package com.lyf.config;

import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author liyunfei
 */
@Component
public class BinderConfig implements SpringApplicationRunListener {
    
    private Integer num;
    
    private String url;
    
    public Integer getNum() {
        return num;
    }
    
    public void setNum(Integer num) {
        this.num = num;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    private ConfigurableEnvironment configurableEnvironment;
    
    @PostConstruct
    void init() {
        System.out.println(num);
        System.out.println("init:"+configurableEnvironment);
        //bind(configurableEnvironment);
        //System.out.println(num);
    }
    
    @Override
    public void started(ConfigurableApplicationContext context) {
        configurableEnvironment = context.getEnvironment();
        System.out.println("started:"+configurableEnvironment);
    }
    
    void bind(Environment environment) {
        Binder.get(environment).bind("db", Bindable.ofInstance(this));
    }
}
