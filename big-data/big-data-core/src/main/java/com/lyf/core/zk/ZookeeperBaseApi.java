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

package com.lyf.core.zk;

import com.google.common.collect.Lists;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.ZooKeeperServerMain;

import java.io.IOException;
import java.util.List;

/**
 * @author liyunfei
 **/
public class ZookeeperBaseApi {

    private final static String CONN_URL ="127.0.0.1:2181";

    private static ZooKeeper client;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {

        client = new ZooKeeper(CONN_URL, 10, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("获取变化："+watchedEvent);
                try {
                    List<String> children = client.getChildren("/", true);
                    for (String child : children) {
                        System.out.println(child);
                    }
                    System.out.println("---------");
                } catch (KeeperException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread.sleep(6000);
        //System.out.println("create node");
        //zooKeeper.create("/test2","data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        //System.out.println(new String(zooKeeper.getData("/test2",false,new Stat())));
//        List<String> children = client.getChildren("/", true);
//        for (String child : children) {
//            System.out.println(child);
//        }
//        client.getData("/test2", new Watcher() {
//            @Override
//            public void process(WatchedEvent watchedEvent) {
//                System.out.println("");
//            }
//        },new Stat());

        // 监听节点变化
        client.getChildren("/", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("test："+watchedEvent);
                System.out.println("hhh");
            }
        });

        if(null==client.exists("/dataChange",false)){
            client.create("/dataChange","data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        }

        // 监听值变化
        client.getData("/dataChange", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        },new Stat());


        Thread.sleep(1000000);
    }




}
