package com.lyf.base;

/**
 * @author liyunfei
 */
class A{
    static int staticvalue = 100;
    
    static{
        System.out.println("类A初始化");
    }
    public A(){
        System.out.println("类A构造方法:"+"value="+getValue());
    }
    public int getValue(){
        return staticvalue;
    }
}
class B extends A{
    public int value = 10 ;
    static{
        System.out.println("类B初始化");
    }
    
    public B(){
        System.out.println("类B构造方法:"+"value="+getValue());
    }
    public int getValue(){
        return value+10;
    }
}

public class ClassStructureLoadSeq {
    
    public static void main(String[] args) {
        System.out.println(B.staticvalue);
        A b = new B();
    }
}
