/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-06 14:16:02 UTC+08:00
 ****************************************************/
package host.fairy.recursion;

/**
 * 计算阶乘
 *
 * @author Lionel Johnson
 */
public class Factorial {
    public static void main(String[] args) {
        Integer result = factorial(5);
        System.out.println("result = " + result);
    }
    
    /**
     * 计算 n 的阶乘
     *
     * @param n 非负整数
     * @return n的阶乘
     * @throws IllegalArgumentException 当 n 为负数时抛出异常
     */
    public static Integer factorial(Integer n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        
        if (n == 0 || n == 1) {
            return 1;
        }
        
        return n * factorial(n - 1);
    }
}
