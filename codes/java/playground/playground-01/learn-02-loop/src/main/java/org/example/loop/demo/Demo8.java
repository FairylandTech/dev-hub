/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 10:01:22 UTC+08:00
 ****************************************************/
package org.example.loop.demo;

/**
 * @author Lionel Johnson
 */
public class Demo8 {
    
    /*
     * 需求：给定两个整数，被除数和除数（都是正数，且不超过int的范围）
     * 将两数相除，要求不使用乘法、除法和 % 运算符。
     * 得到商和余数。
     * */
    
    public static void main(String[] args) {
        int a = 102;
        int b = 10;
        
        int count = 0;
        while (a >= b) {
            a = a - b;
            count++;
        }
        
        System.out.println("商: " + count + ", 余数: " + a);
    }
    
}
