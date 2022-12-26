package com.lyf.scalabase.db

import java.sql.{DriverManager, PreparedStatement, ResultSet}

import org.apache.log4j.{Level, Logger}
import org.apache.spark.graphx.{Edge, Graph, VertexId, VertexRDD}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext, graphx}

import scala.collection.mutable
import scala.collection.mutable.Set
import scala.collection.mutable.ArrayBuffer

object MysqlProcess {

  def main(args: Array[String]): Unit = {

    val conf:SparkConf = new SparkConf().setAppName("gc").setMaster("local[*]")
    val sc:SparkContext = new SparkContext(conf)
    sc.setLogLevel("WARN")

    // 创建JDBCRDD,方法数据库
    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://47.98.99.88:3306/cclab?useUnicode=true&serverTimezone=Asia/Shanghai&characterEncoding=utf8&autoReconnect=true&useSSL=false&allowMultiQueries=true"
    val username = "practice"
    val passwd = "123456"
    //TODO 1.source 加载数据
    Class.forName(driver)
    // 从mysql读数据
    // 查询数据
    val sql = "select distinct r.user_id, user_name, repo_name from user_repo r left join user u on r.user_id = u.user_id where user_name is not null order by r.user_id;"
    val getconnection = () => DriverManager.getConnection(url, username, passwd)

    val preparedStatement = getconnection().prepareStatement(
      sql )
    val result: ResultSet = preparedStatement.executeQuery()

    //用户点集
    var usersAB=Set[(Long,(String,Int))]()
    //仓库点集
    var reposAB:Set[(Long,(String,Int))]=Set()
    var cnt=1L
    //边集
    var edgeAB=Set[Edge[Int]]()
    //无向边集
    var undirectEdgeAB=Set[Edge[Int]]()
    //名称与id的映射关系
    var name2id = mutable.HashMap[String,Long]()
    //id与名称的映射关系
    var id2name = mutable.HashMap[Long,String]()
    //用户和被其star的仓库的映射关系
    var user_repos = mutable.HashMap[Long,Set[Long]]()
    while(result.next()&&cnt>0){
      var username=result.getString("user_name")
      var reponame=result.getString("repo_name")
      var userid=cnt
      var repoid=cnt+1
      if(!id2name.contains(userid)){
        id2name.put(userid,username)
      }
      if(!id2name.contains(repoid)){
        id2name.put(repoid,reponame)
      }

      if(name2id.contains(username)){
        userid=name2id.getOrElseUpdate(username,0)
      }
      else{
        name2id.put(username,userid)
      }
      if(name2id.contains(reponame)){
        repoid=name2id.getOrElseUpdate(reponame,0)
      }
      else{
        name2id.put(reponame,repoid)
      }
      //更新用户的repos user_repos
      if(!user_repos.contains(userid)){
        user_repos.put(userid,Set())
      }
      user_repos.getOrElseUpdate(userid,Set()).add(repoid)

      usersAB += Tuple2(userid,(username,1))
      reposAB += Tuple2(repoid,(reponame,2))
      edgeAB+=Edge(userid,repoid,1)
      undirectEdgeAB+=Edge(userid,repoid,1)
      undirectEdgeAB+=Edge(repoid,userid,1)
      cnt+=2
//      print(result.getInt("user_id")+" ")
//      print(result.getString("user_name")+" ")
//      print(result.getString("repo_name")+" ")
//      println()
    }
    println("usersAB:")
    println(usersAB)
    println("reposAB:")
    println(reposAB)

    // 构造vertexRDD和edgeRDD、undirect_edgeRDD
    val vertexAB:ArrayBuffer[(Long,(String,Int))]=ArrayBuffer.concat(usersAB,reposAB)
    val vertexs=vertexAB.toArray
    val vertexRDD: RDD[(Long, (String, Int))] = sc.parallelize(vertexs)
    println("vertexRDD.foreach(println(_)):")
    println(vertexRDD.foreach(println(_)))
    val edges=edgeAB.toArray
    val edgeRDD: RDD[Edge[Int]] = sc.parallelize(edges)
    println("edgeRDD.foreach(println(_)):")
    println(edgeRDD.foreach(println(_)))
    val undirect_edges=undirectEdgeAB.toArray
    val undirect_edgeRDD: RDD[Edge[Int]] = sc.parallelize(undirect_edges)
    // 构造图Graph[VD,ED]
    val graph: Graph[(String, Int), Int] = Graph(vertexRDD, edgeRDD)
    println("graph:")
    println(graph)

    // 构造无向图Graph[VD,ED]
    val undirect_graph: Graph[(String, Int), Int] = Graph(vertexRDD, undirect_edgeRDD)

    // 取连通图，连通图以图中最小Id作为label给图中顶点打属性
    val cc = undirect_graph.connectedComponents().vertices
    println("cc:")
    cc.foreach(println(_))

    val storecc=cc.filter(v=>v._1%2==1).collect()
    println("storecc:")
    storecc.foreach(println(_))
    //将分类映射入哈希表中
    var cchs = mutable.HashMap[Long,Long]()
    storecc.foreach(v=>cchs.put(v._1,v._2))
    println("cchs.foreach(println(_)):")
    cchs.foreach(println(_))


    val classset:mutable.Set[VertexId]=Set()
    //val classset:ArrayBuffer[Long]=ArrayBuffer()
    //求连通分支数
    for(v<-cc.collect()){//需要collect()
//      val temp=v._2
//      println(temp)
      //classset+=temp
      classset.add(v._2)
    }
    //cc.foreach(v=>classset.add(v._2))
    println("classset.size:")
    println(classset.size)
    //classset.foreach(println(_))
    println("is_same_set")
    println(is_same_set(78L,18L,cc))

    // 最活跃的用户   Degrees操作
    // 找出图中最大的出度、入度、度数
    def max(a: (VertexId, Int), b: (VertexId, Int)): (VertexId, Int) = {
      if (a._2 > b._2) a else b
    }
    var mostActiveUser=graph.outDegrees.reduce(max)
    println("mostActiveUser:")
    println(mostActiveUser)
    //println("graph.outDegrees.foreach")
    //graph.outDegrees.foreach(println(_))
    //用户活跃程度降序排列
    var activeUsers=graph.outDegrees.collect().sortBy(v=>new MethodForSort(v._2))
    //var tmp=activeUsers.sortBy(_._2).reverse//sortBy(v=>new MethodForSort(v._2))
    println("activeUsers.foreach(println(_)):")
    activeUsers.foreach(println(_))


    // 最受欢迎的仓库   Degrees操作
    // 找出图中最大的出度、入度、度数
    var mostPopularRepo=graph.inDegrees.reduce(max)
    println("mostPopularRepo:")
    println(mostPopularRepo)
    //仓库受欢迎程度，降序排列
    var popularRepos=graph.inDegrees.collect().sortBy(v=>new MethodForSort(v._2))
    println("popularRepos.foreach(println(_)):")
    popularRepos.foreach(println(_))


    println("usersAB.size:")
    println(usersAB.size)
    println("reposAB.size:")
    println(reposAB.size)

    //给用户推荐仓库
    var user_recommend_repos = mutable.HashMap[Long,Set[Long]]()
    var k:Int=1
    for(user<-usersAB){
      var userid=user._1
      recommend_repos(userid,user_repos,user_recommend_repos,k,cc)
    }
    println("user_recommend_repos.foreach(println(_)):")
    user_recommend_repos.foreach(println(_))


    //将推荐仓库的结果存入MySQL



    //println(is_same_set(5L,17L,cc))
    //    val mapRow = (r:ResultSet)=>{
    //      val user_id:Int = r.getInt("user_id")
    //      val user_name:String = r.getString("user_name")
    //      val repo_name:String = r.getString("repo_name")
    //      (user_id,user_name,repo_name)
    //    }
    //
    //    val jdbcRDD: JdbcRDD[(Int,String,String)] = new JdbcRDD(
    //      sc,
    //      getconnection,
    //      sql,
    //      1,  //下限
    //      1000000, //上限
    //      1,  //分区数
    //      mapRow
    //    )
    //
    //    jdbcRDD.foreach(println)
    //    jdbcRDD.collect
  }
  //判断是否属于同一连通分支里
  def is_same_set(a:Long,b:Long, cc: VertexRDD[graphx.VertexId]):Boolean={
    val cc_a_label:Long = cc.filter{case (id, label) => id == a}.first._2
    val cc_b_label:Long = cc.filter{case (id, label) => id == b}.first._2
    return cc_a_label==cc_b_label
  }
  def recommend_repos(userid:Long,user_repos:mutable.HashMap[Long,Set[Long]],user_recommend_repos:mutable.HashMap[Long,Set[Long]],k:Int,cc: VertexRDD[graphx.VertexId]):Unit={
    var cnt:Int=0
    if(!user_recommend_repos.contains(userid)){
      user_recommend_repos.put(userid,Set())
    }
    var recommend_repos=user_recommend_repos.getOrElseUpdate(userid,Set())
    for (urp<-user_repos){
      if(userid!=urp._1){
        var a_repo=user_repos.getOrElseUpdate(userid,Set())
        var b_repo=urp._2
        var c_repo=a_repo intersect b_repo
        if(c_repo.size>=k){
          recommend_repos=recommend_repos union (b_repo diff  a_repo)
        }
      }
    }
//    println("recommend_repos:")
//    println(recommend_repos)
    if(recommend_repos.size>0){
      user_recommend_repos.put(userid,recommend_repos)
    }

  }
}
// 自定义排序,sorted排序继承Ordered,需要序列化
class MethodForSort(val fv:Int) extends Ordered[MethodForSort] with Serializable{
  override def compare(that: MethodForSort): Int = {
    -(this.fv-that.fv)
  }
}
//存进去的时候做下转化，需要存为名字字段的，用id2name哈希表把id转化为name
//存4个表：
//第1个表，用户分类表（表里包含两个字段：用户名、类别（哈希表中键所对应的数值）），对应变量：cchs
//第2个表，活跃用户的降序排列的表（表里包含两个字段：用户名、活跃度（就是那个排序的数值）），对应变量：activeUsers
//第3个表，受欢迎仓库的降序排列的表（表里包含两个字段：仓库名、受欢迎度（也是那个排序的值）），对应变量：popularRepos
//第4个表，仓库推荐表（表里两个字段：用户名、被推荐仓库名），对应变量：user_recommend_repos