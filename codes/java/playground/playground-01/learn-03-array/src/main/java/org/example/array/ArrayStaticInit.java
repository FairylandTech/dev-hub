/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 12:09:27 UTC+08:00
 ****************************************************/
package org.example.array;


/**
 * @author Lionel Johnson
 */
public class ArrayStaticInit {
    public static void main(String[] args) {
        // 静态初始化数组-完整格式
        int[] ints = new int[]{1, 2, 3};
        // 静态初始化数组-简化格式
        int[] ints1 = {1, 2, 3};
        
        // 存储5个学生的年龄
        int[] ages = {21, 22, 22, 23, 25};
        // 存储5个学生的姓名
        String[] names = {"高雅涵", "康丽", "尹勇", "陆清妍", "彭佳钰"};
        // 存储5个学生的身高
        double[] heights = {1.66, 1.75, 1.86, 1.56, 1.66};
    }
}
