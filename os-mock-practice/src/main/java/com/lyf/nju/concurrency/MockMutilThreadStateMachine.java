package com.lyf.nju.concurrency;

import java.util.Stack;

/**
 * @author liyunfei
 */
public class MockMutilThreadStateMachine {
    
    private Object globalVar1;
    
    private static class StackFrame {
        Object localVar;
        String addressRef;
    }
    
    private static class MockThread {
        
        private int threadNo;
        
        private Stack<StackFrame> stackFrames;
        
        
    }
    
    
    
    
}
