package com.lyf.network.netty.sequence;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author liyunfei
 */
class Person implements Serializable{
    @java.io.Serial
    private static final long serialVersionUID = -6849794470754667720L;
    
    private String username;
    
    private Integer age;
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    byte[] codeByNio(){
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte[] val = username.getBytes(StandardCharsets.UTF_8);
        buffer.putInt(val.length);
        buffer.put(val);
        buffer.putInt(age);
        buffer.flip();
        byte[] rs = new byte[buffer.remaining()];
        buffer.get(rs);
        return rs;//buffer.array();
    }
    
}

public class JavaSerialTests {
    @Test
    public void testStreamSize() throws IOException {
        Person person = new Person();
        person.setAge(0);
        person.setUsername("Alan");
        
        //java序列化
//        ObjectOutputStream objectOutputStream = ObjectOutputStream.nullOutputStream();//new ObjectOutputStream();
//        objectOutputStream.writeObject(person);
        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(baos);
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();
        byte[] bytes = baos.toByteArray();
       
        System.out.println(bytes.length+":"+new String(bytes));
    
        System.out.println(person.codeByNio().length+":"+new String(person.codeByNio()));
        // java 附带很多Java相关的信息导致？流过大
//        202:�� sr %com.lyf.network.netty.sequence.Person��8z;�8 L aget Ljava/lang/Integer;Lusernamet Ljava/lang/String;xpsr java.lang.Integer⠤���8 I valuexr java.lang.Number������  xp    t Alan
//        12:   Alan
    }
    
    /**
     * cost by java serial:202
     * cost by buffer:105
     * @throws IOException
     */
    @Test
    public void testSpeed() throws IOException {
        final int loop = 10000;
        Person person = new Person();
        person.setAge(0);
        person.setUsername("Alan");
        long c1 = System.currentTimeMillis();
        for(int i=0;i<loop;i++){
            ByteArrayOutputStream baos  = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(baos);
            objectOutputStream.writeObject(person);
            objectOutputStream.flush();
            objectOutputStream.close();
            byte[] bytes = baos.toByteArray();
        }
        System.out.println("cost by java serial:"+(System.currentTimeMillis()-c1));
        c1 = System.currentTimeMillis();
        for(int i=0;i<loop;i++){
            person.codeByNio();
        }
        System.out.println("cost by buffer:"+(System.currentTimeMillis()-c1));
    }
}
