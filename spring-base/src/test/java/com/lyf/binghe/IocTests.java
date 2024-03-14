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

package com.lyf.binghe;

import com.lyf.binghe.ioc.ConfigBean;
import org.junit.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liyunfei
 **/
public class IocTests {

    private final ApplicationContext annotationScanCtx = new AnnotationConfigApplicationContext("com.lyf.binghe.ioc");


    @Test
    public void testContainer(){
        /**
         * 构造：
         * // 可省略注解
         *     public AnnotationConfigApplicationContext(Class<?>... componentClasses) {
         *         this();
         *         this.register(componentClasses);
         *         this.refresh();
         *     }
         *
         *     public AnnotationConfigApplicationContext(String... basePackages) {
         *         this();
         *         this.scan(basePackages);
         *         this.refresh();
         *     }
         */
        ApplicationContext annotationCtx = new AnnotationConfigApplicationContext();
        ApplicationContext xmlCtxt = new ClassPathXmlApplicationContext();
        //xmlCtxt.getBeanProvider()
        //ObjectProvider<Object> object = annotationCtx.getBeanProvider()
    }

    /**
     * 注册 -- 实例化两个过程
     * Application（scan,reader)  ->  processor -> Util ->DefaultListableBeanFactory
     */
    @Test
    public void testConfiguration(){
        ConfigBean bean = annotationScanCtx.getBean(ConfigBean.class);
        // 什么是不需要代理，非单例
        System.out.println(bean==annotationScanCtx.getBean(ConfigBean.class));
        System.out.println(bean.person()==bean.person());

    }


}
