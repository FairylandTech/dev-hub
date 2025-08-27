/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-18 19:52:57 UTC+08:00
 ****************************************************/
package org.example.extend.pkg4;

import org.example.extend.pkg4.impl.Dog;
import org.example.extend.pkg4.impl.Frog;
import org.example.extend.pkg4.impl.Rabbit;

/**
 * @author Lionel Johnson
 */
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Rabbit rabbit = new Rabbit();
        Frog frog = new Frog();
        
        dog.eat();
        dog.swimming();
        
        frog.eat();
        frog.swimming();
        
        rabbit.eat();
    }
    
    
}
