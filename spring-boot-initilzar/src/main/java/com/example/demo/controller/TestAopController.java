package com.example.demo.controller;

import com.example.demo.service.TestAspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyunfei
 */
@RestController
public class TestAopController {
    
    @Autowired
    TestAspectService testAspectService;
    
    private static final String EX_MOCK1 = "mockAlgEx";
    
    private static final String EX_MOCK2 = "mockThrowEx";
    
    @GetMapping("/test")
    public String test() {
        testAspectService.testMethod2("ok");
        return "ok";
    }
    
    @GetMapping(value = "/testAop")
    public Object testAop(@RequestParam String arg1, @RequestParam Integer arg2) {
        System.out.println("enter controller >>> arg1:" + arg1 + ";arg2:" + arg2);
        
        if (EX_MOCK1.equals(arg1)) {
            int i = 1 / 0;
        } else if (EX_MOCK2.equals(arg1)) {
            try {
                throw new Exception("mock throw exception ok");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return "request ok!!";
    }
    
    
}
