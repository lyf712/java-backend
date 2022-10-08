package com.lyf.network.netty.sequence.cases;

import com.google.gson.JsonObject;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import org.junit.Test;

/**
 * 结合Grpc进行分析（以及nacos的grpc通信框架）
 * 对比序列化流大小及序列化和反序列化的时间
 * @author liyunfei
 */
public class SerialTests {
    
    /**
     * 13
     * username: "alan"
     * param: "query"
     *
     * json serial len:44
     */
    @Test
    public void testSerial(){
        long cur0 = System.currentTimeMillis();
        RequestProto.Request.Builder
                builder = RequestProto.Request.newBuilder();
        RequestProto.Request request = builder.setUsername("alan")
               .setParam("query")
               .build();
        // Protobuf进行序列化的流大小
        byte[] bytes = request.toByteArray();
        System.out.println(bytes.length+":cost time--"+(System.currentTimeMillis()-cur0));
        // 采用JSON
        try {
            // Protobuf反序列化
            RequestProto.Request req = RequestProto.Request.parseFrom(bytes);
            System.out.println(req);
            cur0 = System.currentTimeMillis();
            // 将反序列化的结构采用JSON进行序列化
            String jsonObject = JsonFormat.printer().print(req);
            System.out.println("json serial len:"+jsonObject.getBytes().length+":cost "+(System.currentTimeMillis()-cur0));
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
}
