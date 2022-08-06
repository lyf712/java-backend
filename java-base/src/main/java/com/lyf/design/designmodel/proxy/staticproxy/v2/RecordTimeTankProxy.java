package com.lyf.design.designmodel.proxy.staticproxy.v2;

/**
 * @AUTHOR LYF
 * @DATE 2022/6/7
 * @VERSION 1.0
 * @DESC
 */
public class RecordTimeTankProxy implements Actionable{
    Actionable actionable;

    public RecordTimeTankProxy(Actionable actionable) {
        this.actionable = actionable;
    }

    public void setActionable(Actionable actionable) {
        this.actionable = actionable;
    }

    @Override
    public void move() {
        // add
        long start = System.currentTimeMillis();
        actionable.move();
        long end = System.currentTimeMillis();
        System.out.println("consume:"+(end-start));
    }

    @Override
    public void shoot() {

    }
}
