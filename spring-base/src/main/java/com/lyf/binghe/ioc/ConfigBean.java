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

package com.lyf.binghe.ioc;

import com.alibaba.druid.DbType;
import com.alibaba.druid.pool.DruidDataSource;
import com.lyf.binghe.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author liyunfei
 **/
@Configuration(proxyBeanMethods = false,value = "lyfConfig",enforceUniqueMethods = true)
// 关于proxyBeanMethod的使用
// 由于是动态代理，会带来开销。
// 对于纯粹、静态的配置类，则无需打开，提升性能
// 对于依赖与容器其他Bean、或AOP代理 则需要打开
public class ConfigBean {

    private String configName;

    @Bean
    public Person person(){return new Person();}

    @Bean
    public DataSource dataSource(){
        // 这种写死静态的---，则可关闭调-
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("");
        druidDataSource.setDbType(DbType.mysql);

        return druidDataSource;
    }
}
