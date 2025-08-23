/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-12 19:28:40 UTC+08:00
 ****************************************************/
package org.example.judgment.demo;

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class Demo2 {

    public static void main(String[] args) {
        /*
         * 假设某影院售卖了100张票，票的序号为1~100
         * 其中奇数票号坐左侧，偶数票号坐右侧。
         * 键盘录入一个整数表示电影票的票号
         * 根据不同情况，给出不同的提示：
         * 如果票号为奇数，那么打印坐左边
         * 如果票号为偶数，那么打印坐右边
         * */

        Scanner scanner = new Scanner(System.in);
        System.out.print("输入电影院的票号: ");

        int ticket = scanner.nextInt();

        if (ticket >= 0 && ticket <= 100) {
            
            if (ticket % 2 == 1) {  // 余数等于1说明是奇数
                System.out.println("坐左边");
            } else {
                System.out.println("坐右边");
            }
            
        }


    }

}
