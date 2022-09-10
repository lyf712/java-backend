package com.lyf.mockos.server.cpu.eletronic;

/**
 * 门电路--计算--
 *
 * @author liyunfei
 */
public class ElectronicCompute {
    
    public static Bit AND(Bit a, Bit b) {
        return (a.getValue() & b.getValue()) == 0 ? Bit.L : Bit.H;
    }
}
