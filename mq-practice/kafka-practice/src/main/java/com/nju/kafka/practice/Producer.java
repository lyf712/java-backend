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

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @authorliyunfei
 * @date2022/11/13
 **/
public class Producer {
    private final static String TOPIC_NAME = "test";//-bigdata-1

    //worker1,worker2,worker3 172.92.240.61 localhost
    private final static String KAFKA_SERVERS_CLUSTER_STR = "112.124.24.187:9092";//集群用逗号分隔112.124.24.187

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 1.设置生产者的配置信息
        Properties props = makeProducerProperties();

        // 2.创建生产者对象。通过配置信息
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);

        // 3.发送消息
        for (int i = 1; i <= 2; i++) {
            //3.1 构建消息数据
            //Order order = new Order(i, "订单-" + i, 1000.00);
            Message<String> message = new Message<>();

            //3.2 将消息数据封装成 ProducerRecord 对象
            //未指定发送分区  String.valueOf(message.getId())Caused by: org.apache.kafka.common.errors.TimeoutException: Topic test-bigdata-1 not present in metadata after 60000 ms.
            // 指定分区 , 0
            ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(TOPIC_NAME
                    , String.valueOf(message.getId()), JSON.toJSONString(message));// json串传递

            //3.3 同步方式发送消息
            Future<RecordMetadata> future = producer.send(producerRecord);

            RecordMetadata metadata = future.get();
            System.out.println("同步方式发送消息结果：" + "topic-" + metadata.topic() + "|partition-"
                    + metadata.partition() + "|offset-" + metadata.offset());


            TimeUnit.SECONDS.sleep(10);//方便异步测试
            //4.关闭资源
            producer.close();
        }
        }

        /**
         * 设置生产者配置信息
         *
         * @return
         */
        private static Properties makeProducerProperties () {
            Properties props = new Properties();
            //指定连接的 kafka集群
            props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVERS_CLUSTER_STR);
            props.put("metadata.broker.list",KAFKA_SERVERS_CLUSTER_STR);

            //key,value的序列化：这里把 key和 value从字符串序列化为字节数组
            props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            return props;
        }
}
