package com.lyf.design.designmodel.proxy.staticproxy.v1;

/**
 * @AUTHOR LYF
 * @DATE 2022/6/7
 * @VERSION 1.0
 * @DESC
 */
public class Tank implements Actionable {

    @Override
    public void move() {
        System.out.println("moving...");
    }

    @Override
    public void shoot() {
        System.out.println("shooting...");
    }
}
