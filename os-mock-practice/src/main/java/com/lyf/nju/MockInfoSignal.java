package com.lyf.nju;

/**
 * 数字信号：电压电气特性--考虑容错性-噪音等因素
 * 模拟信号：CMOS管
 *
 * @author liyunfei
 */
public class MockInfoSignal {
    private final static Double VIL = 0.4;
    private final static Double VIH = 0.6;
    private final static Double VOL = 0.3;
    private final static Double VOH = 0.7;
    // 0 - VIL and VIH - 1 ：valid input info 0 - VOL：
    // VIL - VOL 为容错处理，静态特性
    // VIL/VOL → 0；VIH/VOH → 1
    
    
}
