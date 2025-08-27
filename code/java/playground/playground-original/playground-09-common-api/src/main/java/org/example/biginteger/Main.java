/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-20 17:18:56 UTC+08:00
 ****************************************************/
package org.example.biginteger;

import java.math.BigInteger;
import java.util.Random;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        // 获取随机 0-2的number次方-1 的大整数
        BigInteger randomBigInteger = new BigInteger(2, new Random());
        System.out.println("randomBigInteger = " + randomBigInteger);
        // 获取一个指定的大小数, 字符串中必须是整数, 否则异常
        BigInteger bigInteger = new BigInteger("1");
        System.out.println("bigInteger = " + bigInteger);
        // 获取指定进制的大整数, 字符串中是对应进制的数据, -> 输出转为10进制的大整数
        BigInteger bigInteger1 = new BigInteger("AF1", 16);
        System.out.println("bigInteger1 = " + bigInteger1);
        // 只能在 long 的范围内转为 BigInteger 类型
        BigInteger bigInteger2 = BigInteger.valueOf(Long.MAX_VALUE);
        System.out.println("bigInteger2 = " + bigInteger2);
        BigInteger bigInteger3 = BigInteger.valueOf(9223372036854775807L);
        System.out.println("bigInteger3 = " + bigInteger3);
    }
}
