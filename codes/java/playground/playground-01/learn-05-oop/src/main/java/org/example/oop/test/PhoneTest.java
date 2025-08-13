/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-13 19:51:02 UTC+08:00
 ****************************************************/
package org.example.oop.test;

import org.example.oop.Phone;

/**
 * @author Lionel Johnson
 */
public class PhoneTest {
    public static void main(String[] args) {
        Phone phone = new Phone();
        
        // 给属性赋值
        phone.brand = "Apple";
        phone.price = 2888.99;
        
        // 获取属性的值
        System.out.println("品牌: " + phone.brand);
        System.out.println("价格: " + phone.price);
        // 调用类的方法
        phone.call();
        phone.playGame();
    }
}
