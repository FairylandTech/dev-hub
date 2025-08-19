/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-19 21:46:10 UTC+08:00
 ****************************************************/
package org.example.math;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        // abs 绝对值
        System.out.println(Math.abs(-4.6));
        // ceil 向上取整 整数部分 +1
        System.out.println(Math.ceil(4.13));
        // floor 向下取整 整数部分 -1
        System.out.println(Math.floor(-4.13));
        // round 四舍五入
        System.out.println(Math.round(1.46));
        System.out.println(Math.round(1.56));
        // max 取2个数的最大值
        System.out.println(Math.max(10, 20));
        // min 取2个数的最小值
        System.out.println(Math.min(13.3, 20));
        // pow a的b次幂, 建议 b >= 1 
        System.out.println(Math.pow(2, 3));
        // sqrt 开平方根
        System.out.println(Math.sqrt(4));
        // cbrt 开立方根
        System.out.println(Math.cbrt(27));
        // random 随机获取 0.0 - 1.0 之间的 double 数
        System.out.println(Math.random());
        
        // 获取 1-100 的随机数
        System.out.println(Math.floor(Math.random() * 100) + 1);
    }
}
