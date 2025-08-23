/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-17 21:51:27 UTC+08:00
 ****************************************************/
package org.example.staticmethod;


import jakarta.validation.constraints.NotNull;

import java.util.Arrays;

/**
 * @author Lionel Johnson
 */
public class arrayUtils {
    private arrayUtils() {
    }
    
    public static String array2String(@NotNull int[] array) {
        return Arrays.toString(array);
    }
    
    public static String array2String(@NotNull String[] array) {
        return Arrays.toString(array);
    }
    
    public static int arrayAverage(@NotNull int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum / array.length;
    }
    
    public static double arrayAverage(@NotNull double[] array) {
        double sum = 0;
        for (double i : array) {
            sum += i;
        }
        return sum / array.length;
    }
}
