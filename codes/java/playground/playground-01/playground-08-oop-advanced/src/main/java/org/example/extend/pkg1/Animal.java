/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-18 11:29:20 UTC+08:00
 ****************************************************/
package org.example.extend.pkg1;

/**
 * @author Lionel Johnson
 */
public class Animal {
    String name;
    
    public Animal() {
    }
    
    public Animal(String name) {
        this.name = name;
    }
    
    public void eat() {
        System.out.println("吃饭");
    }
    
    public void drink() {
        System.out.println("喝水");
    }
}
