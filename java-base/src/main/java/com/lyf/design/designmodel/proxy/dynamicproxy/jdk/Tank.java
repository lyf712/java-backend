package com.lyf.design.designmodel.proxy.dynamicproxy.jdk;

import com.lyf.design.learn.designmodel.proxy.staticproxy.v0.Actionable;

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
