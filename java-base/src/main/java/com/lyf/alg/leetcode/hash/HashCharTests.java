package com.lyf.alg.leetcode.hash;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 'a','b'
 * @author liyunfei
 */
public class HashCharTests {
    
    /**
     * 题目中时常出现 'a',
     * C/C++中可进行采用ASCII码进行转换，Java中
     */
    @Test
    public void testCharToHash(){
        int[]hash = new int[26];
//        hash['a'-'a'] = 1;
        char a = 'a';
        hash[a-'a']++;
        //System.out.println(hash[0]);
        System.out.println(Arrays.toString(hash));
        // 计数统计
        String str = "abcdda";
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            hash[str.charAt(i)-'a']++;
            //map.replace(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
            // map.computeIfPresent()
        }
        
        System.out.println(Arrays.toString(hash));
        System.out.println(map.toString());
        
        
        
        
        
    }
}
