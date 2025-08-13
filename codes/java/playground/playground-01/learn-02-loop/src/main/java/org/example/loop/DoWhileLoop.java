/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 10:10:42 UTC+08:00
 ****************************************************/
package org.example.loop;

/**
 * @author Lionel Johnson
 */
public class DoWhileLoop {
    public static void main(String[] args) {
        int i = 1, sum = 0;
        
        do {
            sum += i;
            i++;
        } while (i <= 100);
        
        System.out.println("1-100的和为: " + sum);
    }
}
