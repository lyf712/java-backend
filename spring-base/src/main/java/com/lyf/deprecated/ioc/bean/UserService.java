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

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * bean的构造过程：
 * 无参构造、普通对象 -> 依赖注入- 初始化前 -> 初始化 -> 初始化后（AOP） 代理对象 ->
 *
 * @author liyunfei
 **/
@Component
public class UserService implements InitializingBean {
    @Autowired
    User user;

    // 1.多个构造函数的情况考虑（构造判断选择）
    // 2.循环依赖的问题考虑
    // 3.单例bean的理解（bean对象的注入方式 @bean,@compoent）

    //@PostConstruct
    void beforeInit(){

    }

    // 初始化对象
    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
