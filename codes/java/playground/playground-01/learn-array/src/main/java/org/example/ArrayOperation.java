/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-12 15:58:42 UTC+08:00
 ****************************************************/
package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Lionel Johnson
 */
public class ArrayOperation {

    public static void init() {

        // 数组静态初始化
        int[] arrayStatic = new int[]{1, 2, 3};

        // 数组动态初始化
        int[] arrayDynamic = new int[3];
        String[] strings = new String[20];

    }

    public static void operation() {

        // 1.初始化一个数组
        int[] ints = new int[]{1, 2, 3, 4, 5};

        // 使用切片(索引)获取值
        int slice1 = ints[1];
        System.out.println(slice1);
        System.out.println(ints[0]);

        // 根据索引重新赋值
        ints[3] = 200;

        System.out.println(Arrays.toString(ints));

    }

    public static void main(String[] args) {

        operation();

    }

}
