/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-18 18:11:19 UTC+08:00
 ****************************************************/
package org.example.extend.demo.demo2;

/**
 * @author Lionel Johnson
 */
public class Cat extends Pet {
    public Cat() {
    }
    
    public Cat(String color, int age) {
        super(color, age);
    }
    
    @Override
    public void eat(String something) {
        System.out.printf("%s岁的%s颜色的猫眯着眼睛侧着头吃%s\n", getAge(), getColor(), something);
    }
}

