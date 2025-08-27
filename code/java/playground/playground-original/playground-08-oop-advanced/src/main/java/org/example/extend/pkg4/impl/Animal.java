/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-18 19:44:34 UTC+08:00
 ****************************************************/
package org.example.extend.pkg4.impl;

/**
 * @author Lionel Johnson
 */
public class Animal {
    private String name;
    private int age;
    
    public Animal() {
    }
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void eat() {
        System.out.println("吃东西");
    }
}
