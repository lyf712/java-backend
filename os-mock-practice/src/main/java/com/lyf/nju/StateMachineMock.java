package com.lyf.nju;

import java.util.concurrent.TimeUnit;

/**
 * 数字系统-简单状态机模拟 （1）00 -> 01 -> 00 (2）七段管
 *
 * @author liyunfei
 */
public class StateMachineMock {
    
    static void mockStateTransfer() {
        int curState = 0;
        System.out.println("cur state:" + curState);
        for (; ; ) {// 迭代的一个过程
            // 只能实现两种状态的迁移---思考多种状态的迁移呢？
            int nextState = curState ^ 1;// 若两位数 → 采用byte[]..;
            System.out.println("next state:" + nextState);
            curState = nextState;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        mockStateTransfer();
    }
}
