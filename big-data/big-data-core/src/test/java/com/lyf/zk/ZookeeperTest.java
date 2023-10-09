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

package com.lyf.zk;

import com.lyf.core.contants.ConfigConstants;
import org.apache.commons.collections.CollectionUtils;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author liyunfei
 **/
public class ZookeeperTest {


    private final static String CONN_URL ="127.0.0.1:2181";

    private static ZooKeeper client;

    @Before
    public void init() throws IOException, InterruptedException, KeeperException {
        System.setProperty("zookeeper.sasl.client", "false");
        client = new ZooKeeper(ConfigConstants.ZK_CLUSTER_URLS, 1000, watchedEvent -> {

        });
        // 建立连接需要一定时间
        Thread.sleep(1000);
    }

    @Test
    public void testGet(){
        try {
            List<String> children = client.getChildren("/", new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.printf("data change: %s"+watchedEvent.getType());
                    try {
                        List<String> children = client.getChildren("/",true);
                        if(CollectionUtils.isNotEmpty(children)){
                            children.forEach(System.out::println);
                        }
                    } catch (KeeperException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            });
            if(CollectionUtils.isNotEmpty(children)){
                children.forEach(System.out::println);
            }
            // 多路径的创建？
            //client.create("/config/base","1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            byte[] bytes = client.getData("/config",false,new Stat());
            System.out.println(new String(bytes,0,1));
            Thread.sleep(10);
        } catch (KeeperException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void testCreate() throws InterruptedException, KeeperException {
        client.create("/test4","data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
    }
}
