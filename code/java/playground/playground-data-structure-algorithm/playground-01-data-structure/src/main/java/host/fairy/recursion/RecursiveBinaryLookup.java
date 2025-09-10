/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-06 15:00:15 UTC+08:00
 ****************************************************/
package host.fairy.recursion;

/**
 * 递归实现二分查找
 *
 * @author Lionel Johnson
 */
public class RecursiveBinaryLookup {
    public static void main(String[] args) {
        System.out.println("binaryLookup(new Integer[]{1,2,3,4,5,6,7}, 2) = " + binaryLookup(new Integer[]{1, 2, 3, 4, 5, 6, 7}, 2));
    }
    
    public static Integer binaryLookup(Integer[] array, Integer target) {
        return recursiveLookup(array, target, 0, array.length - 1);
    }
    
    /**
     * 递归二分查找
     *
     * @param array  有序数组
     * @param target 目标值
     * @param left   左边界
     * @param right  右边界
     * @return 目标值索引，未找到返回 -1
     */
    private static Integer recursiveLookup(Integer[] array, Integer target, Integer left, Integer right) {
        if (left > right) {
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        
        if (target > array[mid]) {
            return recursiveLookup(array, target, mid + 1, right);
        } else if (target < array[mid]) {
            return recursiveLookup(array, target, left, mid - 1);
        } else {
            return mid;
        }
    }
}
