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

package org.example.springboot;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.core.StandardServer;
import org.apache.catalina.servlets.WebdavServlet;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liyunfei
 **/
public class MySpringApplication {
    public static void run(Class clazz,String ...args){
         AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
         context.register(clazz);
         context.refresh();
         //startTomcat(context);
         startServer(context);
    }

    private static void startServer(AnnotationConfigWebApplicationContext context){
        Map<String, WebServer> serverMap = context.getBeansOfType(WebServer.class);
        Collection<WebServer> servers = serverMap.values();
        if(servers.isEmpty()){
            throw new NullPointerException("");
        }
        if(servers.size()>1){
            throw new IllegalArgumentException("引入依赖错误，只允许引入一个web容器");
        }
        servers.stream().toList().get(0).start();
        //return servers.stream().toList().get(0);
    }

    // 启动内嵌Tomcat
    private static void startTomcat(WebApplicationContext context0){
        Tomcat tomcat = new Tomcat();
        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");

        Connector connector = new Connector();
        connector.setPort(8080);

        Engine engine = new StandardEngine();
        engine.setDefaultHost("localhost");

        Host host = new StandardHost();
        host.setName("localhost");

        String contextPath = "";
        Context context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());

        host.addChild(context);
        engine.addChild(host);

        service.setContainer(engine);
        service.addConnector(connector);

        tomcat.addServlet(contextPath,"dispatcher",new DispatcherServlet(context0));
        context.addServletMappingDecoded("/*","dispatcher");


        try {
            tomcat.start();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
    }
}
