/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-20 12:51:37 UTC+08:00
 ****************************************************/
package org.example.system;

import org.example.math.demo.PrimeNumber;

import java.util.Arrays;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        // 13位时间戳 System.currentTimeMillis()
        System.out.println(System.currentTimeMillis());
//        runningDuration();
        // 数组拷贝 System.arraycopy(源数组, 源数组开始索引, 目标数组, 目标数组开始索引, 拷贝的个数)
        int[] srcArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] targetArray = new int[10];
        int[] targetArray2 = new int[10];
        System.out.println(Arrays.toString(srcArray));
        System.arraycopy(srcArray, 0, targetArray, 1, 3);
        System.out.println(Arrays.toString(targetArray));
        
        System.arraycopy(srcArray, 0, targetArray2, 4, 3);
        System.out.println(Arrays.toString(targetArray2));
        
        // 停止虚拟机, 0->正常停止, 后面的代码不会执行
        System.exit(0);
        System.out.println("System.exit() 后面的代码不会执行");
    }
    
    public static void runningDuration() {
        long startTime = System.currentTimeMillis();
        
        for (int i = 2; i < 100000; i++) {
            if (PrimeNumber.isPrimeNumber2(i)) {
                System.out.println(i);
            }
        }
        
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
