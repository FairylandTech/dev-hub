/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-12 19:42:53 UTC+08:00
 ****************************************************/
package org.example.judgment.demo;

import java.util.Scanner;

/**
 * @author Lionel Johnson
 */
public class Demo3 {

    public static void main(String[] args) {

        /*
         * 商场都会有VIP的会员制，根据不同的会员会有不同的折扣。
         * 假设商品总价为1000。
         * 键盘录入会员级别，并计算出实际支付的钱。
         * 会员1级：打9折。
         * 会员2级：打8折。
         * 会员3级：打7折。
         * 非会员：不打折，要打也是打骨折。
         * */

        int payable = 1000;

        Scanner scanner = new Scanner(System.in);
        System.out.print("会员级别: ");

        int vipLevel = scanner.nextInt();

        if (vipLevel == 1) {
            System.out.println("打9折, 实际付款:" + (payable * 0.9));
        } else if (vipLevel == 2) {
            System.out.println("打8折, 实际付款:" + (payable * 0.8));
        } else if (vipLevel == 3) {
            System.out.println("打7折, 实际付款:" + (payable * 0.7));
        } else {
            System.out.println("不打折: 实际付款:" + payable);
        }

    }

}
