package com.lyf;

/**
 * 汉罗塔递归去理解状态机，状态的迁移
 *
 * @author liyunfei
 */
public class HonoiDemo {
    
    static void honoi(int n, String from, String to, String middle) {
        if (n == 1) {
            System.out.println(from + "---->" + to);
            return;
        }
        honoi(n-1,from,middle,to);
        honoi(1,from,to,middle);
        honoi(n-1,middle,to,from);
    }
    
    public static void main(String[] args) {
        honoi(2,"A","B","C");
    }
}
