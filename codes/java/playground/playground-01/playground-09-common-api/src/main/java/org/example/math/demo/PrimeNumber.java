/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-20 12:01:27 UTC+08:00
 ****************************************************/
package org.example.math.demo;

/**
 * @author Lionel Johnson
 */
public class PrimeNumber {
    public static void main(String[] args) {
        boolean result = isPrimeNumber(997);
        System.out.println(result);
    }
    
    public static boolean isPrimeNumber(int number) {
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isPrimeNumber2(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
