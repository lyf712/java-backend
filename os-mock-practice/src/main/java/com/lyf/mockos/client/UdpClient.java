package com.lyf.mockos.client;

import com.lyf.mockos.server.sys.SysConfigConstants;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * @author liyunfei
 */
public class UdpClient {
    
    public static void main(String[] args) throws SocketException {
        DatagramSocket datagramSocket = new DatagramSocket(99);
        SocketAddress socketAddress = new InetSocketAddress("127.0.0.1",SysConfigConstants.UDP_PORT);
        
        DatagramPacket datagramPacket =
                new DatagramPacket("hello".getBytes(StandardCharsets.UTF_8),0,5, socketAddress);
        try {
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
