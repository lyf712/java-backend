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

import org.apache.catalina.startup.Tomcat;
import org.eclipse.jetty.util.Jetty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liyunfei
 **/
@Configuration
public class WebServerAutoConfig {
    @Bean
    @ConditionalOnClass("org.apache.catalina.startup.Tomcat")
    WebServer tomcatServer(){
        //Tomcat
        return new TomcatServer();
    }
    @Bean
    @ConditionalOnClass("org.eclipse.jetty.util.Jetty")
    WebServer jettyServer(){
        //Jetty
        return new JettyServer();
    }
}
