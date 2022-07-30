package com.lyf.client.controller;

import com.google.protobuf.InvalidProtocolBufferException;
import com.lyf.client.remote.Demo1ServiceHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyunfei
 */
@RestController
public class TestController {
    Demo1ServiceHandler demo1ServiceHandler = new Demo1ServiceHandler();
    @GetMapping("/test")
    String test() throws InvalidProtocolBufferException {
        return demo1ServiceHandler.testCall().toString();
    }
}
