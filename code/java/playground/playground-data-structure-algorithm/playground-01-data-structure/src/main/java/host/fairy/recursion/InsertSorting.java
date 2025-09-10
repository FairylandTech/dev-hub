/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-06 19:23:53 UTC+08:00
 ****************************************************/
package host.fairy.recursion;

import java.util.Arrays;

/**
 * 递归实现插入排序
 *
 * @author Lionel Johnson
 */
public class InsertSorting {
    public static void main(String[] args) {
        Integer[] array = {12, 5, 3, 6, 4, 8, 7};
        insertSort(array, 1);
        System.out.println("array = " + Arrays.toString(array));
    }
    
    /**
     * 递归实现插入排序
     *
     * @param array 待排序数组
     * @param n     当前处理的元素下标
     */
    public static void insertSort(Integer[] array, Integer n) {
        if (n.equals(array.length)) {
            return;
        }
        
        int t = array[n];
        int index = n - 1;
        
        while (index >= 0 && array[index] > t) {
            array[index + 1] = array[index];
            index--;
        }
        
        array[index + 1] = t;
        
        insertSort(array, n + 1);
    }
}
