/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 10:53:33 UTC+08:00
 ****************************************************/
package org.example.loop.demo;

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class Demo12 {
    /*
     * 需求：键盘录入一个大于等于2的整数×，计算并返回×的平方根。
     * 结果只保留整数部分，小数部分将被舍去
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个大于等于2的整数: ");
        int x = scanner.nextInt();
        
        if (x < 2) {
            System.out.println("输入必须大于等于2");
        } else {
            for (int i = 1; i < x + 1; i++) {
                if (i * i == x) {
                    System.out.println(i + "是" + x + "的平方根");
                    break;
                } else if (i * i > x) {
                    System.out.println((i - 1) + "是" + x + "的整数平方根");
                    break;
                }
            }
        }
    }
}
