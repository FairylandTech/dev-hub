/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 12:30:21 UTC+08:00
 ****************************************************/
package org.example.array.demo;

/**
 * @author Lionel Johnson
 */
public class Demo1 {
    // 遍历数组并求和
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
        
        int sum = 0;
        for (int e : ints) {
            sum += e;
        }
        
        System.out.println("数组的和为: " + sum);
    }
}
