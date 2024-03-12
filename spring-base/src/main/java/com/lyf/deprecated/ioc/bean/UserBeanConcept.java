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

package com.lyf.deprecated.ioc.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import javax.annotation.PostConstruct;

/**
 * @author liyunfei
 **/
@Slf4j
@Component
public class UserBeanConcept implements InitializingBean {
    // ------------base concept-------
    /*
    1.bean的生命周期（重要）
    （1）无参构造、构造推断（可能存在多个构造方法；形成普通对象
    （2）依赖注入，将相关的属性注入该对象
    （3）初始化前（
    （4）初始化 -- 结合Java对象本身的初始化五步骤：加载->分配内存空间(结合JVM的内存布局、对象的内存布局)->初始化值为0->设置对象头-><init>
    （5）初始化后（AOP操作、生成代理对象
    （6）
    2.关键点理解
    （1）循环依赖，两个bean形成锁，相关注入
    （2）单例bean的理解-- IOC容器底层 Map<key,value> 通过先byType后byName
    （3）
     */

    // 依赖注入
    //@Autowired
    //@Autowired(required = false)若未有该-可属性为空
    @Autowired
    User user;// spring自动帮忙调用 new user()

//    public UserService() {
//    }
//
//    @Autowired
//    public UserService(User user) { // 先ByType，后ByName
//        this.user = user;
//    }

    //@PostConstruct
    public void initBefore(){
        //System.out.println("op before u");
       // log.info("op before {} init",this.getClass().getName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //log.info("op after {} init",this.getClass().getName());
    }

    public void test(){
        //log.info("test method");
    }
}
