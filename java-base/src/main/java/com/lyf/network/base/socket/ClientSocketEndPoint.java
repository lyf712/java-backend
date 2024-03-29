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

package com.lyf.network.base.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @authorliyunfei
 * @date2022/11/23
 **/
public class ClientSocketEndPoint {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        // 请求连接,发起SYN
        socket.connect(new InetSocketAddress("",99));
        socket.getInputStream();

        // 断开
        socket.close();
    }
}
