/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 12:32:52 UTC+08:00
 ****************************************************/
package org.example.array.demo;

/**
 * @author Lionel Johnson
 */
public class Demo2 {
    /*
     * 定义一个数组存储1,2,3,4,5,6,7,8,9,10
     * 遍历数组得到每一个元素，统计数组里面一共有多少个能被3整除的数字
     * */
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        int counter = 0;
        for (int e : ints) {
            if (e % 3 == 0) {
                counter++;
            }
        }
        
        System.out.println("一共有" + counter + "个能被3整除");
    }
}
