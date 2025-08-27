/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 12:46:15 UTC+08:00
 ****************************************************/
package org.example.array.demo;

/**
 * @author Lionel Johnson
 */
public class Demo4 {
    public static void main(String[] args) {
        int[] ints = {10, 33, 21, 25, 15};
        
        int maxNumber = 0;
        for (int e : ints) {
            if (maxNumber < e) {
                maxNumber = e;
            }
        }
        
        System.out.println("最大值为: " + maxNumber);
        
        // 第二种写法
        int maxNumber2 = ints[0];
        
        for (int i = 1; i < ints.length; i++) {
            if (maxNumber2 < ints[i]) {
                maxNumber2 = ints[i];
            }
        }
        
        System.out.println("最大值为: " + maxNumber2);
    }
}
