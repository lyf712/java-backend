package com.lyf;

import com.aliyun.eventbridge.client.EventBridgeClient;
import com.aliyun.eventbridge.core.event.EventBuilder;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.net.URI;

/**
 * @author liyunfei
 */
public class EbTest {
    
    public static void main(String[] args) {
        EventBridgeClient client =
                new EventBridgeClient("","","");
        //EventBus bus = new AsyncEventBus();
        EventBuilder.builder().withData("").build();
        
    }
}
