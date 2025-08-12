/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-12 18:27:08 UTC+08:00
 ****************************************************/
package org.example.demo;

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class Demo1 {

    /*
     * 数值拆分
     * 键盘录入一个三位数, 将其拆分为个位, 十位, 百位, 输出打印控制台
     * */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个三位数: ");
        int num = scanner.nextInt();

        int ge = num % 10;
        int shi = num / 10 % 10;
        int bai = num / 100 % 10;

        System.out.printf("个位: %d, 十位: %d, 百位: %d\n", ge, shi, bai);

    }

}
