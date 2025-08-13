/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 13:30:13 UTC+08:00
 ****************************************************/
package org.example.array.demo;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Lionel Johnson
 */
public class Demo7 {
    // 定义一个数组，存入1~5。要求打乱数组中所有数据的顺序。
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = {1, 2, 3, 4, 5};
        
        for (int i = 0; i < array.length; i++) {
            int randomIndex = random.nextInt(array.length);
            
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
        
        System.out.println(Arrays.toString(array));
    }
}
