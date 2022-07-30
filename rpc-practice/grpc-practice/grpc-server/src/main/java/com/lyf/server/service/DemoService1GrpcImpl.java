package com.lyf.server.service;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.lyf.api.DemoService1Grpc;
import com.lyf.api.Request;
import com.lyf.api.Response;
import io.grpc.stub.StreamObserver;

import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * @author liyunfei
 */
public class DemoService1GrpcImpl extends DemoService1Grpc.DemoService1ImplBase {
    
    @Override
    public void test1(Request request, StreamObserver<Response> responseObserver) {
        try {
            System.out.println("server  receive:::" + request.getReq());
            System.out.println("DemoService1GrpcImpl test1 handle---");
            Response.Builder builder = Response.newBuilder();
            builder.setCode(200).setMsg("ok").setBody(Any.newBuilder().
                    setValue(ByteString.copyFrom("hello".getBytes(StandardCharsets.UTF_8))).build()).build();
            responseObserver.onNext(builder.build());
        } catch (Exception e) {
            responseObserver.onError(e);
        }finally {
            responseObserver.onCompleted();
        }
    }
    
    @Override
    public void test2(Request request, StreamObserver<Response> responseObserver) {
        try {
            System.out.println("server  receive:::" + request.getReq());
            System.out.println("DemoService1GrpcImpl test2 handle---");
            Response.Builder builder = Response.newBuilder();
            builder.setCode(200).setMsg("ok!").setBody(Any.newBuilder().
                    setValue(ByteString.copyFrom("hello!".getBytes(StandardCharsets.UTF_8))).build()).build();
            responseObserver.onNext(builder.build());
        } catch (Exception e) {
            responseObserver.onError(e);
        }finally {
            responseObserver.onCompleted();
        }
    }
}
