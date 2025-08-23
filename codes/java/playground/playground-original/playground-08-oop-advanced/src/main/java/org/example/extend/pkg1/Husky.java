/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-18 12:02:32 UTC+08:00
 ****************************************************/
package org.example.extend.pkg1;

/**
 * @author Lionel Johnson
 */
public class Husky extends Dog {
    int age;
    
    public Husky(String name, int age) {
        super(name);
        this.age = age;
    }
    
    public void breakHouse() {
        System.out.println("拆家");
    }
}
