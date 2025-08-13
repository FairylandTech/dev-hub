/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 14:48:48 UTC+08:00
 ****************************************************/
package org.example.method.demo;

import java.util.Arrays;

/**
 * @author Lionel Johnson
 */
public class Demo7 {
    /*
     * 1. 遍历数组
     * 2. 数组的最大值
     * 3. 判断是否存在
     * 4. 复制数组
     * */
    public static String arrayLoop(int[] array) {
        StringBuilder result = new StringBuilder("[");
        
        for (int i = 0; i < array.length; i++) {
            if (i == (array.length - 1)) {
                result.append(array[i]).append("]");
            } else {
                result.append(array[i]).append(", ");
            }
        }
        
        return result.toString();
    }
    
    public static int maxValue(int[] array) {
        int max = array[0];
        
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        
        return max;
    }
    
    public static boolean containsArray(int[] array, int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        
        return false;
    }
    
    public static int[] copyArray(int[] array) {
        return Arrays.copyOf(array, array.length);
    }
    
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
        int contain = 5;
        System.out.println("遍历结果为:" + arrayLoop(ints));
        System.out.println("数组的最大值为: " + maxValue(ints));
        System.out.println(contain + "是否存在数组中: " + containsArray(ints, contain));
        
        System.out.println("原来数组的地址: " + ints);
        System.out.println("copy后数组的地址: " + copyArray(ints));
    }
}
