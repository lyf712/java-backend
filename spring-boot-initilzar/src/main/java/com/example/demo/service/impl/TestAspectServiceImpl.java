package com.example.demo.service.impl;

import com.example.demo.service.TestAspectService;
import org.springframework.stereotype.Service;

/**
 * @author liyunfei
 */
@Service
public class TestAspectServiceImpl implements TestAspectService {
    
    @Override
    public void testMethod0() {
        System.out.println("enter testMethod0");
    }
    
    @Override
    public String testMethod1() {
        System.out.println("enter testMethod1");
        return "ok method1";
    }
    
    @Override
    public String testMethod2(String arg1) {
        System.out.println("enter testMethod2::" + arg1);
        return "success:" + arg1;
    }
    
    @Override
    public String testMethod3(String arg1, String arg2) {
        System.out.println("enter testMethod3::" + arg1 + " : " + arg2);
        return "success: " + arg1 + arg2;
    }
}
