package com.lyf;

import com.aliyun.eventbridge.EventBridge;
import com.aliyun.eventbridge.EventBridgeClient;
import com.aliyun.eventbridge.models.CloudEvent;
import com.aliyun.eventbridge.models.Config;
import com.aliyun.eventbridge.models.GetEventBusRequest;
import com.aliyun.eventbridge.models.GetEventBusResponse;
import com.aliyun.eventbridge.models.PutEventsResponse;
import com.aliyun.eventbridge.util.EventBuilder;
import com.aliyun.tea.TeaUnretryableException;
import com.aliyun.teautil.models.RuntimeOptions;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * @author liyunfei
 */
public class PutEventsSample {
    
    static private EventBridge eventBridgeClient;
    
    static {
        Config authConfig = new Config();
        authConfig.accessKeyId = "LTAI5t9pwBXagE9vWP4ZRs1i";
        authConfig.accessKeySecret = "OGWpp3FpvsgRUNicLeXI1tODmn0ajN";
        authConfig.endpoint = "1017438417648207.eventbridge.cn-hangzhou.aliyuncs.com";
        eventBridgeClient = new EventBridgeClient(authConfig);
    }
    
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
        List<CloudEvent> cloudEventList = new ArrayList<>();
        
        cloudEventList.add(EventBuilder.builder()
                .withId("a5074581-7e74-4e4c-868f-47e7" + UUID.randomUUID().toString().substring(0, 6))
                .withSource(URI.create("mcrioservice.event")).withType("oss:ObjectCreated:PostObject").withSubject(
                        "acs:eventbridge:cn-hangzhou:1017438417648207:eventbus/demo-bus/rule/service-client-push-rule")
                .withTime(new Date()).withJsonStringData("{ \"name\": \"hello\"}").withAliyunEventBus("demo-bus")
                .build());
        System.out.println(cloudEventList.get(0).getId());
      
        try {
            Map<String, Object> map = new HashMap();
            //map.put("autoretry", true);
            //RuntimeOptions runtime = RuntimeOptions.build(map);
           // PutEventsResponse putEventsResponse = eventBridgeClient.putEventsWithOptions(cloudEventList, runtime);
            eventBridgeClient.putEvents(cloudEventList);
            //System.out.println(new Gson().toJson(putEventsResponse));
            //System.out.println(putEventsResponse.failedEntryCount);
        } catch (TeaUnretryableException e) {
            e.printStackTrace();
            System.out.println(e.getLastRequest());
            //System.out.println(e.getMessage()+"::"+e.getCause()+"::");
        }
        
        
    }
}
