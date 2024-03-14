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

package com.lyf.deprecated.ioc;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
// spring5
///import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author liyunfei
 */
public class BeanTests {
    @Test
    public void testBeanRegister(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        ApplicationContext applicationContext1 = new AnnotationConfigApplicationContext();
        ApplicationContext applicationContext2 = new FileSystemXmlApplicationContext();
        BeanFactory beanFactory = new ClassPathXmlApplicationContext();
        //applicationContext1.getBean(UserService.class);
        applicationContext1.getBean("userService");
    }
    
    @Test
    public void testIocBean(){
        //BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("BeanFactory.xml"));
        //estBean testBean = beanFactory.getBean(TestBean.class);
        
    }
    
    
}
