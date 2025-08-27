/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 14:42:34 UTC+08:00
 ****************************************************/
package org.example.method.demo;

/**
 * @author Lionel Johnson
 */
public class Demo6 {
    public static boolean compare(byte a, byte b) {
        return a == b;
    }
    
    public static boolean compare(short a, short b) {
        return a == b;
    }
    
    public static boolean compare(int a, int b) {
        return a == b;
    }
    
    public static boolean compare(long a, long b) {
        return a == b;
    }
    
    public static void main(String[] args) {
        System.out.println(compare(1, 2));
    }
}
