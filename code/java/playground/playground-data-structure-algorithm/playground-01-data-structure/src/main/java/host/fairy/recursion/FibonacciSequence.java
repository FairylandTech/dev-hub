/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-07 21:10:36 UTC+08:00
 ****************************************************/
package host.fairy.recursion;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 递归实现斐波那契数列
 * <p>1. 全局缓存</p>
 * <p>2. 局部缓存</p>
 *
 * @author Lionel Johnson
 */
public class FibonacciSequence {
    // 全局缓存
    private static final HashMap<Integer, Integer> CACHE_HASH_MAP = new HashMap<>();
    
    // 初始化缓存数据
    static {
        CACHE_HASH_MAP.put(0, 0);
        CACHE_HASH_MAP.put(1, 1);
    }
    
    /**
     * 递归实现斐波那契数列
     *
     * @param n 斐波那契数列的第n项
     * @return 结果
     * @throws IllegalArgumentException n必须为非负数
     */
    private static Integer fibonacci(Integer n) throws IllegalArgumentException {
        if (n == null || n < 0) {
            throw new IllegalArgumentException("n必须为非负数");
        }
        
        // 如果缓存中存在，直接返回
        if (CACHE_HASH_MAP.containsKey(n)) return CACHE_HASH_MAP.get(n);
        
        // 初始化局部缓存
        HashMap<Integer, Integer> cacheHashMap = new HashMap<>();
        cacheHashMap.put(0, 0);
        cacheHashMap.put(1, 1);
        
        return fibonacciCache(n, cacheHashMap);
    }
    
    private static Integer fibonacciCache(Integer n, HashMap<Integer, Integer> cacheHashMap) {
        // 如果缓存中存在，直接返回
        if (cacheHashMap.containsKey(n)) return cacheHashMap.get(n);
        
        // 先从全局缓存中取，没有再递归计算
        Integer x = CACHE_HASH_MAP.containsKey(n - 1) ? CACHE_HASH_MAP.get(n - 1) : fibonacciCache(n - 1, cacheHashMap);
        Integer y = CACHE_HASH_MAP.containsKey(n - 2) ? CACHE_HASH_MAP.get(n - 2) : fibonacciCache(n - 2, cacheHashMap);
        
        // 计算结果并存入缓存
        cacheHashMap.put(n, x + y);
        CACHE_HASH_MAP.put(n, x + y);
        return cacheHashMap.get(n);
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 10; i < 14; i++) {
            list.add(fibonacci(i));
        }
        System.out.println("list = " + list);
    }
}
