/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-16 10:42:06 UTC+08:00
 ****************************************************/
package org.example.oop.demo;

import org.example.oop.demo.cls.Product;

import java.util.Arrays;

/**
 * @author Lionel Johnson
 */
public class Demo2 {
    public static void main(String[] args) {
        Product[] products = {
                new Product("手机", 2999.99, 100),
                new Product("上衣", 150, 1000),
                new Product("鞋子", 300, 1000),
        };
        
        System.out.println(Arrays.toString(products));
    }
}
