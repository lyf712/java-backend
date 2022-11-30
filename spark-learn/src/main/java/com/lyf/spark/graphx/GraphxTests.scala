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

package com.lyf.spark.graphx
import javafx.scene.input.DataFormat
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD
import org.apache.spark.graphx._
import org.apache.spark.sql.{DataFrame, SparkSession}
/**
 * GitHub用户关系图构建
 * （1）爬取至MySQL表示
 * （2）scala,graphx API构建
 * （3）大屏 关系散点图表示
 *
 * @authorliyunfei
 * @date2022/11/28
 * */
object GraphxTests {
       //
       final val username:String = ""
       final val password:String = ""
       // optional
       var sc: SparkContext = null
       // scala spark操作 sql:https://blog.csdn.net/Aeve_imp/article/details/125846963
       def readMysql(spark: SparkSession, url: String, sql: String): DataFrame={
         spark.read.format("jdbc")
           .option("driver", "com.mysql.cj.jdbc.Driver")
           .option("user", username)
           .option("password", password)
           .option("url", url)
           .option("dbtable", s"($sql) dbtable").load()
       }

       def initSpark(): Unit ={
         // 配置Spark基础上下文
           val conf = new SparkConf()
           conf.setAppName("graphx")
           conf.setMaster("local")
           sc = new SparkContext(conf)
           sc.setLogLevel("WARN")
       }

       def getGraph():Graph[(String,Int),Int]={
         /*
        属性图
        1.定义 顶点和边
        2.构造图（spark的内部API）
        3.调用相关的API，计算边，pagerank
         */
         // 顶点数据
         val vertexArr = Array(
           // ID, attribute
           (1L, ("Alice", 28)),
           (2L, ("Bob", 27)),
           (3L, ("Charlie", 65)),
           (4L, ("David", 45)),
           (5L, ("Ed", 55)),
           (6L, ("Fran", 50))
         )
         val edgeArr = Array(
           // start，end，weight/Desc-描述关系
           Edge(2L, 1L, 7),
           Edge(2L, 4L, 2),
           Edge(3L, 2L, 4),
           Edge(3L, 6L, 3),
           Edge(4L, 1L, 1),
           Edge(5L, 2L, 2),
           Edge(5L, 3L, 8),
           Edge(5L, 6L, 3)
         )
         // 构造RDD--
         val vertexRDD: RDD[(Long, (String, Int))] = sc.parallelize(vertexArr)
         val edgeRDD: RDD[Edge[Int]] = sc.parallelize(edgeArr)
         // Graph [(attr1,attr2),desc]
         val graph: Graph[(String, Int), Int] = Graph(vertexRDD, edgeRDD)
         graph
       }

       def testReadMySQL(): Unit ={
         //            val spark = SparkSession.builder().appName("").master("").getOrCreate();
         //            readMysql(spark = spark,url="jdbc:mysql://*:3306/cclab",sql="select * from top_res limit 100").show()
       }
  def main(args:Array[String]): Unit ={
            initSpark()
            val graph: Graph[(String,Int),Int] = getGraph()

            // 基本操作（对edge,vertex,triple
            println("寻找边属性大于5的边")
            graph.edges.filter(e=>e.attr>5)
              .collect.foreach(e=>println(s"${e.srcId} to ${e.dstId} attr ${e.attr}"))
            //filter过滤，map-reduce映射规约，collect 收集 对比Java Stream，学习
             // count计数，
            graph.vertices.filter(e=>e._2._2>10)
              .collect().foreach(e=>println(e._1))

            //
            //graph.triplets.foreach()

            graph.triplets.map(e=>e.attr+":"+e.dstId+":"+e.srcId)
              .collect.foreach(println(_))

            //graph.subgraph()

             // 聚合函数--计数周边关系，例如用户的追随者平均年龄
            //graph.aggregateMessages()

             //pageRank
             //PR 值，weight起作用？
             graph.pageRank(0.001).vertices.foreach(println(_))
             graph.pageRank(0.1).edges.foreach(println(_))
       }
}
