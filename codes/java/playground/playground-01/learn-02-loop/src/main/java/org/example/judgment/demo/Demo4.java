/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-12 20:03:49 UTC+08:00
 ****************************************************/
package org.example.judgment.demo;

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class Demo4 {

    public static void main(String[] args) {

        /*
         * 需求：键盘录入星期数，显示今天的减肥活动。
         * 周一：跑步
         * 周二：游泳
         * 周三：慢走
         * 周四：动感单车
         * 周五：拳击
         * 周六：爬山
         * 周日：好好吃一顿
         * */

        Scanner scanner = new Scanner(System.in);
        System.out.print("今天是星期几: ");

        int week = scanner.nextInt();

        switch (week) {
            case 1:
                System.out.println("跑步");
                break;
            case 2:
                System.out.println("游泳");
                break;
            case 3:
                System.out.println("慢走");
                break;
            case 4:
                System.out.println("动感单车");
                break;
            case 5:
                System.out.println("拳击");
                break;
            case 6:
                System.out.println("爬山");
                break;
            case 7:
                System.out.println("好好吃一顿");
                break;
            default:
                System.out.println("输入有误!");
                break;
        }

    }

}
