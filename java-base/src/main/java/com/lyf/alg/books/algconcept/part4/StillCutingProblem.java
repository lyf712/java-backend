package com.lyf.alg.books.algconcept.part4;

import org.junit.Test;

import java.util.Arrays;

/**
 * 钢条切割问题
 *
 * @author liyunfei
 */
public class StillCutingProblem {
    
    /**
     * 分析思路：
     * 1. 分析问题
     * - 已知小规模的价格表 → 不同的组合，子问题求解
     * - 求解**最佳**切割方案 → 最优解
     * 1. 分析小规模情况—逐步刻画最优解结构（小规模一般心算更快？）
     *
     * 1：1
     *
     * 2: 1+1 ; 5 → 5
     *
     * 3: 1+1+1;1+5;8 → 8
     *
     * 4：— 10
     *
     * 5：13
     *
     * 6：17
     *
     * 7：18
     *
     * 8：22
     *
     * 9：25
     *
     * 10：30
     *
     * PnMax  = Max{  Max{ pn-i Max + pi Max }   , Pn} 递归地定义最优解的值
     *
     * 1. 刻画最优解
     *
     * arr[i]保存—-
     */
    
    /**
     * 初始的价格表
     */
    private final static int[] initPriceTable = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
    
    @Test
    public void solution() {
        final int n = 20;
        int[] maxPriceTable = new int[n];
        // 构造前十个（初始的价格表具有的）
        //  PnMax  = Max{  Max{ pn-i Max + pi Max }  , Pn}
        //  PnMax  = Max{ pn-i Max + pi Max }
        // n^2 (本身n，具有2^n种，指数级）
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                int max1 = maxPriceTable[j] + maxPriceTable[i - j - 1];
                if (max1 > max) {
                    max = max1;
                }
            }
            if (i < 10) {
                maxPriceTable[i] = Math.max(max, initPriceTable[i]);
                continue;
            }
            maxPriceTable[i] = max;
        }
        System.out.println(Arrays.toString(
                maxPriceTable));//[1, 5, 8, 10, 13, 17, 18, 22, 25, 30, 31, 35, 38, 40, 43, 47, 48, 52, 55, 60]
    }
    
}
