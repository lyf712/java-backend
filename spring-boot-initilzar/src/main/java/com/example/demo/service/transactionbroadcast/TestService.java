package com.example.demo.service.transactionbroadcast;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 */
@Service
public class TestService {
    
    static public void test() {
        System.out.println("service::test!!");
    }
    
    public void test2() {
        System.out.println("service::test!!");
    }
    
//    @PostConstruct
//    void init(){
//                new Thread(()->{
//                    while (true){
//                        TestService.test();
//                        try {
//                            TimeUnit.SECONDS.sleep(1);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }).start();
//    }
}
