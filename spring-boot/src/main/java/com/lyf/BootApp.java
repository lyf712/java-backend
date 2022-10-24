package com.lyf;

import com.lyf.ws.WebSocketController;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author liyunfei
 */
@SpringBootApplication
public class BootApp {
    
    public static void main(String[] args) {

        ConfigurableApplicationContext application = SpringApplication.run(BootApp.class,args);
        WebSocketController.setApplicationContext(application);
    }
}
