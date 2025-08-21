/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-21 15:20:59 UTC+08:00
 ****************************************************/
package org.example.generics.demo;

/**
 * @author Lionel Johnson
 */
public class HuskyDog extends Dog {
    public HuskyDog(String name, int age) {
        super(name, age);
    }
    
    @Override
    public void eat() {
        System.out.printf("一只叫做%s的, %s岁的哈士奇, 正在吃骨头, 边吃边拆家\n", super.name(), super.age());
    }
}
