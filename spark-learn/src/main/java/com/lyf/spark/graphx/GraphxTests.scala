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
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

import javax.swing.JFrame
import scala.collection.mutable.ArrayBuffer

/**
 * GitHub用户关系图构建
 * （1）爬取至MySQL表示
 * （2）scala,graphx API构建
 * （3）大屏 关系散点图表示
 * ---------------------------
 * 1.Github图构造
 * （1）用户-用户图
 * （2）用户-仓库图
 * 2.数据来源
 * （1）server程序进行爬取数据并存入 MySQL
 * （2）Spark端 从MySQL读取数据 [也可考虑stream流-kafka推？]
 * （3）Spark构建图--处理【1.分类，2.推荐 3.】
 * （4）将结果推至（HTTP，Rest，Post）给 后端应用 OR 直接 前端 WS？
 *
 * @authorliyunfei
 * @date2022/11/28
 * */
object GraphxTests {
  //
  final val username: String = "practice"
  final val password: String = "123456"
  //--??? DbUtil??
  // optional
  var sc: SparkContext = null

  // scala spark操作 sql:https://blog.csdn.net/Aeve_imp/article/details/125846963
  def readMysql(spark: SparkSession, url: String, sql: String): DataFrame = {
    spark.read.format("jdbc")
      .option("driver", "com.mysql.cj.jdbc.Driver")
      .option("user", username)
      .option("password", password)
      .option("url", url)
      .option("dbtable", s"($sql) dbtable").load()
  }

  def initSpark(): Unit = {
    // 配置Spark基础上下文
    val conf = new SparkConf()
    conf.setAppName("graphx")
    conf.setMaster("local")
    sc = new SparkContext(conf)
    sc.setLogLevel("WARN")
  }

  // (user_name,follow_num) , desc(follow,own)
  def createUserGraph(spark: SparkSession): Graph[(String, Int), String] = {
//    // 顶点数据
//    var vertexArr = Array(
//      // ID, attribute
//                 (1L, ("Alice", 28)),
//                 (2L, ("Bob", 27)),
//                 (3L, ("Charlie", 65)),
//                 (4L, ("David", 45)),
//                 (5L, ("Ed", 55)),
//                 (6L, ("Fran", 50))
//    )
//
//    var edgeArr = Array(
//      // start，end，weight/Desc-描述关系
//                 Edge(2L, 1L, "own"),
//                 Edge(2L, 4L, "own"),
//                 Edge(3L, 2L, "own"),
//                 Edge(3L, 6L, "own"),
//                 Edge(4L, 1L, "own"),
//                 Edge(5L, 2L, "own"),
//                 Edge(5L, 3L, "own"),
//                 Edge(5L, 6L, "own")
//    )
    val vertexArrBuf = new ArrayBuffer[(Long,(String,Int))]()
    // vertexArr.apply((1,("",2))
    val tmpArr = readMysql(spark = spark, url = "jdbc:mysql://47.98.99.88:3306/cclab", sql = "select * from user ORDER BY user_id limit 80")
      //.columns.foreach(e=>{println(e)})
      .collect()
    //  .map(e => e.getString(3).split(","))
    println("read data:")
    tmpArr.foreach(e=>{
      println(s"${e.getInt(1)},${e.getString(2)}")
    })

//    vertexArr = tmpArr
//      // 为什么会有很大user_id的数据读进去？
//      // (120860,null)
//      //(6128,null) 映射产生一下奇怪的数据进去？？FIXME
//      .filter(row=>row.getInt(1)<100)
//      .map(e => (e.getInt(1).toLong, (e.getString(2), 1)))
//      .clone()

    // 边处理
    val tmpEdgeArr = new ArrayBuffer[Edge[String]]()
    val vertexArr = new ArrayBuffer[(Long,(String,Int))]()
    val iterator: Iterator[Row] =tmpArr.iterator
    while (iterator.hasNext){
               val row:Row = iterator.next()
               val userId = row.getInt(1).toLong
               val userName = row.getString(2)
               vertexArr+= ((userId,(userName,1)))
               val followIds = row.getString(3).split("\\,")
               val iterator2:Iterator[String] = followIds.iterator
               //println(s"${userId},${followIds}")
               while (iterator2.hasNext) {
                 val idStr:String = iterator2.next()
                 if(!idStr.isEmpty)
                      tmpEdgeArr+= (Edge(userId,idStr.toLong,"follow"))//Edge
               }
    }
//    println("print edgeArr")
//    tmpEdgeArr.foreach(e=>{println(e)})
      println("print vertexArr")
      vertexArr.foreach(e=>{println(e)})
//    tmpArr.foreach(row=>{
//         val userId = row.getInt(1).toLong
//         val userName = row.getString(2)
//         val followIds = row.getString(3).split("\\,")
//         followIds.map(e=>{(userId,e.toLong,"follow")})
//    })

//    edgeArr = tmpArr.map(row=>{
//               val userId = row.getInt(1).toLong
//               val userName = row.getString(2)
//               val followIds = row.getString(3).split("\\,")
//
//               followIds.map(e=>{(userId,e.toLong,"follow")})
//
//    }).clone()


    //.show()
//      .foreach(row => {
//           println(s"${row.get(0)},${row.getInt(1)},${row.getString(2)}")
//              //vertexArr.apply(row.getInt(1),(row.getString(2),1))
//              //vertexArr+= (row.getInt(1),(row.getString(2),1))
////            val a = (row.getInt(1).toLong,(row.getString(2),1))
////        //FIXME 加不进去？？ //解决：https://cloud.tencent.com/developer/ask/sof/1115340
////            println("a::")
////            println(a)
//
//            vertexArrBuf += ((row.getInt(1).toLong,(row.getString(2),1)))
//      })



//    vertexArrBuf += ((3L,("test",1)))
//
//    println("buffer：")
//
//    vertexArrBuf.foreach(e=>{println(e)})

    // 构造RDD--
    val vertexRDD: RDD[(Long, (String, Int))] = sc.parallelize(vertexArr.toArray.seq) //
    val edgeRDD: RDD[Edge[String]] = sc.parallelize(tmpEdgeArr.toArray.seq) //    edgeArr
    // Graph [(attr1,attr2),desc]
    val graph: Graph[(String, Int), String] = Graph(vertexRDD, edgeRDD)

//    graph.vertices.foreach(e=>{
//       println(s"${e._1},${e._2}")
//    })

    graph
  }

