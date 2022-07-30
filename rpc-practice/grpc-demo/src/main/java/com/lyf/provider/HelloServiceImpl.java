package com.lyf.provider;

import com.lyf.api.HelloServiceGrpc;
import com.lyf.api.Request;
import com.lyf.api.Response;
import io.grpc.stub.StreamObserver;

/**
 * @author liyunfei
 */
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    
    @Override
    public void hello(Request request, StreamObserver<Response> responseObserver) {
        System.out.println("provider receive msg::");
        System.out.println(request.getStr1());
        
        Response.Builder builder = Response.newBuilder();
        builder.setRes("ok");
        
        responseObserver.onNext(builder.build());
        
        responseObserver.onCompleted();
        
        //super.hello(request, responseObserver);
    }
}
