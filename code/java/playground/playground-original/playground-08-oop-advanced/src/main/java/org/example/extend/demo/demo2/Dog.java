/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-18 18:06:57 UTC+08:00
 ****************************************************/
package org.example.extend.demo.demo2;

/**
 * @author Lionel Johnson
 */
public class Dog extends Pet {
    public Dog() {
    }
    
    public Dog(String color, int age) {
        super(color, age);
    }
    
    @Override
    public void eat(String something) {
        System.out.printf("%s岁的%s颜色的狗两只前腿死死的抱住%s猛吃\n", getAge(), getColor(), something);
    }
    
    public void lookHome() {
        System.out.println("看家");
    }
}
