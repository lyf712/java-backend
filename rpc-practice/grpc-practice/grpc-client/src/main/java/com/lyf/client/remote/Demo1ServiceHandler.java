package com.lyf.client.remote;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.lyf.api.DemoService1Grpc;
import com.lyf.api.Request;
import com.lyf.api.Response;

import java.nio.charset.StandardCharsets;

/**
 * @author liyunfei
 */
public class Demo1ServiceHandler {
    public Response testCall() throws InvalidProtocolBufferException {
//        Request request = Request.newBuilder()
//                .setReq(Any.parseFrom("hello".getBytes(StandardCharsets.UTF_8))).build();
//
        Request request = Request.newBuilder().build();
        return GrpcClient.demo1Service(request);
    }
}
