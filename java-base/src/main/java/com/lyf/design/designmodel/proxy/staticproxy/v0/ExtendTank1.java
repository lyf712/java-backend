package com.lyf.design.designmodel.proxy.staticproxy.v0;

import java.util.Random;

/**
 * @AUTHOR LYF
 * @DATE 2022/6/7
 * @VERSION 1.0
 * @DESC
 * need to add new functions:
 * example as
 * print log,record time,transaction,validate and so on..
 * and also need to composite them
 *
 * try not to use extends to extend,it is not flexible
 *
 */
public class ExtendTank1 extends Tank{
    /*
    * to extend record time
     */
    @Override
    public void move() {
        long start  = System.currentTimeMillis();
        super.move();
        try {
            Thread.sleep(new Random().nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("consume time:"+(end-start));
    }

    @Override
    public void shoot() {
        super.shoot();
    }
}
