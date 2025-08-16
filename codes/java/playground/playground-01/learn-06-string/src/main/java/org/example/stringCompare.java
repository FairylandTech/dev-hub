/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-16 14:56:36 UTC+08:00
 ****************************************************/
package org.example;

/**
 * @author Lionel Johnson
 */
public class stringCompare {
    public static void main(String[] args) {
        String s1 = "Abc";
        String s2 = "abc";
        
        // 在引用数据类型中, == 比较地址值
        // 在基本数据类型中, == 比较数据值
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));  // 比较字符串的内容
        System.out.println(s1.equalsIgnoreCase(s2));  // 比较字符串的内容, 忽略大小写
    }
}
