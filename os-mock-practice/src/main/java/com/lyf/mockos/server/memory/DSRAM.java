package com.lyf.mockos.server.memory;

import com.lyf.mockos.server.cpu.eletronic.Bit;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liyunfei
 */
public class DSRAM {
    
    private volatile Map<Integer, Bit> mainMemoryMap = new HashMap<>(64);
    
    private final Object lock = new Object();
    
    void storage(int addressNo,Bit bit){
        synchronized (lock){
            
            mainMemoryMap.put(addressNo,bit);
            //
        }
    }
    
    Bit load(int addressNo){
        return mainMemoryMap.get(addressNo);
    }
}
