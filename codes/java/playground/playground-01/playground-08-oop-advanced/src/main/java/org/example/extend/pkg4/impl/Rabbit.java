/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-18 19:52:16 UTC+08:00
 ****************************************************/
package org.example.extend.pkg4.impl;

/**
 * @author Lionel Johnson
 */
public class Rabbit extends Animal {
    public Rabbit() {
    }
    
    public Rabbit(String name, int age) {
        super(name, age);
    }
    
    @Override
    public void eat() {
        System.out.println("吃胡萝卜");
    }
}
