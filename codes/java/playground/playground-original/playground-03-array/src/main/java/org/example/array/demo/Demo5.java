/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 12:52:59 UTC+08:00
 ****************************************************/
package org.example.array.demo;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Lionel Johnson
 */
public class Demo5 {
    /*
     * 需求：生成10个1~100之间的随机数存入数组
     * 1)求出所有数据的和
     * 2)求所有数据的平均数
     * 3)统计有多少个数据比平均值小
     * */
    public static void main(String[] args) {
        int[] ints = new int[10];
        
        for (int i = 0; i < ints.length; i++) {
            ints[i] = new Random().nextInt(100) + 1;
        }
        
        System.out.println("随机生成的数组为: " + Arrays.toString(ints));
        
        // 1. 求出所有数据的和
        int sum = 0;
        for (int e : ints) {
            sum += e;
        }
        System.out.println("和为: " + sum);
        
        // 2. 平均数
        int avg = sum / ints.length;
        System.out.println("平均数为: " + avg);
        
        // 3. 统计有多少个数据比平均值小
        int counter = 0;
        for (int e : ints) {
            if (e > avg) {
                counter++;
            }
        }
        
        System.out.println("有" + counter + "个数据比平均值小");
        
        
    }
}
