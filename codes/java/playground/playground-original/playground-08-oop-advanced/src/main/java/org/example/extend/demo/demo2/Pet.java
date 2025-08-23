/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-18 18:11:55 UTC+08:00
 ****************************************************/
package org.example.extend.demo.demo2;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Lionel Johnson
 */
public class Pet {
    private int age;
    private String color;
    
    public Pet() {
    }
    
    public Pet(String color, int age) {
        this.color = color;
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public void eat(String something) {
        System.out.println("吃东西" + something);
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("age", age)
                .append("color", color)
                .toString();
    }
}
