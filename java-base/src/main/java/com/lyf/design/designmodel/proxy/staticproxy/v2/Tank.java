package com.lyf.design.designmodel.proxy.staticproxy.v2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

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
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void shoot() {
        System.out.println("shooting...");
    }
}
