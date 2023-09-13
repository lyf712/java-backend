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

import org.apache.zookeeper.*;
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
        client = new ZooKeeper(CONN_URL, 10, watchedEvent -> {

        });

    }

    @Test
    public void testCreate() throws InterruptedException, KeeperException {
        Thread.sleep(1000);
        client.create("/test4","data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
    }
}
