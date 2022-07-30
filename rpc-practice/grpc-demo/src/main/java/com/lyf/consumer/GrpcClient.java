package com.lyf.consumer;

import com.lyf.api.HelloServiceGrpc;
import com.lyf.api.Request;
import com.lyf.api.Response;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liyunfei
 */
public class GrpcClient {
    
    public static void main(String[] args) {
        //构建链接信息(并没有真正连接)
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",1010)
                .usePlaintext().build();
        try {
        
            List<String> testArray = Arrays.asList(new String[]{"item0","item1","item2","item3",});
            Map<String,String> testMap = new HashMap<String, String>(){
                {
                    put("testA","A");
                    put("testB","B");
                }
            };
            //为了测试 any 不是真正的返回结构体
            Response testAny = Response.newBuilder().setRes("for any").build();
        
            //构建请求信息
            Request request = Request.newBuilder()
                    .setStr1("hello")
                    .build();
        
            //真正创建连接
            HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
            //传入请求 接收返回
            Response demoResponse = stub.hello(request);
            System.out.println("res code is : " + demoResponse.getRes() + ", message is : " + demoResponse.getRes());
        }finally {
            channel.shutdown();
        }

    }
}
