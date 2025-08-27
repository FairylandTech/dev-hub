/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-12 18:24:16 UTC+08:00
 ****************************************************/
package org.example;

/**
 * @author Lionel Johnson
 */
public class ConvertType {

    public static void autoConvert() {
        // 自动类型转换
        // 1. byte, short, char -> int -> long -> float -> double
        // 2. byte, short, char 相互之间不会自动转换
        // 3. boolean 不参与自动类型转换

        byte a1 = 10;
        byte a2 = 20;
        int result = a1 + a2;
        byte resultByte = (byte) (a1 + a2);
        System.out.println(result);
        System.out.println(resultByte);

        // 类型转化异常, 大转小, 如果数据过大, 会发生数据溢出
        try {
            int num = 300;
            byte b = (byte) num;
            System.out.println(b);
        } catch (Exception exception) {
            System.out.println("类型转换异常: " + exception);
        }

    }

    public static void jointString() {
        // 字符串拼接, 只要有字符串参与, 那么其他数据类型都会转换为字符串
        System.out.println("123" + 123);  // 123123
        System.out.println(1 + 2 + "123");  // 3123
        System.out.println("123" + 1 + 2);  // 12312
    }

    public static void jointChar() {
        char a = 'a';
        char b = 'b';
        System.out.println(a + b);
    }

    public static void main(String[] args) {
        autoConvert();
        jointString();
        jointChar();
    }

}
