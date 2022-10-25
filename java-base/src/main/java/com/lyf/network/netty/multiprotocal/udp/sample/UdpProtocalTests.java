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

package com.lyf.network.netty.multiprotocal.udp.sample;

import org.junit.Test;

/**
 * @authorliyunfei
 * @date2022/10/25
 **/
public class UdpProtocalTests {
    private final UdpClient udpClient = new UdpClient();
    private final UdpServer udpServer = new UdpServer();
    @Test
    public void startServer() throws InterruptedException {
        udpServer.start();
    }
    @Test
    public void startClient() throws InterruptedException {
        udpClient.start();

    }
}
