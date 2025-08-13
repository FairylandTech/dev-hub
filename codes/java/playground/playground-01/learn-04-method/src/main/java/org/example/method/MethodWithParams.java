/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 14:05:17 UTC+08:00
 ****************************************************/
package org.example.method;

/**
 * @author Lionel Johnson
 */
public class MethodWithParams {
    public static void add(int a, int b) {
        System.out.println(a + b);
    }
    
    public static void main(String[] args) {
        add(10, 20);
        add(20, 30);
    }
}
