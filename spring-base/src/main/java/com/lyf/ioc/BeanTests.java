package com.lyf.ioc;

import com.lyf.ioc.bean.UserService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
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
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("BeanFactory.xml"));
        TestBean testBean = beanFactory.getBean(TestBean.class);
        
    }
    
    
}
