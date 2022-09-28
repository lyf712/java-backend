package com.lyf.httpweb.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * @author liyunfei
 */
public class ConfigLoader {
   
    private final String applicationLocation = SysConfig.APPLICATION_PATH;
    
    private final static HashMap<String,Object> configCache = new HashMap<>(4);
    
    private final static ConfigLoader configLoader = new ConfigLoader();
    
    // 读取配置信息
    private ResourceBundle bundle;
    
    private ConfigLoader(){
        // 加载配置信息
        load();
    }
    
    public static ConfigLoader getConfigLoader(){return configLoader;}
    
    private void load(){
        try {
            bundle = new PropertyResourceBundle(new FileInputStream(applicationLocation));
            Enumeration<String> keys = bundle.getKeys();
            Iterator<String> iterator = keys.asIterator();
            while (iterator.hasNext()){
                String key = iterator.next();
                configCache.put(key,bundle.getString(key));
            }
        } catch (IOException e) {
            Logger.getAnonymousLogger().info("");
            System.out.println("");
            e.printStackTrace();
        }
    }
    
    public Object getConfigInfo(String key){
        return configCache.getOrDefault(key,null);
    }
}
