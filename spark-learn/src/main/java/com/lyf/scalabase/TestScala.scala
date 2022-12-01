package com.lyf.scalabase

import scala.:+
import scala.collection.mutable.ArrayBuffer

object TestScala{

      def main(args:Array[String]){
          println("my first scala app")
          val arr = Array(
              1,2,3
          )
          //arr+=1

          val array = ArrayBuffer[(String,(Int,Int))]()
          array+=(("",(1,2)))

          val arr2 = array.toArray
          arr2.foreach(e=>println(e))
      }

}