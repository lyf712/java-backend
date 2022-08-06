package com.lyf.design.designmodel.proxy.staticproxy.v1;

/**
 * @AUTHOR LYF
 * @DATE 2022/6/7
 * @VERSION 1.0
 * @DESC
 */
public class CompositeTank1 implements Actionable{
    Tank tank = new Tank();
    // still cant composite new functions conveniently
    @Override
    public void move() {
        // add new functions...
        tank.move();
    }

    @Override
    public void shoot() {
        tank.shoot();
    }
}
