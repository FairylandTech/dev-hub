/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-20 12:06:20 UTC+08:00
 ****************************************************/
package org.example.math.demo;

/**
 * 自幂数: 一个n位自然数等于自身各个数位上数字的n次幂之和
 * @author Lionel Johnson
 */
public class SelfPowerNumber {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            int unit = i % 10;
            int ten = i / 10 % 10;
            int hundred = i / 100 % 10;
            
            double sum = Math.pow(unit, 3) + Math.pow(ten, 3) + Math.pow(hundred, 3);
            
            if (sum == i) {
                System.out.println(i);
            }
        }
    }
}
