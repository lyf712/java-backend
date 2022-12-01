package com.lyf.scalabase

import scala.:+
import scala.collection.mutable.ArrayBuffer

object TestScala{

      def main(args:Array[String]){
//          println("my first scala app")
//          val arr = Array(
//              1,2,3
//          )
//          //arr+=1
//
//          val array = ArrayBuffer[(String,(Int,Int))]()
//          array+=(("",(1,2)))
//
//          val arr2 = array.toArray
//          arr2.foreach(e=>println(e))

        val vertexArrBuf = new ArrayBuffer[(Long,(String,Int))]()
        vertexArrBuf += ((1,("ok",1)))
        vertexArrBuf += ((2,("ok2",12)))
        vertexArrBuf.foreach(e=>{
            println(e)
            println(e._1)
        })
      }

}