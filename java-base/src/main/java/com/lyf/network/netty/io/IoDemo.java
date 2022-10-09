package com.lyf.network.netty.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author liyunfei
 */
public class IoDemo {
    private final String FILE_PARENT_PATH = "E:\\JavaProjects\\LearnProjects\\java-backend\\java-base\\src\\main\\java\\com\\lyf\\network\\netty\\io";
    
    @Test
    public void testWriteToFile(){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(FILE_PARENT_PATH+"\\test.txt");
            fileOutputStream.write("hello".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream!=null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @Test
    public void testReadFromFile(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(FILE_PARENT_PATH+"\\test.txt");
            byte[] bytes = new byte[1024];
            fileInputStream.read(bytes);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
            
        }finally {
            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
