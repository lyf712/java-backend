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

package com.lyf.base;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 **/
public class SocketClient {
    public static void main(String[] args) {
        // 创建Java对象
        Socket client = new Socket();
        try {
            // 程序交由OS内核进行建立连接（可采用tcpdump指令去抓包查看， 三次握手过程
            // 涉及拓展：1.长短连接问题 2.keep-alive参数 3.sendQ,recvQ
            // 阻塞IO
            client.connect(new InetSocketAddress("www.baidu.com",80));

            // 输出流，向内核发生队列进行写入数据（请求）
            OutputStream out = client.getOutputStream();

            // 请求协议标准（HTTP1.0
            // 拓展的知识：HTTP1.0,1.1,3等解决的问题，协议标准和IO的关系
            out.write("GET / HTTP/1.0\n\n".getBytes());

            // 请求之后，数据返回 放到内核的recv-q (一般 几十kb大小，注意区分网卡和内核TCP\Udp的层次分工
            // 情况讨论：程序要数据太快和太慢
            // TimeUnit.SECONDS.sleep(1);


            InputStream in = client.getInputStream();
            // 程序获取并处理数据1MB

            byte[] data = new byte[1024 * 1024];
            int size;
            while ( (size = in.read(data)) > 0){
                System.out.println("从内核读取数据 size:"+size);

                System.out.println(new String(data,0,size));
            }

            // 关闭连接 (挥手动作，注意 Listen,CLOSE_WAIT等状态
            client.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //

        }
    }
}
