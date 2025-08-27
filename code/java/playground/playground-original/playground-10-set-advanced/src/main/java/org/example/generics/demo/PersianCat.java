/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-21 15:14:48 UTC+08:00
 ****************************************************/
package org.example.generics.demo;

/**
 * @author Lionel Johnson
 */
public class PersianCat extends Cat{
    public PersianCat(String name, int age) {
        super(name, age);
    }
    
    @Override
    public void eat() {
        System.out.printf("一只叫做%s的, %s岁的波斯猫, 正在吃小饼干\n", super.name(), super.age());
    }
}
