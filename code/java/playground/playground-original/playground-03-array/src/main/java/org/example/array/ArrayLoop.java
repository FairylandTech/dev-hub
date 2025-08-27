/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 12:27:05 UTC+08:00
 ****************************************************/
package org.example.array;

/**
 * @author Lionel Johnson
 */
public class ArrayLoop {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
        
        // ints.length: 获取数组的长度
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
        
        System.out.println("--分割线--");
        
        // 增强 for 的写法
        for (int e : ints) {
            System.out.println(e);
        }
    }
}
