/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 10:25:18 UTC+08:00
 ****************************************************/
package org.example.loop.demo;

/**
 * @author Lionel Johnson
 */
public class Demo10 {
    /*
     * 小老虎吃包子，吃完第三个就吃饱了
     * */
    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            if (i == 4) {
                System.out.println("小老虎吃饱了!");
                break;
            }
            System.out.println("小老虎在吃" + i + "个包子");
        }
    }
}
