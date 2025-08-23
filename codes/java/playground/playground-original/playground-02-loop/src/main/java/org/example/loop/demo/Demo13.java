/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 11:09:30 UTC+08:00
 ****************************************************/
package org.example.loop.demo;

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class Demo13 {
    /*
    * 键盘录入一个正整数×，判断该整数是否为一个质数
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入一个正整数: ");
        
        int number = scanner.nextInt();
        
        boolean flag = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0){
                flag = false;
                break;
            }
        }
        
        if (flag){
            System.out.println(number + "是一个质数");
        } else {
            System.out.println(number + "不是一个质数");
        }
    }
}
