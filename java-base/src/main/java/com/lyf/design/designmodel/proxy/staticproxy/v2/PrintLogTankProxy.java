package com.lyf.design.designmodel.proxy.staticproxy.v2;

/**
 * @AUTHOR LYF
 * @DATE 2022/6/7
 * @VERSION 1.0
 * @DESC
 */
public class PrintLogTankProxy implements Actionable{
    Actionable actionable;

    public PrintLogTankProxy(Actionable actionable) {
        this.actionable = actionable;
    }

    public void setActionable(Actionable actionable) {
        this.actionable = actionable;
    }
    @Override
    public void move() {
        System.out.println("start log ...moving");
        actionable.move();
        System.out.println("stop log ...moving");
    }

    @Override
    public void shoot() {

    }
}
