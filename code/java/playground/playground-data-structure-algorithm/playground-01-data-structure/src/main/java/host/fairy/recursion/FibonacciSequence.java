/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-07 21:10:36 UTC+08:00
 ****************************************************/
package host.fairy.recursion;

import java.util.ArrayList;

/**
 * 递归实现斐波那契数列
 *
 * @author Lionel Johnson
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            list.add(fibonacci(i));
        }
        System.out.println("list = " + list);
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
            throw new IllegalArgumentException("n must be non-negative");
        }
        
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }
        
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
