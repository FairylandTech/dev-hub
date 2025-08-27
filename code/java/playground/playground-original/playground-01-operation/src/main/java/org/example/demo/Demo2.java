/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-12 18:31:33 UTC+08:00
 ****************************************************/
package org.example.demo;

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class Demo2 {

    /**
     * 其中一个为6, 返回true, 如果他们的和是6的倍数, 输入true
     */
    private static boolean num6(int a, int b) {
        return a == 6 || b == 6 || (a + b) % 6 == 0;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个整数: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(num6(a, b));
    }
}
