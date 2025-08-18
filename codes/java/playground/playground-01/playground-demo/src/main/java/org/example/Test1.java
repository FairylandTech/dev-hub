/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 19:16:28 UTC+08:00
 ****************************************************/
package org.example;

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class Test1 {
    /*
     * 卖飞机票
     *
     * 机票价格按照淡季旺季、头等舱和经济舱收费、输入机票原价、月份和头等舱或经济舱。
     * 按照如下规则计算机票价格：旺季（5-10月）头等舱9折，经济舱8.5折，淡季（11月到来年4月）头等舱7折，经济舱6.5折。
     * */
    private static double calculateDiscount(int month, String seatLevel) {
        if (month >= 5 && month <= 10) {
            // 旺季
            return seatLevel.equals("头等舱") ? 0.9 : 8.5;
        } else {
            // 淡季
            return seatLevel.equals("头等舱") ? 0.7 : 6.5;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("输入机票的原价: ");
        double price = scanner.nextDouble();
        
        System.out.print("输入当前月份: ");
        int month = scanner.nextInt();
        
        System.out.print("输入舱位(头等舱/经济舱): ");
        String seatLevel = scanner.next().trim();
        
        if (month <= 0 || month > 12) {
            System.out.println("输入的月份不合法");
            return;
        }
        
        if (!seatLevel.equals("头等舱") && !seatLevel.equals("经济舱")) {
            System.out.println("舱位必须是头等舱或者经济舱");
            return;
        }
        
        System.out.println("机票的价格为: " + price * calculateDiscount(month, seatLevel));
    }
}
