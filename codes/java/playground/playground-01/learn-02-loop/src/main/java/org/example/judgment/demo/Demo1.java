/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-12 19:22:03 UTC+08:00
 ****************************************************/
package org.example.judgment.demo;

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class Demo1 {

    public static void main(String[] args) {

        /*
         * 假设，用户在超市实际购买，商品总价为：600元。
         * 键盘录入一个整数表示用户实际支付的钱，
         * 如果付款大于等于600，表示付款成功。否则付款失败。
         * */

        Scanner scanner = new Scanner(System.in);
        System.out.print("支付的金额: ");

        int payment = scanner.nextInt();

        if (payment >= 600) {
            System.out.println("支付成功!");
        } else {
            System.out.println("支付失败!");
        }

    }

}
