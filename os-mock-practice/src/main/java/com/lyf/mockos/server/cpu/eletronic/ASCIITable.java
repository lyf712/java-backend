package com.lyf.mockos.server.cpu.eletronic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyunfei
 */
public class ASCIITable {
    
    private final static Map<Integer, String> ASCIIMap = new HashMap<>(128);
    
    static {
        ASCIIMap.put(65,"A");
    }
    
    /**
     * transfer to binary flow str
     */
    public static String transferToTxtStr(Bit[] bits){
        int pos = 1,sum=0;
        for(int i = bits.length-1;i>=0;i--){
            sum+=bits[i].getValue()*pos;
            pos*=2;
        }
        return ASCIIMap.getOrDefault(sum,"");
    }
    
    
}