  def getGraph(): Graph[(String, Int), Int] = {
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

  def testReadMySQL(): Unit = {
    //            val spark = SparkSession.builder().appName("").master("").getOrCreate();
    //            readMysql(spark = spark,url="jdbc:mysql://*:3306/cclab",sql="select * from top_res limit 100").show()
  }

  def baseOp(): Unit = {
    val graph: Graph[(String, Int), Int] = getGraph()
    // 基本操作（对edge,vertex,triple
    println("寻找边属性大于5的边")
    graph.edges.filter(e => e.attr > 5)
      .collect.foreach(e => println(s"${e.srcId} to ${e.dstId} attr ${e.attr}"))
    //filter过滤，map-reduce映射规约，collect 收集 对比Java Stream，学习
    // count计数，
    graph.vertices.filter(e => e._2._2 > 10)
      .collect().foreach(e => println(e._1))

    //
    //graph.triplets.foreach()

    graph.triplets.map(e => e.attr + ":" + e.dstId + ":" + e.srcId)
      .collect.foreach(println(_))

    //graph.subgraph()

    // 聚合函数--计数周边关系，例如用户的追随者平均年龄
    //graph.aggregateMessages()

    //pageRank
    //PR 值，weight起作用？
    graph.pageRank(0.001).vertices.foreach(println(_))
    graph.pageRank(0.1).edges.foreach(println(_))


  }

  def main(args: Array[String]): Unit = {
    initSpark()
   // val graph: Graph[(String, Int), Int] = getGraph()
    val spark = SparkSession.builder().appName("test").master("local").getOrCreate();
    val graph: Graph[(String, Int), String] = createUserGraph(spark = spark)

    println("=====create graph=====")
    println("print vertices")
    //???====为什么多出来一些奇怪的边？？FIXME
    graph.vertices.foreach(e=>println(e))
    println("print edges")
    graph.edges.foreach(e=>println(e))



  }
}
