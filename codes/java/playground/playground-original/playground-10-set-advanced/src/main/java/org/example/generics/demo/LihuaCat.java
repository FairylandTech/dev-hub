/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-21 15:17:34 UTC+08:00
 ****************************************************/
package org.example.generics.demo;

/**
 * @author Lionel Johnson
 */
public class LihuaCat extends Cat {
    public LihuaCat(String name, int age) {
        super(name, age);
    }
    
    @Override
    public void eat() {
        System.out.printf("一只叫做%s的, %s岁的狸花猫, 正在吃鱼\n", super.name(), super.age());
    }
}
