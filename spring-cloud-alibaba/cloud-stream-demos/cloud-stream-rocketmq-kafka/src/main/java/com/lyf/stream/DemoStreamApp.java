package com.lyf.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author liyunfei
 */
@EnableDiscoveryClient
@EnableBinding({Source.class, Sink.class})
@SpringBootApplication
public class DemoStreamApp {
    
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(DemoStreamApp.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
    
    @Autowired
    Source source;
    @Bean
    public CommandLineRunner runner(){
        return (args -> {
           source.output().send(MessageBuilder.withPayload("custom payload")
                   .setHeader("k1","v1").build());
        });
    }

    @StreamListener(Sink.INPUT)
    @SendTo(Source.OUTPUT)
    public String receive(String msg){
        return msg.toLowerCase();
    }
}
