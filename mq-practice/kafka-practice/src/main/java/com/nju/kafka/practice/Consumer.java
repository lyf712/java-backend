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

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * @authorliyunfei
 * @date2022/11/13
 **/
public class Consumer {
    private final static String TOPIC_NAME = "topic-bigdata-1";
    private final static String CONSUMER_GROUP_NAME = "testGroup";
    private final static String KAFKA_SERVERS_CLUSTER_STR = "worker1,worker2,worker3:9092";//集群用逗号分隔

    public static void main(String[] args) {

        // 1.设置消费者的配置信息
        Properties props = makeConsumerProperties();

        // 2.创建消费者对象。通过配置信息
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        // 3.消费者对象订阅主题
        // 直接订阅主题
        consumer.subscribe(Arrays.asList(TOPIC_NAME));

        //4. 获取/消费消息
        while (true) {
            /**4.1 获取消费消息
             * poll()：表示拉取消息的长轮询
             */
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));

            //4.2 处理消息
            for (ConsumerRecord<String, String> record : records) {
                // 打印consumerRecords
                System.out.printf("收到消息：partition = %d,offset = %d, key = %s, value = %s%n", record.partition(),
                        record.offset(), record.key(), record.value());
            }
        }
    }

    /**
     * 设置消费者配置信息
     * @return
     */
    private static Properties makeConsumerProperties() {
        Properties props = new Properties();
        //指定连接的 kafka集群
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVERS_CLUSTER_STR);
        // 消费分组名
        props.put(ConsumerConfig.GROUP_ID_CONFIG, CONSUMER_GROUP_NAME);

        //key,value的序列化：这里把 key和 value从字符串序列化为字节数组
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        return props;
    }
}
