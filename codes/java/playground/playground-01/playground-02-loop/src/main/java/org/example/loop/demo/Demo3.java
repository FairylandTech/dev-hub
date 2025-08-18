/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-12 21:00:37 UTC+08:00
 ****************************************************/
package org.example.loop.demo;

/**
 * @author Lionel Johnson
 */
public class Demo3 {

    public static void main(String[] args) {

        int sum = 0;

        for (int i = 1; i < 6; i++) {
            sum += i;
        }

        System.out.println("1-5的和为: " + sum);

    }

}
