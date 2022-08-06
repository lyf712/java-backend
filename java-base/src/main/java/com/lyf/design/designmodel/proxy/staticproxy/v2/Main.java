package com.lyf.design.designmodel.proxy.staticproxy.v2;

/**
 * @AUTHOR LYF
 * @DATE 2022/6/7
 * @VERSION 1.0
 * @DESC
 */
public class Main {
    public static void main(String[] args) {
        //  -- Runnable....
        new PrintLogTankProxy(new Tank()).move();
        System.out.println("==================");
        new PrintLogTankProxy(new RecordTimeTankProxy(new Tank())).move();
        System.out.println("==================");
        new RecordTimeTankProxy(new PrintLogTankProxy(new Tank())).move();
    }
}
