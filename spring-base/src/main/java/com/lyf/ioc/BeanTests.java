package com.lyf.ioc;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

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
    }
    
}
