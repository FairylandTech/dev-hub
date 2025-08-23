/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-12 21:40:11 UTC+08:00
 ****************************************************/
package org.example.loop.demo;

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class Demo7 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个数字: ");
        
        int x = scanner.nextInt();
        
        // x < 0 负数不可能为回文数. 例如 -121反序是121-, 以0结尾的非零数, 例如 10, 120等
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            System.out.println("不是回文数.");
            System.exit(0);
        }
        
        // 反转一半的数字
        int reversedNumber = 0;
        while (x > reversedNumber) {
            reversedNumber = (reversedNumber * 10) + (x % 10);
            x /= 10;
        }
        
        if (x == reversedNumber || x == reversedNumber / 10) {
            System.out.println("是回文数.");
        } else {
            System.out.println("不是回文数.");
        }
        
    }
    
}
