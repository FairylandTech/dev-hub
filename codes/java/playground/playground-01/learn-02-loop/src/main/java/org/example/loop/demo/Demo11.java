/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 10:43:08 UTC+08:00
 ****************************************************/
package org.example.loop.demo;

/**
 * @author Lionel Johnson
 */
public class Demo11 {
    /*
     * 封7过
     * 游戏规则：从任意一个数字开始报数，当你要报的数字是包含7或者是7的倍数时都要说过：过
     * 需求：使用程序在控制台打印出1-100之间的满足逢七必过规则的数据
     * */
    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            if (i % 7 == 0 || i % 10 == 7 || i / 10 == 7) {
                System.out.println(i + "符合条件, 过");
                continue;
            }
            System.out.println(i);
        }
    }
}
