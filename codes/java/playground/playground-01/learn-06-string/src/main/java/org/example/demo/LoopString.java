/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-12 15:49:51 UTC+08:00
 ****************************************************/
package org.example.demo;

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class LoopString {

    public static void loopString(String string) {
        for (char character : string.toCharArray()) {
            System.out.println(character);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串: ");
        String string = scanner.next();

        loopString(string);
    }

}
