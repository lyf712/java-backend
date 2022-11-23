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

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @authorliyunfei
 * @date2022/11/23
 **/
public class ServerSocketEndPoint {
    public static void main(String[] args) throws IOException {
        //backlog 队列大小
        ServerSocket serverSocket = new ServerSocket(80,50);
        // 持续监听
        for(;;){
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (bufferedReader.read()>=0){
                System.out.println(bufferedReader.readLine());
            }

            OutputStream outputStream = socket.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream("E:\\JavaProjects\\LearnProjects\\java-backend\\java-base\\src\\main\\resources\\index.html");
            int len = 0;
            outputStream.write("http/1.1 200 ok\r".getBytes());
//            while ((len = fileInputStream.read())>=0){
//                byte[] bytes = new byte[len];
//                fileInputStream.read(bytes);
//                outputStream.write(bytes);
//            }
            //outputStream.write("ok".getBytes());
        }
    }
}
