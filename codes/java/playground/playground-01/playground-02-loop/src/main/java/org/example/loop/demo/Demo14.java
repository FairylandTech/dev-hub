/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 11:42:07 UTC+08:00
 ****************************************************/
package org.example.loop.demo;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class Demo14 {
    /*
     * 程序自动生成一个1-100之间的随机数字，使用程序实现猜出这个数字是多少?
     * */
    public static void main(String[] args) {
        int randomNumber = new Random().nextInt(100) + 1; // 1-100的随机数
        
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < 5; i++) {
            System.out.print("猜一猜这个数字: ");
            int x = scanner.nextInt();
            
            if (x > randomNumber) {
                System.out.println("大了");
            } else if (x < randomNumber) {
                System.out.println("小了");
            } else {
                System.out.println("猜对了");
                break;
            }
        }
    }
}
