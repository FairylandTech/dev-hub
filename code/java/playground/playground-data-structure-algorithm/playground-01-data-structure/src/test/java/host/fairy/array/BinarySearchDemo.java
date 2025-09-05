/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-30 20:57:34 UTC+08:00
 ****************************************************/
package host.fairy.array;

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
            int mid = left + (right - left) / 2; // 计算中间索引, 
            
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
        /*
        * 时间复杂度计算
        * 假设 array.length = n
        * left = 0 执行1次
        * right = array.length 执行1次
        * left < right 执行floor(log_2(n)) + 1次
        * mid = (left + right) >>> 1 执行floor(log_2(n))次
        * target < array[mid] 执行floor(log_2(n))次
        * target > array[mid] 执行floor(log_2(n))次
        * left = mid + 1 执行floor(log_2(n))次
        * return 执行1次
        * 
        * 算法运行语句总次数: floor(log_2(n)) * 5 + 4
        * */
        int left = 0, right = array.length;
        
        while (left <= right) {
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
    
    /**
     * 遍历查找
     *
     * @param array  有序数组
     * @param target 目标值
     * @return 目标值索引，未找到返回 -1
     */
    public static Integer binarySearchTraverse(Integer[] array, Integer target) {
        /*
         * 时间复杂度计算
         * 假设 array.length = n
         * i = 0 执行1次
         * i < array.length 执行n+1次
         * i++ 执行n次
         * array[i].equals(target) 执行n次
         * return 执行1次
         *
         * 算法运行语句总次数: 3n+3
         * */
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * 二分查找平衡版
     *
     * @param arrays 有序数组
     * @param target 目标值
     * @return 目标值索引，未找到返回 -1
     */
    public static int binarySearchBalance(int[] arrays, int target) {
        int left = 0, right = arrays.length;
        while (1 < right - left) {
            int m = (left + right) >>> 1;
            if (target < arrays[m]) {
                right = m;
            } else {
                left = m;
            }
        }
        return (arrays[left] == target) ? left : -1;
    }
    
    /**
     * JDK 源码版
     *
     * @param a   有序数组
     * @param key 目标值
     * @return 目标值索引，未找到返回 -1
     */
    private static int binarySearch0(long[] a, int fromIndex, int toIndex, long key) {
        int low = fromIndex;
        int high = toIndex - 1;
        
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = a[mid];
            
            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
    
    /**
     * 查找左侧边界的二分查找
     *
     * @param array  有序数组
     * @param target 目标值
     * @return 目标值索引，未找到返回 -1
     */
    public static int binarySearchLeftmost1(int[] array, int target) {
        int left = 0, right = array.length - 1;
        int candidate = -1;
        while (left <= right) {
            int m = (left + right) >>> 1;
            if (target < array[m]) {
                right = m - 1;
            } else if (array[m] < target) {
                left = m + 1;
            } else {
                candidate = m;  // 记录候选位置
                right = m - 1;  // 继续向左
            }
        }
        return candidate;
    }
    
    /**
     * 查找右侧边界的二分查找
     *
     * @param array  有序数组
     * @param target 目标值
     * @return 目标值索引，未找到返回 -1
     */
    public static int binarySearchRightmost1(int[] array, int target) {
        int left = 0, right = array.length - 1;
        int candidate = -1;
        while (left <= right) {
            int m = (left + right) >>> 1;
            if (target < array[m]) {
                right = m - 1;
            } else if (array[m] < target) {
                left = m + 1;
            } else {
                candidate = m;  // 记录候选位置
                left = m + 1;  // 继续向右
            }
        }
        return candidate;
    }
}
