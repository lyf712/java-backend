package com.lyf.network;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 */
public class CallbackTests {
    void requestCall(String info,Event event,CallBack<Event> callBack,long time){
        // 模拟通信
        long cur = System.currentTimeMillis();
        long mockCommunicateTs = 1000 + new Random().nextLong();
        while (System.currentTimeMillis()-cur<mockCommunicateTs){
            // 通信中，且在允许超时范围内
            if(System.currentTimeMillis()-cur >= time){
                event.setMsg("超时");
                callBack.onError(event);
                return;
            }
        }
        // 返回的结果处理
        callBack.onSuccess(event);
    }
    
    @Test
    public void testCall(){
        requestCall("requestOk1", new Event(), new CallBack<Event>() {
            @Override
            public void onSuccess(Event event) {
                System.out.println("success");
            }
    
            @Override
            public void onError(Event event) {
                System.out.println("failed");
            }
        },1L);
    }
}
