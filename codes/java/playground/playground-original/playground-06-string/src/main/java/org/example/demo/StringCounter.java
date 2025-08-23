/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-16 15:27:13 UTC+08:00
 ****************************************************/
package org.example.demo;

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class StringCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("输入一个字符串: ");
        String input = scanner.next().trim();
        
        int upperCount = 0;
        int lowerCount = 0;
        int digitCount = 0;
        
        for (char c : input.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                upperCount++;
            } else if (c >= 'a' && c <= 'z') {
                lowerCount++;
            } else if (c >= '0' && c <= '9') {
                digitCount++;
            }
        }
        
        System.out.printf("大写: %s, 小写: %s, 数字: %s", upperCount, lowerCount, digitCount);
    }
}
