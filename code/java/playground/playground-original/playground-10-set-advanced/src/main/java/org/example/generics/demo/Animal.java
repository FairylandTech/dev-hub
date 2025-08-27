/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-21 15:07:44 UTC+08:00
 ****************************************************/
package org.example.generics.demo;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Lionel Johnson
 */
public abstract class Animal {
    private String name;
    private int age;
    
    private Animal() {
    }
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String name() {
        return name;
    }
    
    public Animal setName(String name) {
        this.name = name;
        return this;
    }
    
    public int age() {
        return age;
    }
    
    public Animal setAge(int age) {
        this.age = age;
        return this;
    }
    
    public abstract void eat();
    
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("age", age)
                .toString();
    }
}
