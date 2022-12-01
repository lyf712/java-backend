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

package com.lyf.spark.graphx.github
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
 * @authorliyunfei
 * @date2022/11/30
 * */
class DbUtil {
    val username:String = "practice"
    val password:String = "123456"
    def readMysql(spark: SparkSession, url: String, sql: String): DataFrame = {
       spark.read.format("jdbc")
         .option("driver", "com.mysql.cj.jdbc.Driver")
         .option("user", username)
         .option("password", password)
         .option("url", url)
         .option("dbtable", s"($sql) dbtable").load()
    }

}
