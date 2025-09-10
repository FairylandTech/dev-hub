/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-30 20:57:34 UTC+08:00
 ****************************************************/
package host.fairy.demo;

/**
 * 二分查找Demo
 *
 * @author Lionel Johnson
 */
public class BinarySearchDemo {
    
    public static void main(String[] args) {
        Integer[] a = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        Integer target = 20;
        Integer result = binarySearch(a, target);
        
        System.out.println("目标值 " + target + " 的索引为: " + result);
    }
    
    /**
     * 二分查找基础版
     *
     * @param array  有序数组
     * @param target 目标值
     * @return 目标值索引，未找到返回 -1
     */
    public static Integer binarySearchBasic(Integer[] array, Integer target) {
        int left = 0, right = array.length - 1;  // 初始化左右指针
        
        while (left <= right) {  // 当左指针小于等于右指针时继续循环
            int mid = (right + left) / 2; // 计算中间索引, 
            
            if (target < array[mid]) {  // 目标值小于中间值
                right = mid - 1;  // 将右指针移动到中间索引左侧
            } else if (target > array[mid]) {  // 目标值大于中间值
                left = mid + 1;  // 将左指针移动到中间索引右侧
            } else {  // 找到目标值
                return mid;  // 返回目标值索引
            }
        }
        
        return -1;
    }
    
    /**
     * 二分查找
     *
     * @param array  有序数组
     * @param target 目标值
     * @return 目标值索引，未找到返回 -1
     */
    public static Integer binarySearch(Integer[] array, Integer target) {
        int left = 0, right = array.length;
        
        while (left < right) {
            int mid = (left + right) >>> 1;  // 无符号右移, 右移运算符
            
            if (target < array[mid]) {
                right = mid;
            } else if (target > array[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        
        return -1;
    }
}
