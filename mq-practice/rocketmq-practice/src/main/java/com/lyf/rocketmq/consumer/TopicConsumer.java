package com.lyf.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageQueue;

import javax.jms.MessageConsumer;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.cnblogs.com/markLogZhu/p/12545597.html
 * @author liyunfei
 */
public class TopicConsumer {
    // 本地 offset 存储容器，生产环境可以放到数据库或 Redis 中
    private static final Map<MessageQueue, Long> OFFSE_TABLE = new HashMap<MessageQueue, Long>();
    
    public static void main(String[] args) {
    
    }
    
}
