/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-12 20:29:45 UTC+08:00
 ****************************************************/
package org.example.judgment.demo;

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class Demo6 {

    public static void main(String[] args) {

        /*
         * 当我们拨打了某些服务电话时，一般都会有按键选择。
         * 假设现在我们拨打了一个机票预定电话。
         * 电话中语音提示：
         * 1机票查询
         * 2机票预订
         * 3机票改签
         * 4退出服务
         * 其他按键也是退出服务。请使用switch模拟该业务逻辑。
         * */

        Scanner scanner = new Scanner(System.in);
        System.out.print("输入选择: ");

        int choose = scanner.nextInt();

        switch (choose) {
            case 1:
                System.out.println("1机票查询");
                break;
            case 2:
                System.out.println("2机票预订");
                break;
            case 3:
                System.out.println("3机票改签");
                break;
            case 4:
                System.out.println("4退出服务");
                break;
        }

    }

}
