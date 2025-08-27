/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-18 18:19:06 UTC+08:00
 ****************************************************/
package org.example.extend.demo.demo2;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Lionel Johnson
 */
public class Person {
    private String name;
    private int age;
    
    public Person() {
    }
    
    public Person(String name, int age) {
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
    
    public void keepPet(Dog dog, String something) {
        System.out.printf("年龄为%s岁的%s养了一只%s颜色的%s岁的狗\n", age, name, dog.getColor(), dog.getAge());
        dog.eat(something);
    }
    
    public void keepPet(Cat cat, String something) {
        System.out.printf("年龄为%s岁的%s养了一只%s颜色的%s岁的猫\n", age, name, cat.getColor(), cat.getAge());
        cat.eat(something);
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("age", age)
                .toString();
    }
}
