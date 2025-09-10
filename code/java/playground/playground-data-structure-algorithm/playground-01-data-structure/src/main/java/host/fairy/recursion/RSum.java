/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-09-10 15:00:23 UTC+08:00
 ****************************************************/
package host.fairy.recursion;

/**
 * @author Lionel Johnson
 * @version 1.0
 * @deprecated RSum: 递归求和
 */
public class RSum {
    public static Long sum(Long n) {
        if (n == 1) {
            return 1L;
        }

        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sum(1000000L));
    }
}
