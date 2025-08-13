/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 13:11:14 UTC+08:00
 ****************************************************/
package org.example.array.demo;

import java.util.Arrays;

/**
 * @author Lionel Johnson
 */
public class Demo6 {
    /*
     * 需求：定义一个数组，存入1,2,3,4,5。按照要求交换索引对应的元素。
     * 交换前： 1,2,3,4,5
     * 交换后：5,2,3,4,1
     * */
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        
        int left = array1[0];
        int right = array1[array1.length - 1];
        
        array1[0] = right;
        array1[array1.length - 1] = left;
        
        System.out.println(Arrays.toString(array1));
        
        
        int[] array2 = {1, 2, 3, 4, 5};
        // 反序
        for (int i = 0, j = array2.length - 1; i < j; i++, j--) {
            int left1 = array2[i];
            int right2 = array2[j];
            
            array2[i] = right2;
            array2[j] = left1;
            
        }
        System.out.println(Arrays.toString(array2));
    }
}
