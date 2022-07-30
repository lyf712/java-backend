package com.lyf.client.remote;

import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.lyf.api.DemoService1Grpc;
import com.lyf.api.Request;
import com.lyf.api.Response;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liyunfei
 */
public class GrpcClient {
    
    static ManagedChannel channel = ManagedChannelBuilder
            .forAddress("localhost",7080)
            .usePlaintext().build();
    static DemoService1Grpc.DemoService1BlockingStub demoService1BlockingStub = DemoService1Grpc.newBlockingStub(channel);
    
    public static Response demo1Service(Request request){
        Response response = demoService1BlockingStub.test1(request);
        System.out.println(response);
        return response;
    }
    
}
