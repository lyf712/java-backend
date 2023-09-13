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

package com.lyf.core.zk.server;

import org.apache.zookeeper.server.ServerConfig;
import org.apache.zookeeper.server.ZooKeeperServerMain;
import org.apache.zookeeper.server.admin.AdminServer;

import java.io.IOException;

/**
 * @author liyunfei
 **/
public class SelfZkServer {

    public static void main(String[] args){
        args = new String[2];
        args[0] = "2181";
        args[1] = "E:\\JavaProjects\\LearnProjects\\java-backend\\big-data\\big-data-core\\src\\main\\resources\\zk\\data";
        ZooKeeperServerMain.main(args);
    }
}
