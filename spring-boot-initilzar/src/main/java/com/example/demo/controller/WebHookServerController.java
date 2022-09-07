package com.example.demo.controller;

import com.example.demo.service.transactionbroadcast.HelloService;
import com.example.demo.service.transactionbroadcast.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liyunfei
 */
@RestController
@RequestMapping("/webhook")
public class WebHookServerController {
    
    @Autowired
    TestService testService;
    
    @Autowired
    HelloService helloService;
    
    public WebHookServerController(TestService testService, HelloService helloService) {
        this.testService = testService;
        this.helloService = helloService;
    }
    
    @GetMapping("/send")
    String webhook(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request);
        //    testService.test();
        //((TestService) AopContext.currentProxy()).test();
        // TestService.test();
        //        testService.test2();
        //helloService.ok();
        //helloService.doPost();
        
        // ((HelloService)AopContext.currentProxy()).dispatcher("post");
        helloService.dispatcher("post");
        
        return "ok!";
    }
    
}
