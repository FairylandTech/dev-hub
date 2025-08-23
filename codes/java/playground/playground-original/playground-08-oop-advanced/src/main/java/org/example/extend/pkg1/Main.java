/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-18 12:05:14 UTC+08:00
 ****************************************************/
package org.example.extend.pkg1;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        Husky husky = new Husky("哈士奇", 2);
        System.out.println("husky.name = " + husky.name);
        System.out.println("husky.age = " + husky.age);
        
        husky.eat();
        husky.drink();
        husky.lookHouse();
        husky.breakHouse();
    }
}
