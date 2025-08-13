/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-12 19:04:52 UTC+08:00
 ****************************************************/
package org.example.judgment;

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class IfJudgment {

    // if 语句

    // 第一种格式
    public static void ifA() {
        // 键盘录入女婿酒量，如果大于2斤，老丈人给出回应，反之不回应

        Scanner scanner = new Scanner(System.in);
        System.out.print("输入酒量: ");

        int wine = scanner.nextInt();

        if (wine > 2) {
            System.out.println("老丈人的回应: ...");
        }

    }

    // 第二种格式
    public static void ifB() {
        /*
         * 键盘录入一个整数，表示身上的钱。
         * 如果大于等于100块，就吃网红餐厅。
         * 否则，就吃经济实惠的沙县小吃。
         * */

        Scanner scanner = new Scanner(System.in);
        System.out.print("输入钱包余额: ");

        int balance = scanner.nextInt();

        if (balance >= 100) {
            System.out.println("吃网红餐厅");
        } else {
            System.out.println("吃经济实惠的沙县小吃");
        }

    }

    // 第三种格式
    public static void ifC() {

        /*
         * 根据不同的分数送不同的礼物。
         * 如果是95~100分，送自行车一辆
         * 如果是90~94分，游乐场玩一天
         * 如果是80~89分，送变形金刚一个。
         * 如果是80分，揍一顿。
         * */

        Scanner scanner = new Scanner(System.in);
        System.out.print("输入一个成绩: ");

        int score = scanner.nextInt();

        if (score > 100 | score < 0) {
            System.out.println("输入的成绩不合法!");
            System.exit(0);
        }

        if (score >= 95) {
            System.out.println("送自行车一辆");
        } else if (score >= 90) {
            System.out.println("游乐场玩一天");
        } else if (score >= 80) {
            System.out.println("送变形金刚一个");
        } else {
            System.out.println("揍一顿");
        }

    }

}
