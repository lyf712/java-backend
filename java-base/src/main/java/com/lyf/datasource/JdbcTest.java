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

package com.lyf.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author liyunfei
 **/
public class JdbcTest {
    protected static String dbClassName = "com.mysql.cj.jdbc.Driver";//数据库连接驱动包
    protected static String dbUrl = "jdbc:mysql://localhost:3306/db_library_swing?useUnicode=true&characterEncoding=UTF-8";
    protected static String dbUser = "root";//数据库用户名
    protected static String dbPwd = "123321";//数据库登录密码

    protected static String second = null;
    private static Connection conn = null;

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Class.forName(dbClassName);//.newInstance();
        conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);

    }
}
