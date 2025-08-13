/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 14:09:10 UTC+08:00
 ****************************************************/
package org.example.method.demo;

/**
 * @author Lionel Johnson
 */
public class Demo2 {
    public static void calcRectangleCircumference(int length, int wide) {
        System.out.println((length + wide) * 2);
    }
    
    public static void calcRectangleCircumference(double length, double wide) {
        System.out.println((length + wide) * 2);
    }
    
    public static void calcRectangleCircumference(long length, long wide) {
        System.out.println((length + wide) * 2);
    }
    
    public static void main(String[] args) {
        calcRectangleCircumference(3, 4);
    }
}
