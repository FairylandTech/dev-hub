/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-18 19:18:03 UTC+08:00
 ****************************************************/
package org.example.extend.pkg3;

/**
 * @author Lionel Johnson
 */
public class Main {
    /*
     * 抽象类和抽象方法的注意事项
     *  抽象类不能实例化
     *  抽象类中不一定有抽象方法，有抽象方法的类一定是抽象类
     *  可以有构造方法
     *  抽象类的子类
     *  要么重写抽象类中的所有抽象方法
     *  要么是抽象类
     * */
    public static void main(String[] args) {
        Person person = new Person();
        person.method();
    }
}
