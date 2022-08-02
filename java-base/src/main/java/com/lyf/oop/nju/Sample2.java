package com.lyf.oop.nju;

import org.junit.Assert;

/**
 * @author liyunfei
 */
public class Sample2 {
    
    private static class Complex {
        // 封装属性--
        private int real;//
        
        private int image;
    
    
        public int getReal() {
            return real;
        }
    
        public void setReal(int real) {
            this.real = real;
        }
    
        public int getImage() {
            return image;
        }
    
        public void setImage(int image) {
            this.image = image;
        }
    
        public Complex(int real, int image) {
            this.real = real;
            this.image = image;
        }
        
        public Complex add(Complex b) throws Exception {
            // Assert.assertNotNull(b);
            
            if (b == null) {
                throw new Exception("Complext cant be null");
            }
            
            // 公共 ：---，印记-数据结构--，， ，内容 ---
            // getter-- getReal() b.attribute    b.method() .method2()
            return new Complex(this.real + b.real, this.image + b.image);
        }
        
    }
    
    public static void main(String[] args) {
    
    }
}
