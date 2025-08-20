/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-20 17:45:17 UTC+08:00
 ****************************************************/
package org.example.bigdecimal;

import java.math.BigDecimal;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(0.09 + 0.01);
        
        BigDecimal add = new BigDecimal("0.09").add(new BigDecimal("0.01"));
        System.out.println(add);
    }
}
