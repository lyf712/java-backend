package com.lyf;

import com.aliyun.eventbridge.EventBridge;
import com.aliyun.eventbridge.EventBridgeClient;
import com.aliyun.eventbridge.models.CloudEvent;
import com.aliyun.eventbridge.models.Config;
import com.aliyun.eventbridge.models.GetEventBusRequest;
import com.aliyun.eventbridge.models.GetEventBusResponse;
import com.aliyun.eventbridge.models.PutEventsResponse;
import com.aliyun.eventbridge.util.EventBuilder;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author liyunfei
 */
public class PutEventsSample {
    
    static private EventBridge eventBridgeClient;
    
    public PutEventsSample() {
        Config authConfig = new Config();
        authConfig.accessKeyId = "{accessKeyId}";
        authConfig.accessKeySecret = "{accessKeySecret}";
        authConfig.endpoint = "{endpoint}";
        eventBridgeClient = new EventBridgeClient(authConfig);
    }
    
    public static void main(String[] args) {
//        EventBridgeClient client =
//                new EventBridgeClient("","","");
//        //EventBus bus = new AsyncEventBus();
//        EventBuilder.builder().withData("").build();
//        client.putEvents(new DefaultPutEventsRequest());
    
    
//        Config config = new Config();
//        config.setAccessKeyId("your accessKeyId")
//                .setAccessKeySecret("your accessKeySecret")
//                .setEndpoint("your endpoint");
//        EventBridgeClient client = new EventBridgeClient(config);
//
//
//        GetEventBusRequest describeEventBusRequest = new GetEventBusRequest();
//        describeEventBusRequest.eventBusName = "demo-bus";
//
//        GetEventBusResponse deScribeResponse = client.getEventBus(describeEventBusRequest);
    
        List<CloudEvent> cloudEventList = new ArrayList<>();
        cloudEventList.add(EventBuilder.builder()
                .withId("a5074581-7e74-4e4c-868f-47e7afdf****")
                //.withSource(URI.create("acs.oss"))
                .withType("oss:ObjectCreated:PostObject")
                .withSubject("acs:oss:cn-hangzhou:{yourAccountId}:xls-papk/game_apk/123.jpg")
                .withTime(new Date())
                .withJsonStringData("{ \"E-Mail\": \"${email}\" }")
                .withAliyunEventBus("demo-bus")
                .build());
        PutEventsResponse putEventsResponse = eventBridgeClient.putEvents(cloudEventList);
        System.out.println(new Gson().toJson(putEventsResponse));
        
    }
}
