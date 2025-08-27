/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-20 17:55:59 UTC+08:00
 ****************************************************/
package org.example.regex;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        String qqNumber = "489261538";
        
        boolean matches = qqNumber.matches("[1-9]\\d{5,19}");
        
        System.out.println(matches);
    }
}
