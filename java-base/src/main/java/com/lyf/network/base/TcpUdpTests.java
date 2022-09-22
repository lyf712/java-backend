package com.lyf.network.base;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Arrays;

/**
 * @author liyunfei
 */
public class TcpUdpTests {
    
    @Test
    public void testUdpServer() {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(90,InetAddress.getLocalHost());
           // datagramSocket.bind(new InetSocketAddress(100));
            DatagramPacket datagramPacket = new DatagramPacket("receive".getBytes(),4);
            datagramSocket.receive(datagramPacket);
            System.out.println("receive::"+ Arrays.toString(datagramPacket.getData()));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testUdpClient() {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(80);
            //datagramSocket.connect(new InetSocketAddress(90));
            DatagramPacket datagramPacket = new DatagramPacket("hello".getBytes(),
                    0,5,InetAddress.getLocalHost(),90);
            
            System.out.println("发送UDP报");
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
