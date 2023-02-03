/*
 *    Copyright 1999-2022  lyf712
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.lyf.iocaop;

import com.lyf.iocaop.bean.ScannerConfig;
import com.lyf.iocaop.bean.User;
import com.lyf.iocaop.bean.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;

/**
 * 测试IOC.
 * @author liyunfei
 **/
//@ComponentScan(value = "com.lyf.iocaop")
public class IocStarterTest {
    private static final ApplicationContext context = new AnnotationConfigApplicationContext(ScannerConfig.class);
//    public static void main(String[] args) {
//        //new HashMap<>()
//        //ApplicationContext context = new AnnotationConfigApplicationContext(ScannerConfig.class);
//        //UserService userService = context.getBean(UserService.class);
//        //context.getBean(User.class);
//        //((UserService)context.getBean("userService1")).test();
//    }
    //@Test
    @Test
    public void testDI(){
        UserService userService = (UserService) context.getBean("userService");
        userService.test();
    }
}
