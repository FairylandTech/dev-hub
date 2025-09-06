/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-06 15:47:21 UTC+08:00
 ****************************************************/
package host.fairy.recursion;

import java.util.Arrays;

/**
 * 递归实现冒泡排序
 *
 * @author Lionel Johnson
 */
public class RecursiveBubbleSorting {
    public static void main(String[] args) {
        Integer[] array = {5, 3, 8, 6, 2};
        System.out.println("array = " + Arrays.toString(array));
        bubbleSorting(array);
        System.out.println("array = " + Arrays.toString(array));
    }
    
    public static void bubbleSorting(Integer[] array) {
        recursiveSorting(array, array.length - 1);
    }
    
    /**
     * 递归冒泡排序
     *
     * @param array 待排序数组
     * @param index 未排序部分的最后一个索引
     */
    private static void recursiveSorting(Integer[] array, Integer index) {
        if (index.equals(0)) {
            return;
        }
        
        int x = 0;
        for (int i = 0; i < index; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                x = i;
            }
        }
        
        recursiveSorting(array, x);
    }
}
