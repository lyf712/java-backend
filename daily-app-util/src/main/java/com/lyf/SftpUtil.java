package com.lyf;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.junit.Test;

import java.util.Properties;

/**
 * 基于SSH2的一个纯Java实现
 * 相关的网络工具包：https://www.oschina.net/project/tag/145/networklib 参考学习，分析其底层设计
 * SFTP应用层
 * @author liyunfei
 */
public class SftpUtil {
    private final static String HOST = "192.168.159.144";
    private final static String USER_NAME = "root";
    private final static String PASSWORD = "123321";
    private final static Integer PORT = 22;
    
    @Test
    public void testSftp(){
      //  ChannelSf
        //ChannelSftp channelSftp = new ChannelSftp();
    
        // 1.创建对象
        JSch jSch = new JSch();
        // 2.创建会话--会话层--sftp应用层协议 向下 是会话层
        try {
            Session session = jSch.getSession(USER_NAME,HOST,PORT);
            session.setPassword(PASSWORD);
            /**
             *      FIXME 建议 工厂-或枚举switch?
             *         if (type.equals("session")) {
             *             return new ChannelSession();
             *         } else if (type.equals("shell")) {
             *             return new ChannelShell();
             *         } else if (type.equals("exec")) {
             *             return new ChannelExec();
             *         } else if (type.equals("x11")) {
             *             return new ChannelX11();
             *         } else if (type.equals("auth-agent@openssh.com")) {
             *             return new ChannelAgentForwarding();
             *         } else if (type.equals("direct-tcpip")) {
             *             return new ChannelDirectTCPIP();
             *         } else if (type.equals("forwarded-tcpip")) {
             *             return new ChannelForwardedTCPIP();
             *         } else if (type.equals("sftp")) {
             *             return new ChannelSftp();
             *         } else {
             *             return type.equals("subsystem") ? new ChannelSubsystem() : null;
             *         }
             */
            
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setTimeout(30000);
            // 分析 该方法的实现过程，如何采用socket进行通信实现
            session.connect();
            
            ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();
            System.out.println(channelSftp.lpwd());// 结合shell脚本命令--高级逻辑式编程语言+shell脚本式语言 → 联系、贯通
            
            
        } catch (JSchException e) {
            e.printStackTrace();
        }
    
    }
}
