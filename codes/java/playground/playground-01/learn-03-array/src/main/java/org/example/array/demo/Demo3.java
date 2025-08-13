/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 12:36:47 UTC+08:00
 ****************************************************/
package org.example.array.demo;

import java.util.Arrays;

/**
 * @author Lionel Johnson
 */
public class Demo3 {
    /*
     * 定义一个数组， 存储1,2,3,4,5,6,7,8,9,10
     * 遍历数组得到每一个元素
     * 要求:
     * 如果是奇数，则将当前数字扩大两倍
     * 如果是偶数，则将当前数字变成二分之一
     * */
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] % 2 == 0) {
                ints[i] = ints[i] / 2;
            } else {
                ints[i] = ints[i] * 2;
            }
        }
        
        System.out.println(Arrays.toString(ints));
    }
    
    
}
