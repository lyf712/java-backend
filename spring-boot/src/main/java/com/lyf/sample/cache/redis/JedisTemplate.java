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

package com.lyf.sample.cache.redis;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * https://github.com/redis/redis
 *
 * @authorliyunfei
 * @date2022/11/25
 **/
@Component
public class JedisTemplate {

    @Value("spring.redis.config.ip")
    private String ip;

    private final String remoteIp = "47.98.99.88";

    public void test(){
//        Jedis jedis = new Jedis(remoteIp,6379);
//        // redis集群--
//        //JedisCluster jedisCluster = new JedisCluster();
//        jedis.auth("123456");
//        jedis.ping("hello");
//
//        jedis.set("graph","ok");
        // base operation--
        // value,list,set,hash,unsortset,geo,hyploglog,
        // expire 失效 淘汰策略

        //
    }

}
