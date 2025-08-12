/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-12 18:16:52 UTC+08:00
 ****************************************************/
package org.example;

/**
 * @author Lionel Johnson
 */
public class ArithmeticOperator {

    // 算数运算符

    public static void main(String[] args) {

        // +
        System.out.println(1 + 1); // 2
        // -
        System.out.println(2 - 1); // 1
        // *
        System.out.println(2 * 2); // 4

        // 在代码中如果有小数计算, 结果有可能是不精确的
        System.out.println(1.1 + 1.01);
        System.out.println(1.1 + 1.1);

        System.out.println(1.1 - 1.01);
        System.out.println(1.1 * 1.01);

        // /
        System.out.println(10 / 2);
        System.out.println(10 / 3);  // 整数参数计算只能得到整数结果
        System.out.println(10.0 / 3); // 3.3333333333333335

        // %, 取余, 取模
        // 应用: 1. 判断一个数是奇数还是偶数 2. 判断一个数能否被另一个数整除
        System.out.println(10 % 2); // 0
        System.out.println(10 % 3); // 1

    }

}
