package com.lyf.mockos.server.remote;

import com.lyf.mockos.server.sys.SysConfigConstants;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.sql.Time;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 */
public class UdpReceiver {
    
    private static class UdpWorker implements Runnable {
        
        private DatagramSocket datagramSocket;
        
        public UdpWorker(DatagramSocket datagramSocket) {
            this.datagramSocket = datagramSocket;
        }
        
        @Override
        public void run() {
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes,0,1024);
            for (;;){
                try {
                    datagramSocket.receive(datagramPacket);
                    //System.out.println(Arrays.toString(datagramPacket.getData())+"::"+datagramPacket.getSocketAddress());
                    System.out.println(new String(datagramPacket.getData()));
               
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        
        }
    }
    
    public static void main(String[] args) {
        Thread thread;
        try {
            thread = new Thread(new UdpWorker(new DatagramSocket(SysConfigConstants.UDP_PORT)));
            thread.setDaemon(true);
            thread.start();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        //Thread.currentThread().setDaemon(true);
        for (;;){
            try {
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
