package com.lyf.httpweb;

import com.lyf.httpweb.config.ConfigLoader;
import com.lyf.httpweb.config.SysConfig;
import com.lyf.httpweb.config.SysConfigConstants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liyunfei
 */
public class HttpServer {
    
    private static Integer port;
    
    private static String staticPath;
    
    // 等待连接队列长度
    private static final Integer BACK_LOG = 1024;
    
    private static ServerSocket serverSocket;
    
    private static boolean shutdown = false;
    
    public static void main(String[] args) {
        initSysConfig();
        start();
    }
    
    private static void initSysConfig() {
        ConfigLoader configLoader = ConfigLoader.getConfigLoader();
        port = Integer.valueOf((String) configLoader.getConfigInfo(SysConfigConstants.CONFIG_PORT));
        staticPath = (String) configLoader.getConfigInfo(SysConfigConstants.CONFIG_STATIC_PATH);
        if (port == null) {
            port = SysConfig.DEFAULT_PORT;
        }
        if (staticPath == null) {
            staticPath = SysConfig.DEFAULT_STATIC_PATH;
        }
    }
    
    static boolean start() {
        System.out.println("Http Server At " + port);
        try {
            serverSocket = new ServerSocket(port, BACK_LOG, InetAddress.getByName("localhost"));///InetAddress.getLocalHost()
            // 监听连接 accept()阻塞否？
            while (!shutdown) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                handleRequest(inputStream);
                handleResponse(outputStream);
                socket.close();
            }
        } catch (IOException e) {
            System.out.println("Appear Exception " + e.getMessage());
            e.printStackTrace();
        }
        return true;
    }
    
    static void stop(){
        shutdown = true;
    }
    
    static void handleRequest(InputStream inputStream) {
        byte[] bytes = new byte[1024];
        try {
            inputStream.read(bytes, 0, 1024);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static void handleStaticResp(OutputStream outputStream){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(SysConfig.DEFAULT_STATIC_PATH);
            
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    static void handleResponse(OutputStream outputStream) {
        try {
            // Content-Length:读取的长度，
            outputStream.write(("""
                    HTTP/1.1 200 OK\r
                    Content-TYpe: text/html\r
                    Content-Length: 23\r
                    \r
                    <h1>OK RESP</h1>
                    """
            ).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
//    GET / HTTP/1.1
//    Host: localhost:8081
//    Connection: keep-alive
//    Cache-Control: max-age=0
//    sec-ch-ua: "Google Chrome";v="89", "Chromium";v="89", ";Not A Brand";v="99"
//    sec-ch-ua-mobile: ?0
//    Upgrade-Insecure-Requests: 1
//    User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36
//    Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
//Sec-Fetch-Site: none
//Sec-Fetch-Mode: navigate
//Sec-Fetch-User: ?1
//Sec-Fetch-Dest: document
//Accept-Encoding: gzip, deflate, br
//Accept-Language: zh-CN,zh;q=0.9
//Cookie: Webstorm-59a3facc=e5e28620-4afb-4be4-a511-ec1747bc8061; Clion-ab894a8a=1636ef03-62b6-4432-9c86-96107ce96b58




}
