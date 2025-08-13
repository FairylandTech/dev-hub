/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 14:25:33 UTC+08:00
 ****************************************************/
package org.example.method.demo;

/**
 * @author Lionel Johnson
 */
public class Demo4 {
    /*
     * 需求：定义一个方法，求一家商场每个季度的营业额。
     * 根据方法结果再计算出全年营业额。
     * */
    public static int quarterTurnover(int a, int b, int c) {
        return a + b + c;
    }
    
    public static void main(String[] args) {
        int q1 = quarterTurnover(10, 20, 30);
        int q2 = quarterTurnover(20, 30, 40);
        int q3 = quarterTurnover(20, 30, 40);
        int q4 = quarterTurnover(20, 30, 40);
        
        System.out.println("全年的营业额为: " + (q1 + q2 + q3 + q4));
    }
}
