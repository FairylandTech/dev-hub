/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-15 21:09:13 UTC+08:00
 ****************************************************/
package host.fairy.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Leetcode 1
 * <p>给定一个整数数组 {@code nums} 和一个整数目标值 {@code target}，请你在该数组中找出 和为目标值 {@code target}  的那 两个 整数，并返回它们的数组下标。</p>
 * <p>你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。</p>
 * <p>你可以按任意顺序返回答案。</p>
 *
 * @author Lionel Johnson
 * @version 1.0
 * @see <a href="https://leetcode.cn/problems/two-sum/">Leet Code Link</a>
 */
public class LeetCode1 {
    /**
     * Two Sum.
     *
     * @param nums   Integet array.
     * @param target Target value.
     * @return Two index or null if not found.
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hashMap.containsKey(complement)) {
                return new int[]{hashMap.get(complement), i};
            }
            hashMap.put(nums[i], i);
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        if (result != null) {
            System.out.println(Arrays.toString(result));
        }
    }
}
