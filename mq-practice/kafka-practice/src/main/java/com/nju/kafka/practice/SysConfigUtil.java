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

package com.nju.kafka.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @authorliyunfei
 * @date2022/11/20
 **/
public class SysConfigUtil {
      private static final String DEFAULT_FILE_PATH = "E:\\JavaProjects\\LearnProjects\\java-backend\\mq-practice\\kafka-practice\\src\\main\\resources\\sysconfig.properties";

      private static final String KAFKA_SERVER_URL = "kafka.server.urls";

      private static final String KAFKA_PRODUCER_TOPIC_NAME = "kafka.server.producer.topic.name";

      private static final String KAFKA_CONSUMER_TOPIC_NAME = "kafka.server.consumer.topic.name";

      private static Properties configs = null;

      static {
          try {
              configs = new Properties();
              configs.load(new FileInputStream(DEFAULT_FILE_PATH));
          } catch (IOException e) {
              throw new RuntimeException(e);
          }
      }

      public static Object getKey(Object key){
          if(configs!=null){
              return configs.get(key);
          }
          return null;
      }

      public static String kafkaUrls(){
          if(configs!=null){
              return (String) configs.get(KAFKA_SERVER_URL);
          }
          return "";
      }

      public static String kafkaTopicProducerName(){
         if(configs!=null){
            return (String) configs.get(KAFKA_PRODUCER_TOPIC_NAME);
         }
         return "";
     }

      public static String kafkaTopicConsumerName(){
        if(configs!=null){
            return (String) configs.get(KAFKA_CONSUMER_TOPIC_NAME);
        }
        return "";
      }

}
