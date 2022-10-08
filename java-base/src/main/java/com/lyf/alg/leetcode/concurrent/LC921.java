package com.lyf.alg.leetcode.concurrent;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 使括号有效的最少添加
 * https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/
 * 对比分析：java中的stack、Deque的设计
 * @author liyunfei
 */
public class LC921 {
    
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        // 括号匹配问题
        stack.isEmpty();//O(1)
        stack.peek();
        stack.pop();
        stack.push('c');
        Stack<Character> stack2 = new Stack<>();
        stack2.setSize(10);
        Deque<Character> stack3 = new ArrayDeque<>();
        
    }
    
}
