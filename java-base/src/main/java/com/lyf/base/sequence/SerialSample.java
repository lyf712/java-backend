package com.lyf.base.sequence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.constant.Constable;
import java.lang.constant.ConstantDesc;

/**
 * 1.serial 中文教程 https://www.kancloud.cn/apachecn/howtodoinjava-zh/1952930
 * 2.serial 官方JDK文档 https://docs.oracle.com/javase/8/docs/platform/serialization/spec/serialTOC.html
 *
 * @author liyunfei
 */
class TcpReport implements Serializable{
    private static final Long serialVersionUID = -7L;
    private String header;
    private String content;
}

class TcpReportCantSer{
    private String header;
    private String content;
}
public class SerialSample {
    private static final String SER_FILE_PATH = "E:\\JavaProjects\\LearnProjects\\java-backend\\java-base\\src\\main\\java\\com\\lyf\\base\\sequence\\files\\tcp-record.ser";
    // 系列化至文件中
    static void write(Object object,String path){ //TcpReport tcpReport
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
          
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 反系列化读取
    static void read(String path){
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object o = objectInputStream.readObject();
            System.out.println(o);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // 序列化过程：允许将 Java 对象写入文件系统以进行永久存储，也可以将其写入网络以传输到其他应用程序
//        write(new TcpReport(),SER_FILE_PATH);
//        write("String",SER_FILE_PATH);// String implements java.io.Serializable, Comparable<String>, CharSequence, Constable, ConstantDesc
//        write(new TcpReportCantSer(),SER_FILE_PATH);// java.io.NotSerializableException: com.lyf.base.sequence.TcpReportCantS
//
       
       // 反序列化
        read(SER_FILE_PATH);
    }
}
