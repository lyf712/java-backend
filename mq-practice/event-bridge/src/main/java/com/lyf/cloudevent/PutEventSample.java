package com.lyf.cloudevent;

import io.cloudevents.CloudEvent;
import io.cloudevents.core.builder.CloudEventBuilder;
import io.cloudevents.http.vertx.VertxMessageFactory;
import io.cloudevents.jackson.JsonFormat;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientRequest;

import java.net.URI;
import java.util.UUID;

/**
 * @author liyunfei
 */
public class PutEventSample {
    
    private static String accessKeyId = "LTAI5t9pwBXagE9vWP4ZRs1i";
    
    private static String accessKeySecret = "OGWpp3FpvsgRUNicLeXI1tODmn0ajN";
    
    private static String endpoint = "localhost:8080";//"1017438417648207.eventbridge.cn-hangzhou.aliyuncs.com";// http://endpoint/openapi/putEvents
    
    private static String protocol = "http://";
    
    private static String putEventSuffix = "/webhook/send";//"/openapi/putEvents";
    
    public static void main(String[] args) throws Exception {
        
        endpoint = protocol + endpoint + putEventSuffix;
        
        final Vertx vertx = Vertx.vertx();
        final HttpClient httpClient = vertx.createHttpClient();
        
        // 创建一个事件模板来设置基本的CloudEvent属性。
        CloudEventBuilder eventTemplate = CloudEventBuilder.v1()
                .withSource(URI.create("https://github.com/cloudevents/sdk-java/tree/master/examples/vertx"))
                .withType("vertx.example");
        
        // 创建HTTP请求。
        final HttpClientRequest request = httpClient
                .postAbs(endpoint)
                .handler(response -> {
                    
                    System.out.println(response.statusMessage()+"::"+response.statusCode());
            
        }).exceptionHandler(System.err::println);
        
        String id = UUID.randomUUID().toString();//UUID.randomUUID().toString();
        String data = "{\"name\":\"Eventbridge\",\"number\":100}";
        
        // 从模板中创建事件。
        final CloudEvent event = eventTemplate.newBuilder()
                .withId(id)
                .withData("application/json", data.getBytes())
                .withExtension("aliyuneventbusname", "demo-bus")
                .withSource(URI.create("https://github.com/cloudevents/sdk-java/tree/master/examples/vertx"))
                .withType("vertx.example")
                //.withSubject("acs:oss:cn-hangzhou:1234567:xls-papk/game_apk/123.jpg")
                .build();
        
        request.putHeader("content-type", "application/cloudevents+json");
        request.putHeader("authorization", "acs" + ":" + accessKeyId + ":" + SignatureHelper
                .getSignature(SignatureHelper.getStringToSign(request), accessKeySecret) + "");
        
        VertxMessageFactory.createWriter(request).writeStructured(event, new JsonFormat());
    }
    
}
