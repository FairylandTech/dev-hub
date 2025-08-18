/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-12 20:19:45 UTC+08:00
 ****************************************************/
package org.example.judgment.demo;

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class Demo5 {

    public static void main(String[] args) {

        /*
         * 需求：键盘录入星期数，输出工作日、休息日。
         * (1-5）工作日，（6-7)休息日。
         * */

        Scanner scanner = new Scanner(System.in);
        System.out.println("星期数: ");

        int week = scanner.nextInt();

        switch (week) {
            // case 1 到 4 会一直向下执行，直到遇到 break
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("工作日");
                break;
            case 6:
            case 7:
                System.out.println("休息日");
                break;
            default:
                System.out.println("输入有误!");
                break;
        }

        // JDK 12+
//        switch (week) {
//            case 1,2,3,4,5:
//                System.out.println("工作日");
//                break;
//            case 6,7:
//                System.out.println("休息日");
//                break;
//            default:
//                System.out.println("输入有误!");
//                break;
//        }

        // 另一种写法
//        switch (week) {
//            case 1, 2, 3, 4, 5 -> System.out.println("工作日");
//            case 6, 7 -> System.out.println("休息日");
//            default -> System.out.println("输入有误!");
//        }

    }

}
