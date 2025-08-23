/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-12 21:11:01 UTC+08:00
 ****************************************************/
package org.example.loop.demo;

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class Demo5 {

    /*
     * 键盘录入两个数字，表示一个范围。
     * 统计这个范围中
     * 既能被3整除，又能被5整除数字有多少个?
     * */

    public static void main(String[] args) {

        int axisLeft;
        int axisRight;
        int count = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("输入第一个数字: ");
        int numberA = scanner.nextInt();

        System.out.print("输入第二个数字: ");
        int numberB = scanner.nextInt();

        if (numberA >= numberB) {
            axisLeft = numberB;
            axisRight = numberA;
        } else {
            axisLeft = numberA;
            axisRight = numberB;
        }

        // 当 for 循环在这里尝试使用 axisLeft 和 axisRight 时，
        // 它们已经因为离开了 if/else 的作用域而无法访问。所以要先定义变量
        
        for (int i = axisLeft; i < (axisRight + 1); i++) {
            if (i % 3 == 0 && i % 5 ==0) {
                System.out.println(i + "既能被3整除又能被5整除");
                count++;
            }
        }

        System.out.println("在范围" + axisLeft + "和" + axisRight + "范围内, 既能被3整除又能被5整除的数字一共有" + count + "个");

    }

}
