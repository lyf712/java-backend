package com.lyf.mockos.server.cpu.eletronic;

/**
 * @author liyunfei
 */
public enum Bit {
    /**
     * high electronic level
     */
    H(1),
    /**
     * low electronic level
     */
    L(0);
    private final int value;
    
    Bit(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
}
