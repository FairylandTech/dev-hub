/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 10:22:09 UTC+08:00
 ****************************************************/
package org.example.loop.demo;

/**
 * @author Lionel Johnson
 */
public class Demo9 {
    /*
     * 小老虎吃包子，第三个包子有虫子，跳过
     * */
    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println("小老虎在吃" + i + "个包子");
        }
    }
}
