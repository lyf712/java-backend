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

package com.lyf.sample.dao.mysql;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 1.数据源、事务的理解以及ACID的概念
 *
 * 2.并发问题：（基本操作 SELECT，UPDATE，INSERT，DELETE）
 * （1）解释脏读  事务A·更新(更新字段、插入数据呢？？)·后，并回滚，在回滚之前，事务B读到了该次更新的数据【】
 * （2）解释不可重复读  事务A 在同一事务中查出 不一样的数据，，在该事务中 的两次查询之间 事务B去 ·更新·了该数据
 * （3）解释幻读  同（2）类似，只是原有基础上 进行插入或删除，改变了行数 【行级锁--的保证】
 *  结合隔离性、原子性、（一致性思考：目标
 *
 * 3.四大隔离级别
 *  （1）读未提交
 *  （2）读已提交 （语句执行完，则释放共享锁（读
 *  （3）可重复读 （事务执行完释放 共享锁）  MySQL InnoDB默认
 *  （4）串行化   （
 *
 * 4.基本手段
 * （1）锁机制（锁粒度，锁范围）
 * （2）并发调度（MVVC）
 *
 * @authorliyunfei
 * @date2022/11/26
 **/
public class JDBCUtil {
       private static DataSource datasource;

       // 连接池、数据源的管理,初始化信息，一次性
       static {
              datasource = new DruidDataSource();
       }
       // 管理连接，动态链接
       Connection getConnection() throws SQLException {
                Connection connection = datasource.getConnection();
                // 句柄执行，多个句柄
                Statement statement = connection.createStatement();
                statement.execute("");

                // connection会话层，提交，回滚
                // 一个connection相对于一个事务
                try {
                    connection.commit();
                }catch (Exception exception){
                    connection.rollback();
                }finally {
                    //ignore
                    connection.close();
                }


                return connection;
       }

}
