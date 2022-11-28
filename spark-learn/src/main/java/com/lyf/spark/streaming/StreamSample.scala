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

package com.lyf.spark.streaming

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @authorliyunfei
 * @date2022/11/28
 * */
object StreamSample {
  def main(args: Array[String]): Unit = {
    val dataFile = "E:\\JavaProjects\\LearnProjects\\java-backend\\spark-learn\\src\\main\\java\\com\\lyf\\spark\\files\\test.csv";
    //"E:\\JavaProjects\\LearnProjects\\java-backend\\java-crawler\\simple-demo\\src\\main\\resources\\githubdata\\repo_core_info_0_46.csv";

    // val logFile = "E:\\JavaProjects\\CourseProjects\\cloud-compute-lab\\cloud-compute-crawler\\src\\main\\resources\\files\\test\\repo_core_info_0_46.csv";
    //"E:\\JavaProjects\\CourseProjects\\cloud-compute-lab\\cloud-compute-bigdata\\src\\main\\resources\\sparkTest.txt"
    val conf = new SparkConf().setAppName("Simple App")

    conf.setMaster("local")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(dataFile, 2).cache()
    val numAs = logData.filter(line => line.contains("JavaScript")).count()
    val numBs = logData.filter(line => line.contains("Ruby")).count()

    println(numAs, numBs)
  }

}
