package com.lyf.resource;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @author liyunfei
 */
@ShellComponent
public class ShellInteraction {
    
    @ShellMethod(value = "test1")
    void add1(int a, int b) {
        System.out.println(a + b);
        return;
    }
    
    @ShellMethod(value = "test2")
    int add2(int a, int b) {
        System.out.println(a + b);
        return a+b;
    }
}
