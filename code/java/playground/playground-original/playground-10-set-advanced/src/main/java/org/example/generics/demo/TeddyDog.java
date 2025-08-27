/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-21 15:19:30 UTC+08:00
 ****************************************************/
package org.example.generics.demo;

/**
 * @author Lionel Johnson
 */
public class TeddyDog extends Dog {
    public TeddyDog(String name, int age) {
        super(name, age);
    }
    
    @Override
    public void eat() {
        System.out.printf("一只叫做%s的, %s岁的泰迪, 正在吃骨头, 边吃边蹭\n", super.name(), super.age());
    }
}
