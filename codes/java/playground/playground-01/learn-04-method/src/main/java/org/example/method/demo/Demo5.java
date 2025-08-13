/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 14:31:48 UTC+08:00
 ****************************************************/
package org.example.method.demo;

/**
 * @author Lionel Johnson
 */
public class Demo5 {
    /*
     * 定义方法，比较两个长方形的面积
     * */
    public static void compare(double s1, double s2) {
        if (s1 > s2) {
            System.out.println("第一个长方形的面积比第二个长方形的面积大.");
        } else if (s1 < s2) {
            System.out.println("第二个长方形的面积比第一个长方形的面积大.");
        } else {
            System.out.println("两个长方形的面积一样大");
        }
    }
    
    public static double area(double a, double b) {
        return a * b;
    }
    
    public static void main(String[] args) {
        compare(area(3, 4), area(5, 5));
    }
}
